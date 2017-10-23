package com.sysma.goat.eclipse_plugin.ui

import java.util.concurrent.Semaphore
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.SWT
import org.eclipse.core.runtime.IPath
import com.sysma.goat.eclipse_plugin.ui.Console
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.IWorkbenchListener
import org.eclipse.ui.IWorkbench

class RunServer {
	val IPath filePath
	val IPath projectPath
	val Console console
	
	new(IPath projectPath, IPath filePath, Console console){
		this.filePath = filePath
		this.projectPath = projectPath
		this.console = console
	}
	
	def launch(){
		val ok = new Semaphore(0);
		
		val stdout = console.newOutputStream();
	    val stderr = console.newOutputStream();
	    val stdin = console.getInputStream();
	    stderr.setColor(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
	    stdin.setColor(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
	    
		new Thread(new Runnable{
			override run() {
				val pb = new ProcessBuilder()
				val srvGoDir = projectPath.makeAbsolute().append("src-gen").append("infrastructure")
				pb.directory(srvGoDir.toFile());
				
				val srvGo = filePath.removeFileExtension.addFileExtension("go")
				if(srvGoDir.append(srvGo).toFile.exists){
					val srvGoFname = srvGo.toString
					pb.command("go","run", srvGoFname);
				    //try{
						val proc = pb.start()
						console.process = proc
						PlatformUI.workbench.addWorkbenchListener(new IWorkbenchListener(){
							override postShutdown(IWorkbench workbench) {}
							
							override preShutdown(IWorkbench workbench, boolean forced) {
								if(proc !== null && proc.alive){
									proc.descendants.forEach[destroy]
									proc.destroy()
								}
								true
							}
						})
						new Thread(new StreamCopier(stdin, proc.outputStream)).start()
						new Thread(new StreamCopier(proc.inputStream, stdout).addListener("Started",[ok.release()])).start()
						new Thread(new StreamCopier(proc.errorStream, stderr)).start()
						new Thread(new Runnable(){
							override run() {
								proc.waitFor
								ok.release
							}
						})
					//} catch (IOException ex){
					//	ok.release()
					//	ex.printStackTrace()
					//}
				} else {
					stderr.write(filePath.toString + " was not generated. Please save the file and retry.")
				}
			}
		}).start()
		var started = false;
		do{
			try{
				ok.acquire()
				started = true;
			} catch(InterruptedException exc){
			}
		}while(!started);
	}
}
