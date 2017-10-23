package com.sysma.goat.eclipse_plugin.ui;

import com.sysma.goat.eclipse_plugin.ui.Console;
import com.sysma.goat.eclipse_plugin.ui.StreamCopier;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IOConsoleInputStream;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

@SuppressWarnings("all")
public class RunServer {
  private final IPath filePath;
  
  private final IPath projectPath;
  
  private final Console console;
  
  public RunServer(final IPath projectPath, final IPath filePath, final Console console) {
    this.filePath = filePath;
    this.projectPath = projectPath;
    this.console = console;
  }
  
  public void launch() {
    final Semaphore ok = new Semaphore(0);
    final IOConsoleOutputStream stdout = this.console.newOutputStream();
    final IOConsoleOutputStream stderr = this.console.newOutputStream();
    final IOConsoleInputStream stdin = this.console.getInputStream();
    stderr.setColor(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
    stdin.setColor(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
    new Thread(new Runnable() {
      public void run() {
        try {
          final ProcessBuilder pb = new ProcessBuilder();
          final IPath srvGoDir = RunServer.this.projectPath.makeAbsolute().append("src-gen").append("infrastructure");
          pb.directory(srvGoDir.toFile());
          final IPath srvGo = RunServer.this.filePath.removeFileExtension().addFileExtension("go");
          boolean _exists = srvGoDir.append(srvGo).toFile().exists();
          if (_exists) {
            final String srvGoFname = srvGo.toString();
            pb.command("go", "run", srvGoFname);
            final Process proc = pb.start();
            RunServer.this.console.setProcess(proc);
            IWorkbench _workbench = PlatformUI.getWorkbench();
            _workbench.addWorkbenchListener(new IWorkbenchListener() {
              public void postShutdown(final IWorkbench workbench) {
              }
              
              public boolean preShutdown(final IWorkbench workbench, final boolean forced) {
                boolean _xblockexpression = false;
                {
                  if (((proc != null) && proc.isAlive())) {
                    final Consumer<ProcessHandle> _function = new Consumer<ProcessHandle>() {
                      public void accept(final ProcessHandle it) {
                        it.destroy();
                      }
                    };
                    proc.descendants().forEach(_function);
                    proc.destroy();
                  }
                  _xblockexpression = true;
                }
                return _xblockexpression;
              }
            });
            OutputStream _outputStream = proc.getOutputStream();
            StreamCopier _streamCopier = new StreamCopier(stdin, _outputStream);
            new Thread(_streamCopier).start();
            InputStream _inputStream = proc.getInputStream();
            final Procedure0 _function = new Procedure0() {
              public void apply() {
                ok.release();
              }
            };
            StreamCopier _addListener = new StreamCopier(_inputStream, stdout).addListener("Started", _function);
            new Thread(_addListener).start();
            InputStream _errorStream = proc.getErrorStream();
            StreamCopier _streamCopier_1 = new StreamCopier(_errorStream, stderr);
            new Thread(_streamCopier_1).start();
            new Thread(new Runnable() {
              public void run() {
                try {
                  proc.waitFor();
                  ok.release();
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            });
          } else {
            String _string = RunServer.this.filePath.toString();
            String _plus = (_string + " was not generated. Please save the file and retry.");
            stderr.write(_plus);
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    }).start();
    boolean started = false;
    do {
      try {
        ok.acquire();
        started = true;
      } catch (final Throwable _t) {
        if (_t instanceof InterruptedException) {
          final InterruptedException exc = (InterruptedException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } while((!started));
  }
}
