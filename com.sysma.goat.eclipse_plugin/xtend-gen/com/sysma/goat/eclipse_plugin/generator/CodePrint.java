package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeAttribute;
import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintFormattedStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.impl.LocalAttributeRefImpl;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CodePrint {
  private static class LocalAttributeRefImplConversion extends LocalAttributeRefImpl {
    public LocalAttributeRefImplConversion(final String attrname) {
      super();
      this.attribute = attrname;
    }
  }
  
  public static CharSequence of(final PrintStatement pstat, final String componentAttr, final LocalVariableMap localAttr, final List<Expression> message) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (pstat instanceof PrintFormattedStatement) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("fmt.Println(");
      String _convertString = CodePrint.convertString(((PrintFormattedStatement)pstat).getToPrint(), componentAttr, localAttr, message);
      _builder.append(_convertString);
      _builder.append(")");
      _switchResult = _builder;
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static CharSequence ofProcAttrs(final PrintStatement pstat, final String componentAttr, final LocalVariableMap localAttr, final List<String> message) {
    CharSequence _xblockexpression = null;
    {
      final Function1<String, Expression> _function = (String it) -> {
        CodePrint.LocalAttributeRefImplConversion _localAttributeRefImplConversion = new CodePrint.LocalAttributeRefImplConversion(it);
        return ((Expression) _localAttributeRefImplConversion);
      };
      final List<Expression> exprMessage = ListExtensions.<String, Expression>map(message, _function);
      _xblockexpression = CodePrint.of(pstat, componentAttr, localAttr, exprMessage);
    }
    return _xblockexpression;
  }
  
  private static String escape(final String escapedSequence, final String componentAttr, final LocalVariableMap localAttr, final List<Expression> message) {
    int _length = escapedSequence.length();
    boolean _equals = (_length == 0);
    if (_equals) {
      return "\"$\"";
    } else {
      boolean _isDigits = NumberUtils.isDigits(escapedSequence);
      if (_isDigits) {
        final int tupleIdx = Integer.parseInt(escapedSequence);
        int _length_1 = ((Object[])Conversions.unwrapArray(message, Object.class)).length;
        boolean _greaterEqualsThan = (tupleIdx >= _length_1);
        if (_greaterEqualsThan) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"<invalid tuple index>\"");
          return _builder.toString();
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("fmt.Sprintf(\"%s: %v\",\"");
          _builder_1.append("\", ");
          CharSequence _expressionWithAttributes = CodeExpression.getExpressionWithAttributes(message.get(tupleIdx), localAttr, componentAttr);
          _builder_1.append(_expressionWithAttributes);
          _builder_1.append(")");
          return _builder_1.toString();
        }
      } else {
        String attrName = "";
        boolean compLevel = false;
        boolean _startsWith = escapedSequence.startsWith("comp.");
        if (_startsWith) {
          compLevel = true;
          attrName = escapedSequence.substring(5);
        } else {
          compLevel = false;
          attrName = escapedSequence;
        }
        final CodeAttribute attribCode = new CodeAttribute(attrName, compLevel, componentAttr, localAttr);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("fmt.Sprintf(\"%v\",");
        CharSequence _read = attribCode.read();
        _builder_2.append(_read);
        _builder_2.append(")");
        return _builder_2.toString();
      }
    }
  }
  
  private static String convertString(final String text, final String componentAttr, final LocalVariableMap localAttr, final List<Expression> message) {
    ArrayList<String> outTokens = new ArrayList<String>();
    String escapedSequence = null;
    String actualString = "";
    char[] _charArray = text.toCharArray();
    for (final char ch : _charArray) {
      char _charAt = "$".charAt(0);
      boolean _equals = (ch == _charAt);
      if (_equals) {
        if ((escapedSequence == null)) {
          escapedSequence = "";
          outTokens.add((("\"" + actualString) + "\""));
        } else {
          outTokens.add(CodePrint.escape(escapedSequence, componentAttr, localAttr, message));
          escapedSequence = null;
        }
        actualString = "";
      } else {
        if ((escapedSequence == null)) {
          String _actualString = actualString;
          actualString = (_actualString + Character.valueOf(ch));
        } else {
          String _escapedSequence = escapedSequence;
          escapedSequence = (_escapedSequence + Character.valueOf(ch));
        }
      }
    }
    if ((escapedSequence == null)) {
      outTokens.add((("\"" + actualString) + "\""));
    } else {
      outTokens.add(CodePrint.escape(escapedSequence, componentAttr, localAttr, message));
    }
    return String.join(" + ", outTokens);
  }
}
