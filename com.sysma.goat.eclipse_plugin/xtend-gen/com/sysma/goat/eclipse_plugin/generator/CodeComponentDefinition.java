package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.CodeInfrastructureAgent;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessBlock;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.ComponentDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.Environment;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class CodeComponentDefinition {
  private final ComponentDefinition cdef;
  
  private final CharSequence mainFunc;
  
  private final CharSequence compName;
  
  public CodeComponentDefinition(final ComponentDefinition cdef, final CharSequence runFunc, final CharSequence compName) {
    this.cdef = cdef;
    this.mainFunc = runFunc;
    this.compName = compName;
  }
  
  public CharSequence getComponentDeclaration(final Infrastructure infr) {
    CharSequence _xblockexpression = null;
    {
      final CharSequence infrCode = new CodeInfrastructureAgent(infr).getCode();
      CharSequence _xifexpression = null;
      Environment _env = this.cdef.getEnv();
      boolean _tripleNotEquals = (_env != null);
      if (_tripleNotEquals) {
        _xifexpression = this.getCode(this.cdef.getEnv());
      } else {
        _xifexpression = this.getCode(this.cdef.getEnvref().getEnv());
      }
      final CharSequence envCode = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.compName);
      _builder.append(" := goat.NewComponentWithAttributes(");
      _builder.append(infrCode);
      _builder.append(",  ");
      _builder.append(envCode);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence getCode(final Environment env) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("map[string]interface{}{");
    _builder.newLine();
    {
      Iterable<Pair<Integer, String>> _indexed = IterableExtensions.<String>indexed(env.getAttrs());
      for(final Pair<Integer, String> v : _indexed) {
        _builder.append("\t");
        _builder.append("\"");
        String _value = v.getValue();
        _builder.append(_value, "\t");
        _builder.append("\" : ");
        CharSequence _expressionWithoutAttributes = CodeExpression.getExpressionWithoutAttributes(env.getVals().get((v.getKey()).intValue()));
        _builder.append(_expressionWithoutAttributes, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence getCode() {
    CharSequence _xblockexpression = null;
    {
      ProcessBlock _block = this.cdef.getBlock();
      LocalVariableMap _localVariableMap = new LocalVariableMap("locvar");
      final CharSequence fncCode = new CodeProcessBlock(_block, _localVariableMap, "p").getCodeAsFunction();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("goat.NewProcess(");
      _builder.append(this.compName);
      _builder.append(").Run(");
      _builder.append(this.mainFunc);
      _builder.append("(&wg, ");
      _builder.append(fncCode);
      _builder.append(", &(map[string]interface{}{})))");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
