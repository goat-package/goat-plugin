package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeProcessBlock;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessLoop;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeProcessLoop {
  private final ProcessLoop loop;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  public CodeProcessLoop(final ProcessLoop loop, final LocalVariableMap map, final CharSequence procRef) {
    this.map = map;
    this.loop = loop;
    this.procRef = procRef;
  }
  
  public CharSequence getCode() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for {");
    _builder.newLine();
    _builder.append("\t");
    ProcessBlock _block = this.loop.getBlock();
    CharSequence _code = new CodeProcessBlock(_block, this.map, this.procRef).getCode();
    _builder.append(_code, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
