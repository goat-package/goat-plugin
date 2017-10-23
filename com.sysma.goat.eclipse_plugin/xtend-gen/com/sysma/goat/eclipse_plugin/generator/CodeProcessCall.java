package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeProcessDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessCall;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessDefinition;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeProcessCall {
  private final ProcessCall call;
  
  public CodeProcessCall(final ProcessCall call) {
    this.call = call;
  }
  
  public CharSequence getCode() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return ");
    ProcessDefinition _proc = this.call.getProc();
    String _process_func_name = new CodeProcessDefinition(_proc).getProcess_func_name();
    _builder.append(_process_func_name);
    return _builder;
  }
}
