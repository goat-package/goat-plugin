package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeProcessBlock;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessDefinition;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeProcessDefinition {
  private final ProcessDefinition pdef;
  
  public CodeProcessDefinition(final ProcessDefinition pdef) {
    this.pdef = pdef;
  }
  
  public CharSequence getCode() {
    CharSequence _xblockexpression = null;
    {
      LocalVariableMap localVariablesMap = new LocalVariableMap("locvar");
      CharSequence procReference = "p";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("func ");
      String _process_func_name = this.getProcess_func_name();
      _builder.append(_process_func_name);
      _builder.append("(wg *sync.WaitGroup, ");
      _builder.append(localVariablesMap.name);
      _builder.append(" *map[string]interface{}, ");
      _builder.append(procReference);
      _builder.append(" *goat.Process) continuationProcess{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      ProcessBlock _block = this.pdef.getBlock();
      CharSequence _code = new CodeProcessBlock(_block, localVariablesMap, procReference).getCode();
      _builder.append(_code, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("return nil");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String getProcess_func_name() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("pr_");
    String _name = this.pdef.getName();
    _builder.append(_name);
    return _builder.toString();
  }
}
