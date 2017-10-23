package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeProcessDefinition;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSpawn;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeProcessSpawn {
  private final ProcessSpawn proc;
  
  private final LocalVariableMap locvars;
  
  private final CharSequence processRef;
  
  public CodeProcessSpawn(final ProcessSpawn proc, final LocalVariableMap locvars, final CharSequence processRef) {
    this.proc = proc;
    this.locvars = locvars;
    this.processRef = processRef;
  }
  
  public CharSequence getCode() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.processRef);
    _builder.append(".Spawn(runWith(wg, ");
    ProcessDefinition _proc = this.proc.getProc();
    String _process_func_name = new CodeProcessDefinition(_proc).getProcess_func_name();
    _builder.append(_process_func_name);
    _builder.append(", ");
    CharSequence _copy = this.locvars.copy();
    _builder.append(_copy);
    _builder.append("))");
    return _builder;
  }
}
