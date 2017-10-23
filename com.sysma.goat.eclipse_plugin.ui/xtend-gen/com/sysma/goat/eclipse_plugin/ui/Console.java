package com.sysma.goat.eclipse_plugin.ui;

import com.sysma.goat.eclipse_plugin.ui.ConsoleActions;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.IOConsole;

@SuppressWarnings("all")
public class Console extends IOConsole {
  private ConsoleActions observer;
  
  private Process process;
  
  public Console(final String name, final ImageDescriptor imageDescriptor) {
    super(name, imageDescriptor);
  }
  
  public Console(final String name, final String consoleType, final ImageDescriptor imageDescriptor, final boolean autoLifecycle) {
    super(name, consoleType, imageDescriptor, autoLifecycle);
  }
  
  public void setProcess(final Process p) {
    this.process = p;
    if ((this.observer != null)) {
      this.observer.setProcess(this.process);
    }
  }
  
  public void setObserver(final ConsoleActions o) {
    this.observer = o;
    if ((this.process != null)) {
      this.observer.setProcess(this.process);
    }
  }
}
