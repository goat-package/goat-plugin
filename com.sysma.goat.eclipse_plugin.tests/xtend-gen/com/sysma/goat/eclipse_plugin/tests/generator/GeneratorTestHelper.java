package com.sysma.goat.eclipse_plugin.tests.generator;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.generator.CodeModel;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;

@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class GeneratorTestHelper {
  public static class GoCompilerErrorsException extends Exception {
    public GoCompilerErrorsException(final String file, final List<String> issues) {
      super(((("Errors while compiling: " + file) + "\n") + IterableExtensions.join(issues, "\n")));
    }
  }
  
  public static class GoRunErrorsException extends Exception {
    public GoRunErrorsException(final String file) {
      super(("Errors while running " + file));
    }
  }
  
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  public void checkNoErrorApartInfr(final EObject obj) {
    final Function1<Resource.Diagnostic, Boolean> _function = new Function1<Resource.Diagnostic, Boolean>() {
      public Boolean apply(final Resource.Diagnostic it) {
        String _message = it.getMessage();
        return Boolean.valueOf((!Objects.equal(_message, "Couldn\'t resolve reference to Infrastructure \'infr\'.")));
      }
    };
    int _length = ((Object[])Conversions.unwrapArray(IterableExtensions.<Resource.Diagnostic>filter(obj.eResource().getErrors(), _function), Object.class)).length;
    boolean _equals = (_length == 0);
    Assert.assertTrue(_equals);
  }
  
  public void compileAndRun(final CharSequence goatCode, final Procedure2<? super String, ? super String> acceptor) {
    this.compileAndRun(goatCode, acceptor, 0);
  }
  
  public void compileAndRun(final CharSequence goatCode, final Procedure2<? super String, ? super String> acceptor, final int timeout) {
    try {
      final Model model = this._parseHelper.parse(goatCode);
      this.checkNoErrorApartInfr(model);
      final String code = new CodeModel(model).getCode().toString().replace("goat.NewComponentWithAttributes(,", "goat.NewComponentWithAttributes(goat.NewSingleServerAgent(\"127.0.0.1:17000\"),");
      final File dir = Files.createTempDir();
      final File gofile = new File(dir, "code.go");
      Files.write(code.toString().getBytes(), gofile);
      final File exefile = new File(dir, "code");
      String _path = exefile.getPath();
      String _path_1 = gofile.getPath();
      final ProcessBuilder goCompiler = new ProcessBuilder("go", "build", "-o", _path, _path_1);
      final File goInfrfile = new File(dir, "infr.go");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package main");
      _builder.newLine();
      _builder.append("import (");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\"github.com/giulio-garbi/goat/goat\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\"fmt\"");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.newLine();
      _builder.append("func main(){");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("term := make(chan struct{})");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("goat.RunCentralServer(17000, term, 2000)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("fmt.Println(\"Started\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<- term");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("fmt.Println(\"Terminated\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Files.write(_builder.toString().getBytes(), goInfrfile);
      final File exeInfrfile = new File(dir, "infr");
      String _path_2 = exeInfrfile.getPath();
      String _path_3 = goInfrfile.getPath();
      final ProcessBuilder goInfrCompiler = new ProcessBuilder("go", "build", "-o", _path_2, _path_3);
      final Process goCompilerInfrProcess = goInfrCompiler.start();
      for (boolean quit = false; (!quit);) {
        try {
          int _waitFor = goCompilerInfrProcess.waitFor();
          boolean _notEquals = (_waitFor != 0);
          if (_notEquals) {
            String _path_4 = goInfrfile.getPath();
            InputStream _errorStream = goCompilerInfrProcess.getErrorStream();
            InputStreamReader _inputStreamReader = new InputStreamReader(_errorStream);
            List<String> _readLines = CharStreams.readLines(_inputStreamReader);
            throw new GeneratorTestHelper.GoCompilerErrorsException(_path_4, _readLines);
          }
          quit = true;
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException x = (InterruptedException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      final Process goCompilerProcess = goCompiler.start();
      for (boolean quit = false; (!quit);) {
        try {
          int _waitFor = goCompilerProcess.waitFor();
          boolean _notEquals = (_waitFor != 0);
          if (_notEquals) {
            String _path_4 = gofile.getPath();
            InputStream _errorStream = goCompilerProcess.getErrorStream();
            InputStreamReader _inputStreamReader = new InputStreamReader(_errorStream);
            List<String> _readLines = CharStreams.readLines(_inputStreamReader);
            throw new GeneratorTestHelper.GoCompilerErrorsException(_path_4, _readLines);
          }
          quit = true;
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException x = (InterruptedException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      exefile.setExecutable(true);
      new Thread(new Runnable() {
        public void run() {
          try {
            String _path = exeInfrfile.getPath();
            new ProcessBuilder(_path).start();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      }).start();
      String _path_4 = exefile.getPath();
      final ProcessBuilder goRun = new ProcessBuilder(_path_4);
      final File outfile = new File(dir, "out.txt");
      final File errfile = new File(dir, "err.txt");
      goRun.redirectError(errfile);
      goRun.redirectOutput(outfile);
      final Process goRunProcess = goRun.start();
      final AtomicBoolean timedOut = new AtomicBoolean(false);
      final Timer t = new Timer();
      if ((timeout > 0)) {
        t.schedule(new TimerTask() {
          public void run() {
            timedOut.set(true);
            goRunProcess.destroy();
          }
        }, timeout);
      }
      for (boolean quit = false; (!quit);) {
        try {
          if (((goRunProcess.waitFor() != 0) && (!timedOut.get()))) {
            String _path_5 = gofile.getPath();
            throw new GeneratorTestHelper.GoRunErrorsException(_path_5);
          }
          quit = true;
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException x = (InterruptedException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        } finally {
          if ((timeout > 0)) {
            t.cancel();
          }
        }
      }
      acceptor.apply(Files.toString(outfile, Charsets.UTF_8), Files.toString(errfile, Charsets.UTF_8));
      gofile.delete();
      exefile.delete();
      exeInfrfile.delete();
      goInfrfile.delete();
      errfile.delete();
      outfile.delete();
      dir.delete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
