package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.And;
import com.sysma.goat.eclipse_plugin.goatComponents.BoolConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.Comparison;
import com.sysma.goat.eclipse_plugin.goatComponents.ComponentAttributeRef;
import com.sysma.goat.eclipse_plugin.goatComponents.Concatenate;
import com.sysma.goat.eclipse_plugin.goatComponents.Equality;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncParam;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration;
import com.sysma.goat.eclipse_plugin.goatComponents.FunctionCall;
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.LRef;
import com.sysma.goat.eclipse_plugin.goatComponents.LocalAttributeRef;
import com.sysma.goat.eclipse_plugin.goatComponents.LocalVarRef;
import com.sysma.goat.eclipse_plugin.goatComponents.Minus;
import com.sysma.goat.eclipse_plugin.goatComponents.MulOrDiv;
import com.sysma.goat.eclipse_plugin.goatComponents.NegativeIntConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.Not;
import com.sysma.goat.eclipse_plugin.goatComponents.Or;
import com.sysma.goat.eclipse_plugin.goatComponents.Plus;
import com.sysma.goat.eclipse_plugin.goatComponents.RecAttributeRef;
import com.sysma.goat.eclipse_plugin.goatComponents.StringConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.UnaryMinus;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import java.util.List;
import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CodeExpression {
  public static CharSequence cast(final String typ, final Expression expr, final LocalVariableMap localAttributesMap, final CharSequence attributesMap) {
    return CodeExpression.cast(ExpressionTyping.typeOf(typ), expr, localAttributesMap, attributesMap);
  }
  
  public static CharSequence cast(final ExpressionTyping.ExprType typ, final Expression expr, final LocalVariableMap localAttributesMap, final CharSequence attributesMap) {
    CharSequence _xblockexpression = null;
    {
      final CharSequence econv = CodeExpression.getExpressionWithAttributes(expr, localAttributesMap, attributesMap);
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (expr instanceof LocalAttributeRef) {
        _matched=true;
      }
      if (!_matched) {
        if (expr instanceof RecAttributeRef) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (expr instanceof ComponentAttributeRef) {
          _matched=true;
        }
      }
      if (_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        _builder.append(econv);
        _builder.append(").(");
        String _goType = ExpressionTyping.goType(typ);
        _builder.append(_goType);
        _builder.append(")");
        _switchResult = _builder;
      }
      if (!_matched) {
        _switchResult = econv;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static CharSequence getExpressionWithAttributes(final Expression expr, final LocalVariableMap localAttributesMap, final CharSequence attributesMap) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (expr instanceof And) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      final Function1<Expression, CharSequence> _function = (Expression it) -> {
        return CodeExpression.cast(ExpressionTyping.ExprType.BOOL, it, localAttributesMap, attributesMap);
      };
      String _join = IterableExtensions.join(ListExtensions.<Expression, CharSequence>map(((And)expr).getSub(), _function), " && ");
      _builder.append(_join);
      _builder.append(")");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (expr instanceof Or) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        final Function1<Expression, CharSequence> _function = (Expression it) -> {
          return CodeExpression.cast(ExpressionTyping.ExprType.BOOL, it, localAttributesMap, attributesMap);
        };
        String _join = IterableExtensions.join(ListExtensions.<Expression, CharSequence>map(((Or)expr).getSub(), _function), " || ");
        _builder.append(_join);
        _builder.append(")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Not) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(!(");
        CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.BOOL, ((Not)expr).getExpression(), localAttributesMap, attributesMap);
        _builder.append(_cast);
        _builder.append("))");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Equality) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(goat.Cmp(");
        CharSequence _expressionWithAttributes = CodeExpression.getExpressionWithAttributes(((Equality)expr).getLeft(), localAttributesMap, attributesMap);
        _builder.append(_expressionWithAttributes);
        _builder.append(", \"");
        String _op = ((Equality)expr).getOp();
        _builder.append(_op);
        _builder.append("\", ");
        CharSequence _expressionWithAttributes_1 = CodeExpression.getExpressionWithAttributes(((Equality)expr).getRight(), localAttributesMap, attributesMap);
        _builder.append(_expressionWithAttributes_1);
        _builder.append("))");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Comparison) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(goat.Cmp(");
        CharSequence _expressionWithAttributes = CodeExpression.getExpressionWithAttributes(((Comparison)expr).getLeft(), localAttributesMap, attributesMap);
        _builder.append(_expressionWithAttributes);
        _builder.append(", \"");
        String _op = ((Comparison)expr).getOp();
        _builder.append(_op);
        _builder.append("\", ");
        CharSequence _expressionWithAttributes_1 = CodeExpression.getExpressionWithAttributes(((Comparison)expr).getRight(), localAttributesMap, attributesMap);
        _builder.append(_expressionWithAttributes_1);
        _builder.append("))");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof BoolConstant) {
        _matched=true;
        _switchResult = ((BoolConstant)expr).getValue();
      }
    }
    if (!_matched) {
      if (expr instanceof Plus) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((Plus)expr).getLeft(), localAttributesMap, attributesMap);
        _builder.append(_cast);
        _builder.append(" + ");
        CharSequence _cast_1 = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((Plus)expr).getRight(), localAttributesMap, attributesMap);
        _builder.append(_cast_1);
        _builder.append(")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Concatenate) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(goat.ToString(");
        CharSequence _expressionWithAttributes = CodeExpression.getExpressionWithAttributes(((Concatenate)expr).getLeft(), localAttributesMap, attributesMap);
        _builder.append(_expressionWithAttributes);
        _builder.append(") + goat.ToString(");
        CharSequence _expressionWithAttributes_1 = CodeExpression.getExpressionWithAttributes(((Concatenate)expr).getRight(), localAttributesMap, attributesMap);
        _builder.append(_expressionWithAttributes_1);
        _builder.append("))");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Minus) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((Minus)expr).getLeft(), localAttributesMap, attributesMap);
        _builder.append(_cast);
        _builder.append(" - ");
        CharSequence _cast_1 = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((Minus)expr).getRight(), localAttributesMap, attributesMap);
        _builder.append(_cast_1);
        _builder.append(")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof MulOrDiv) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((MulOrDiv)expr).getLeft(), localAttributesMap, attributesMap);
        _builder.append(_cast);
        _builder.append(" ");
        String _op = ((MulOrDiv)expr).getOp();
        _builder.append(_op);
        _builder.append(" ");
        CharSequence _cast_1 = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((MulOrDiv)expr).getRight(), localAttributesMap, attributesMap);
        _builder.append(_cast_1);
        _builder.append(")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof UnaryMinus) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(-(");
        CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.INT, ((UnaryMinus)expr).getExpression(), localAttributesMap, attributesMap);
        _builder.append(_cast);
        _builder.append("))");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof NegativeIntConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(-");
        int _negvalue = ((NegativeIntConstant)expr).getNegvalue();
        _builder.append(_negvalue);
        _builder.append(")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof IntConstant) {
        _matched=true;
        _switchResult = Integer.valueOf(((IntConstant)expr).getValue()).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof StringConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _escapeJava = StringEscapeUtils.escapeJava(((StringConstant)expr).getValue());
        _builder.append(_escapeJava);
        _builder.append("\"");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof LocalVarRef) {
        _matched=true;
        String _xblockexpression = null;
        {
          final LRef rf = ((LocalVarRef)expr).getRef();
          String _switchResult_1 = null;
          boolean _matched_1 = false;
          if (rf instanceof FuncVarDeclaration) {
            _matched_1=true;
            _switchResult_1 = ((FuncVarDeclaration)rf).getName();
          }
          if (!_matched_1) {
            if (rf instanceof FuncParam) {
              _matched_1=true;
              _switchResult_1 = ((FuncParam)rf).getName();
            }
          }
          _xblockexpression = _switchResult_1;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expr instanceof LocalAttributeRef) {
        _matched=true;
        String _xifexpression = null;
        if ((attributesMap == null)) {
          throw new IllegalArgumentException("Unexpected local attribute");
        } else {
          _xifexpression = localAttributesMap.readValue(((LocalAttributeRef)expr).getAttribute());
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (expr instanceof FunctionCall) {
        _matched=true;
        CharSequence _xblockexpression = null;
        {
          int _length = ((Object[])Conversions.unwrapArray(((FunctionCall)expr).getParams(), Object.class)).length;
          final Function1<Integer, CharSequence> _function = (Integer i) -> {
            return CodeExpression.cast(((FunctionCall)expr).getFunction().getParams().get((i).intValue()).getType(), ((FunctionCall)expr).getParams().get((i).intValue()), localAttributesMap, attributesMap);
          };
          final String args = IterableExtensions.join(IterableExtensions.<Integer, CharSequence>map(new ExclusiveRange(0, _length, true), _function), ", ");
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("f_");
          String _name = ((FunctionCall)expr).getFunction().getName();
          _builder.append(_name);
          _builder.append("(");
          _builder.append(args);
          _builder.append(")");
          _xblockexpression = _builder;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expr instanceof RecAttributeRef) {
        _matched=true;
        throw new IllegalArgumentException("Unexpected receiver attribute");
      }
    }
    if (!_matched) {
      if (expr instanceof ComponentAttributeRef) {
        _matched=true;
        CharSequence _xifexpression = null;
        if ((attributesMap == null)) {
          throw new IllegalArgumentException("Unexpected component attribute");
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(attributesMap);
          _builder.append(".GetValue(\"");
          String _attribute = ((ComponentAttributeRef)expr).getAttribute();
          _builder.append(_attribute);
          _builder.append("\")");
          _xifexpression = _builder;
        }
        _switchResult = _xifexpression;
      }
    }
    return _switchResult;
  }
  
  public static CharSequence getExpressionWithoutAttributes(final Expression expr) {
    return CodeExpression.getExpressionWithAttributes(expr, null, null);
  }
  
  /**
   * def private static boolean isOPImmediate(Expression expr) {
   * switch(expr){
   * LocalAttributeRef, ComponentAttributeRef, StringConstant, IntConstant, BoolConstant:
   * true
   * default:
   * false
   * }
   * }
   */
  private static boolean isOPAttribute(final Expression expr) {
    return (expr instanceof RecAttributeRef);
  }
  
  public static CharSequence binaryOperatorExtensor(final CharSequence operator, final List<CharSequence> operands) {
    final Function1<CharSequence, String> _function = (CharSequence it) -> {
      return (operator + "(");
    };
    String _join = IterableExtensions.join(IterableExtensions.<CharSequence, String>map(IterableExtensions.<CharSequence>tail(operands), _function));
    CharSequence _head = IterableExtensions.<CharSequence>head(operands);
    String _plus = (_join + _head);
    final Function1<CharSequence, String> _function_1 = (CharSequence it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(", ");
      _builder.append(it);
      _builder.append(")");
      return _builder.toString();
    };
    String _join_1 = IterableExtensions.join(IterableExtensions.<CharSequence, String>map(IterableExtensions.<CharSequence>tail(operands), _function_1));
    return (_plus + _join_1);
  }
  
  public static CharSequence getOutputPredicate(final Expression expr, final LocalVariableMap localAttributesMap, final CharSequence attrName) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (expr instanceof And) {
      _matched=true;
      final Function1<Expression, CharSequence> _function = (Expression it) -> {
        return CodeExpression.getOutputPredicate(it, localAttributesMap, attrName);
      };
      _switchResult = CodeExpression.binaryOperatorExtensor("goat.And", ListExtensions.<Expression, CharSequence>map(((And)expr).getSub(), _function));
    }
    if (!_matched) {
      if (expr instanceof Or) {
        _matched=true;
        final Function1<Expression, CharSequence> _function = (Expression it) -> {
          return CodeExpression.getOutputPredicate(it, localAttributesMap, attrName);
        };
        _switchResult = CodeExpression.binaryOperatorExtensor("goat.Or", ListExtensions.<Expression, CharSequence>map(((Or)expr).getSub(), _function));
      }
    }
    if (!_matched) {
      if (expr instanceof Not) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("goat.Not(");
        CharSequence _outputPredicate = CodeExpression.getOutputPredicate(((Not)expr).getExpression(), localAttributesMap, attrName);
        _builder.append(_outputPredicate);
        _builder.append(")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Equality) {
        _matched=true;
        String _xblockexpression = null;
        {
          boolean _isOPAttribute = CodeExpression.isOPAttribute(((Equality)expr).getLeft());
          final boolean isOpLImm = (!_isOPAttribute);
          boolean _isOPAttribute_1 = CodeExpression.isOPAttribute(((Equality)expr).getRight());
          final boolean isOpRImm = (!_isOPAttribute_1);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("goat.Comparison(");
          CharSequence _outputPredicate = CodeExpression.getOutputPredicate(((Equality)expr).getLeft(), localAttributesMap, attrName);
          _builder.append(_outputPredicate);
          _builder.append(", ");
          _builder.append((!isOpLImm));
          _builder.append(", \"");
          String _op = ((Equality)expr).getOp();
          _builder.append(_op);
          _builder.append("\", ");
          StringConcatenation _builder_1 = new StringConcatenation();
          CharSequence _outputPredicate_1 = CodeExpression.getOutputPredicate(((Equality)expr).getRight(), localAttributesMap, attrName);
          _builder_1.append(_outputPredicate_1);
          _builder_1.append(", ");
          _builder_1.append((!isOpRImm));
          _builder_1.append(")");
          _xblockexpression = (_builder.toString() + _builder_1);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expr instanceof Comparison) {
        _matched=true;
        String _xblockexpression = null;
        {
          boolean _isOPAttribute = CodeExpression.isOPAttribute(((Comparison)expr).getLeft());
          final boolean isOpLImm = (!_isOPAttribute);
          boolean _isOPAttribute_1 = CodeExpression.isOPAttribute(((Comparison)expr).getRight());
          final boolean isOpRImm = (!_isOPAttribute_1);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("goat.Comparison(");
          CharSequence _outputPredicate = CodeExpression.getOutputPredicate(((Comparison)expr).getLeft(), localAttributesMap, attrName);
          _builder.append(_outputPredicate);
          _builder.append(", ");
          _builder.append((!isOpLImm));
          _builder.append(", \"");
          String _op = ((Comparison)expr).getOp();
          _builder.append(_op);
          _builder.append("\", ");
          StringConcatenation _builder_1 = new StringConcatenation();
          CharSequence _outputPredicate_1 = CodeExpression.getOutputPredicate(((Comparison)expr).getRight(), localAttributesMap, attrName);
          _builder_1.append(_outputPredicate_1);
          _builder_1.append(", ");
          _builder_1.append((!isOpRImm));
          _builder_1.append(")");
          _xblockexpression = (_builder.toString() + _builder_1);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expr instanceof BoolConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("goat.");
        String _firstUpper = StringExtensions.toFirstUpper(((BoolConstant)expr).getValue());
        _builder.append(_firstUpper);
        _builder.append("()");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof RecAttributeRef) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _attribute = ((RecAttributeRef)expr).getAttribute();
        _builder.append(_attribute);
        _builder.append("\"");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof Expression) {
        _matched=true;
        _switchResult = CodeExpression.getExpressionWithAttributes(expr, localAttributesMap, attrName);
      }
    }
    return _switchResult;
  }
}
