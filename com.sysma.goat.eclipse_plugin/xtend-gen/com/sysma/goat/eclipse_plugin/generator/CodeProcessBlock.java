package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.generator.Utils;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessStatement;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CodeProcessBlock {
  private final ProcessBlock blk;
  
  private final LocalVariableMap localVariableMap;
  
  private final CharSequence processRef;
  
  public CodeProcessBlock(final ProcessBlock blk, final LocalVariableMap localVariableMap, final CharSequence processRef) {
    this.blk = blk;
    this.localVariableMap = localVariableMap;
    this.processRef = processRef;
  }
  
  public CharSequence getCode() {
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<ProcessStatement, CharSequence> _function = (ProcessStatement it) -> {
        return Utils.getCode(it, this.localVariableMap, this.processRef);
      };
      List<CharSequence> _map = ListExtensions.<ProcessStatement, CharSequence>map(this.blk.getStatements(), _function);
      for(final CharSequence x : _map) {
        _builder.append(x);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence getCodeAsFunction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("func (wg *sync.WaitGroup, ");
    _builder.append(this.localVariableMap.name);
    _builder.append(" *map[string]interface{}, ");
    _builder.append(this.processRef);
    _builder.append(" *goat.Process) continuationProcess{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _code = this.getCode();
    _builder.append(_code, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return nil");
    _builder.newLine();
    _builder.append("}");
    return _builder;
  }
}
