package com.sysma.goat.eclipse_plugin.generator;

import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.util.CancelIndicator;

@SuppressWarnings("all")
public class CommandLineContext extends GeneratorContext {
  public final Path projectPath;
  
  public CommandLineContext(final String projectPath) {
    super();
    this.setCancelIndicator(CancelIndicator.NullImpl);
    Path _path = new Path(projectPath);
    this.projectPath = _path;
  }
}
