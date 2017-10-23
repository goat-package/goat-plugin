package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncParam;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncReturn;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarAssign;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CodeFunction {
  private final FuncDefinition definition;
  
  public CodeFunction(final FuncDefinition fdef) {
    this.definition = fdef;
  }
  
  public CharSequence getCode() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("func f_");
    String _name = this.definition.getName();
    _builder.append(_name);
    _builder.append("(");
    final Function1<FuncParam, String> _function = (FuncParam it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_1 = it.getName();
      _builder_1.append(_name_1);
      _builder_1.append(" ");
      String _goType = ExpressionTyping.goType(it.getType());
      _builder_1.append(_goType);
      return _builder_1.toString();
    };
    String _join = IterableExtensions.join(ListExtensions.<FuncParam, String>map(this.definition.getParams(), _function), ",");
    _builder.append(_join);
    _builder.append(") ");
    String _goType = ExpressionTyping.goType(this.definition.getType());
    _builder.append(_goType);
    _builder.append(" ");
    CharSequence _makeCode = this.makeCode(this.definition.getBlk());
    _builder.append(_makeCode);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence makeCode(final Object item) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (item instanceof FuncBlock) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      final Function1<FuncStatement, CharSequence> _function = (FuncStatement it) -> {
        return this.makeCode(it);
      };
      String _join = IterableExtensions.join(ListExtensions.<FuncStatement, CharSequence>map(((FuncBlock)item).getStatements(), _function), "\n");
      _builder.append(_join, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (item instanceof FuncVarAssign) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = ((FuncVarAssign)item).getVar().getName();
        _builder.append(_name);
        _builder.append(" = ");
        CharSequence _makeCode = this.makeCode(((FuncVarAssign)item).getVal());
        _builder.append(_makeCode);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (item instanceof FuncIfElse) {
        _matched=true;
        int _length = ((Object[])Conversions.unwrapArray(((FuncIfElse)item).getThen(), Object.class)).length;
        final Function1<Integer, String> _function = (Integer i) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("if (");
          CharSequence _makeCode = this.makeCode(((FuncIfElse)item).getTest().get((i).intValue()));
          _builder.append(_makeCode);
          _builder.append(") ");
          CharSequence _makeCode_1 = this.makeCode(((FuncIfElse)item).getThen().get((i).intValue()));
          _builder.append(_makeCode_1);
          return _builder.toString();
        };
        String _join = IterableExtensions.join(IterableExtensions.<Integer, String>map(new ExclusiveRange(0, _length, true), _function), "else ");
        CharSequence _xifexpression = null;
        FuncBlock _elseBranch = ((FuncIfElse)item).getElseBranch();
        boolean _tripleNotEquals = (_elseBranch != null);
        if (_tripleNotEquals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("else ");
          CharSequence _makeCode = this.makeCode(((FuncIfElse)item).getElseBranch());
          _builder.append(_makeCode);
          _xifexpression = _builder;
        } else {
          _xifexpression = "";
        }
        _switchResult = (_join + _xifexpression);
      }
    }
    if (!_matched) {
      if (item instanceof FuncReturn) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return ");
        CharSequence _makeCode = this.makeCode(((FuncReturn)item).getVal());
        _builder.append(_makeCode);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (item instanceof FuncVarDeclaration) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("var ");
        String _name = ((FuncVarDeclaration)item).getName();
        _builder.append(_name);
        _builder.append(" = ");
        CharSequence _makeCode = this.makeCode(((FuncVarDeclaration)item).getVal());
        _builder.append(_makeCode);
        _builder.newLineIfNotEmpty();
        _builder.append("_ = ");
        String _name_1 = ((FuncVarDeclaration)item).getName();
        _builder.append(_name_1);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (item instanceof Expression) {
        _matched=true;
        _switchResult = CodeExpression.getExpressionWithoutAttributes(((Expression)item));
      }
    }
    return _switchResult;
  }
}
