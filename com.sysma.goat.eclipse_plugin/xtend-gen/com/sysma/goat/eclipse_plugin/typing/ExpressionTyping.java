package com.sysma.goat.eclipse_plugin.typing;

import com.google.common.base.Objects;
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
import com.sysma.goat.eclipse_plugin.goatComponents.Not;
import com.sysma.goat.eclipse_plugin.goatComponents.Or;
import com.sysma.goat.eclipse_plugin.goatComponents.Plus;
import com.sysma.goat.eclipse_plugin.goatComponents.RecAttributeRef;
import com.sysma.goat.eclipse_plugin.goatComponents.StringConstant;

@SuppressWarnings("all")
public class ExpressionTyping {
  public enum ExprType {
    INT,
    
    BOOL,
    
    STRING,
    
    UNKNOWN;
  }
  
  public static boolean matchable(final ExpressionTyping.ExprType a, final ExpressionTyping.ExprType b) {
    return ((Objects.equal(a, ExpressionTyping.ExprType.UNKNOWN) || Objects.equal(b, ExpressionTyping.ExprType.UNKNOWN)) || Objects.equal(a, b));
  }
  
  public static ExpressionTyping.ExprType coalesceType(final ExpressionTyping.ExprType a, final ExpressionTyping.ExprType b) {
    ExpressionTyping.ExprType _xifexpression = null;
    boolean _equals = Objects.equal(a, ExpressionTyping.ExprType.UNKNOWN);
    if (_equals) {
      _xifexpression = b;
    } else {
      _xifexpression = a;
    }
    return _xifexpression;
  }
  
  public static ExpressionTyping.ExprType typeOf(final String t) {
    ExpressionTyping.ExprType _switchResult = null;
    if (t != null) {
      switch (t) {
        case "int":
          _switchResult = ExpressionTyping.ExprType.INT;
          break;
        case "string":
          _switchResult = ExpressionTyping.ExprType.STRING;
          break;
        case "bool":
          _switchResult = ExpressionTyping.ExprType.BOOL;
          break;
        default:
          _switchResult = ExpressionTyping.ExprType.UNKNOWN;
          break;
      }
    } else {
      _switchResult = ExpressionTyping.ExprType.UNKNOWN;
    }
    return _switchResult;
  }
  
  public static String goType(final String x) {
    return ExpressionTyping.goType(ExpressionTyping.typeOf(x));
  }
  
  public static String goType(final Expression x) {
    return ExpressionTyping.goType(ExpressionTyping.typeOf(x));
  }
  
  public static String goType(final ExpressionTyping.ExprType x) {
    String _switchResult = null;
    if (x != null) {
      switch (x) {
        case INT:
          _switchResult = "int";
          break;
        case BOOL:
          _switchResult = "bool";
          break;
        case STRING:
          _switchResult = "string";
          break;
        case UNKNOWN:
          _switchResult = "interface{}";
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public static ExpressionTyping.ExprType typeOf(final Expression expr) {
    ExpressionTyping.ExprType _switchResult = null;
    boolean _matched = false;
    if (expr instanceof And) {
      _matched=true;
    }
    if (!_matched) {
      if (expr instanceof Or) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (expr instanceof Not) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (expr instanceof Equality) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (expr instanceof Comparison) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (expr instanceof BoolConstant) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = ExpressionTyping.ExprType.BOOL;
    }
    if (!_matched) {
      if (expr instanceof Plus) {
        _matched=true;
      }
      if (!_matched) {
        if (expr instanceof Minus) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (expr instanceof MulOrDiv) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (expr instanceof IntConstant) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = ExpressionTyping.ExprType.INT;
      }
    }
    if (!_matched) {
      if (expr instanceof Concatenate) {
        _matched=true;
      }
      if (!_matched) {
        if (expr instanceof StringConstant) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = ExpressionTyping.ExprType.STRING;
      }
    }
    if (!_matched) {
      if (expr instanceof LocalVarRef) {
        _matched=true;
        ExpressionTyping.ExprType _xblockexpression = null;
        {
          final LRef rf = ((LocalVarRef)expr).getRef();
          ExpressionTyping.ExprType _switchResult_1 = null;
          boolean _matched_1 = false;
          if (rf instanceof FuncVarDeclaration) {
            _matched_1=true;
            _switchResult_1 = ExpressionTyping.typeOf(((FuncVarDeclaration)rf).getVal());
          }
          if (!_matched_1) {
            if (rf instanceof FuncParam) {
              _matched_1=true;
              _switchResult_1 = ExpressionTyping.typeOf(((FuncParam)rf).getType());
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
        _switchResult = ExpressionTyping.ExprType.UNKNOWN;
      }
    }
    if (!_matched) {
      if (expr instanceof FunctionCall) {
        _matched=true;
        _switchResult = ExpressionTyping.typeOf(((FunctionCall)expr).getFunction().getType());
      }
    }
    if (!_matched) {
      if (expr instanceof RecAttributeRef) {
        _matched=true;
      }
      if (!_matched) {
        if (expr instanceof ComponentAttributeRef) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = ExpressionTyping.ExprType.UNKNOWN;
      }
    }
    if (!_matched) {
      _switchResult = ExpressionTyping.ExprType.UNKNOWN;
    }
    return _switchResult;
  }
}
