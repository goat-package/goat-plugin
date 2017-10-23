package com.sysma.goat.eclipse_plugin.tests.generator

import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import java.util.List
import com.google.inject.Inject
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import com.sysma.goat.eclipse_plugin.goatComponents.Model
import org.eclipse.xtext.testing.util.ParseHelper
import com.sysma.goat.eclipse_plugin.generator.CodeModel
import com.google.common.io.Files
import java.io.File
import java.io.InputStreamReader
import com.google.common.io.CharStreams
import com.google.common.base.Charsets
import org.eclipse.emf.ecore.EObject
import org.junit.Assert
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.atomic.AtomicBoolean

@InjectWith(GoatComponentsInjectorProvider)
class GeneratorTestHelper {
    @Inject extension ParseHelper<Model>
	
	static class GoCompilerErrorsException extends Exception{
		new(String file, List<String> issues){
			super("Errors while compiling: "+file+"\n"+issues.join("\n"))
		}
	}
	
	static class GoRunErrorsException extends Exception{
		new(String file){
			super("Errors while running "+file)
		}
	}
	
	def checkNoErrorApartInfr(EObject obj){
		Assert.assertTrue(obj.eResource.errors.filter[it.message != "Couldn't resolve reference to Infrastructure 'infr'."].length == 0)
	}
	
	def void compileAndRun(CharSequence goatCode, (String,String)=>void acceptor){
		compileAndRun(goatCode, acceptor, 0)
	}
	
	def void compileAndRun(CharSequence goatCode, (String,String)=>void acceptor, int timeout){
		// compile to Go
		val model = goatCode.parse
		model.checkNoErrorApartInfr
		val code = new CodeModel(model).code
			.toString.replace("goat.NewComponentWithAttributes(,", "goat.NewComponentWithAttributes(goat.NewSingleServerAgent(\"127.0.0.1:17000\"),")
		val dir = Files.createTempDir
		val gofile = new File(dir, "code.go")
		Files.write(code.toString.getBytes, gofile)
		
		// compile Go code to executable
		val exefile = new File(dir, "code")
		val goCompiler = new ProcessBuilder("go","build","-o",exefile.path,gofile.path)
		
		// infrastructure
		val goInfrfile = new File(dir, "infr.go")
		Files.write('''
		package main
		import (
			"github.com/giulio-garbi/goat/goat"
			"fmt"
		)
		
		func main(){
			
			term := make(chan struct{})
			goat.RunCentralServer(17000, term, 2000)
			fmt.Println("Started")
			<- term
			fmt.Println("Terminated")
			
		}
		'''.toString.getBytes, goInfrfile)
		val exeInfrfile = new File(dir, "infr")
		val goInfrCompiler = new ProcessBuilder("go","build","-o",exeInfrfile.path,goInfrfile.path)
		val goCompilerInfrProcess = goInfrCompiler.start
		for (var quit = false; !quit;) {
			try{
				if(goCompilerInfrProcess.waitFor != 0){
					throw new GoCompilerErrorsException(goInfrfile.path, CharStreams.readLines(new InputStreamReader(goCompilerInfrProcess.errorStream)))
				} 
				quit = true
			} catch (InterruptedException x){}
		}
		
		val goCompilerProcess = goCompiler.start
		for (var quit = false; !quit;) {
			try{
				if(goCompilerProcess.waitFor != 0){
					throw new GoCompilerErrorsException(gofile.path, CharStreams.readLines(new InputStreamReader(goCompilerProcess.errorStream)))
				} 
				quit = true
			} catch (InterruptedException x){}
		}
		exefile.executable = true
		
		new Thread(new Runnable(){
			override run(){
				new ProcessBuilder(exeInfrfile.path).start
			}
		}).start
		val goRun = new ProcessBuilder(exefile.path)
		val outfile = new File(dir, "out.txt")
		val errfile = new File(dir, "err.txt")
		goRun.redirectError(errfile)
		goRun.redirectOutput(outfile)
		
		val goRunProcess = goRun.start
		val timedOut = new AtomicBoolean(false)
		val t = new Timer()
		if(timeout > 0){
		    t.schedule(new TimerTask() {
		        override run() {
		        	timedOut.set(true)
		            goRunProcess.destroy();
		        }
		    }, timeout);
		}
		
		for (var quit = false; !quit;) {
			try{
				if(goRunProcess.waitFor != 0 && !timedOut.get){
					throw new GoRunErrorsException(gofile.path)
				} 
				quit = true
			} catch (InterruptedException x){}
			finally{
				if(timeout > 0)
					t.cancel
			}
		}
		
		acceptor.apply(Files.toString(outfile, Charsets.UTF_8),Files.toString(errfile, Charsets.UTF_8))
		
		gofile.delete
		exefile.delete
		exeInfrfile.delete
		goInfrfile.delete
		errfile.delete
		outfile.delete
		dir.delete
	}
}