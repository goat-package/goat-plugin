package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.CodePrint;
import com.sysma.goat.eclipse_plugin.generator.CodeUpdate;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor;
import com.sysma.goat.eclipse_plugin.goatComponents.Update;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class CodeProcessWaitFor {
  private final ProcessWaitFor waitfor;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  public CodeProcessWaitFor(final ProcessWaitFor waitfor, final LocalVariableMap map, final CharSequence procRef) {
    this.waitfor = waitfor;
    this.map = map;
    this.procRef = procRef;
  }
  
  public CharSequence getCode() {
    CharSequence _xblockexpression = null;
    {
      final String attrVar = "attrs";
      CharSequence _xifexpression = null;
      Expression _cond = this.waitfor.getCond();
      if ((_cond instanceof IntConstant)) {
        CharSequence _xblockexpression_1 = null;
        {
          Expression _cond_1 = this.waitfor.getCond();
          final int msec = ((IntConstant) _cond_1).getValue();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(this.procRef);
          _builder.append(".Sleep(");
          _builder.append(msec);
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          {
            if (((((Object[])Conversions.unwrapArray(this.waitfor.getUpdate().getAttribute(), Object.class)).length > 0) || (this.waitfor.getPrint() != null))) {
              _builder.append(this.procRef);
              _builder.append(".WaitUntilTrue(func(");
              _builder.append(attrVar);
              _builder.append(" *goat.Attributes) bool{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              Update _update = this.waitfor.getUpdate();
              CharSequence _code = new CodeUpdate(_update, this.map, this.procRef, attrVar).getCode();
              _builder.append(_code, "\t");
              _builder.newLineIfNotEmpty();
              {
                PrintStatement _print = this.waitfor.getPrint();
                boolean _tripleNotEquals = (_print != null);
                if (_tripleNotEquals) {
                  _builder.append("\t");
                  CharSequence _of = CodePrint.of(this.waitfor.getPrint(), attrVar, this.map, Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList()));
                  _builder.append(_of, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("return true");
              _builder.newLine();
              _builder.append("})");
              _builder.newLine();
            }
          }
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.procRef);
        _builder.append(".WaitUntilTrue(func(");
        _builder.append(attrVar);
        _builder.append(" *goat.Attributes) bool{");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("if (");
        CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.BOOL, this.waitfor.getCond(), this.map, attrVar);
        _builder.append(_cast, "\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        Update _update = this.waitfor.getUpdate();
        CharSequence _code = new CodeUpdate(_update, this.map, this.procRef, attrVar).getCode();
        _builder.append(_code, "\t\t");
        _builder.newLineIfNotEmpty();
        {
          PrintStatement _print = this.waitfor.getPrint();
          boolean _tripleNotEquals = (_print != null);
          if (_tripleNotEquals) {
            _builder.append("\t\t");
            CharSequence _of = CodePrint.of(this.waitfor.getPrint(), attrVar, this.map, Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList()));
            _builder.append(_of, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("return true");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return false");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("})");
        _builder.newLine();
        _xifexpression = _builder;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
