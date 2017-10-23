package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.CodePrint;
import com.sysma.goat.eclipse_plugin.generator.CodeSendPred;
import com.sysma.goat.eclipse_plugin.generator.CodeUpdate;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend;
import com.sysma.goat.eclipse_plugin.goatComponents.Update;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class CodeProcessSend {
  private final ProcessSend send;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  public CodeProcessSend(final ProcessSend send, final LocalVariableMap map, final CharSequence procRef) {
    this.send = send;
    this.map = map;
    this.procRef = procRef;
  }
  
  public CharSequence getCode() {
    return this.getCodeWithPrecondition(null);
  }
  
  public CharSequence getCodeWithPrecondition(final Expression precond) {
    CharSequence _xblockexpression = null;
    {
      final String messageVar = "msg";
      final String attrVar = "attrs";
      List<Expression> _elvis = null;
      EList<Expression> _msgOutParts = this.send.getMsgOutParts();
      if (_msgOutParts != null) {
        _elvis = _msgOutParts;
      } else {
        _elvis = Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList());
      }
      final Function1<Expression, CharSequence> _function = (Expression it) -> {
        return CodeExpression.getExpressionWithAttributes(it, this.map, attrVar);
      };
      final List<CharSequence> messageParts = ListExtensions.<Expression, CharSequence>map(_elvis, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.procRef);
      _builder.append(".SendFunc(func(");
      _builder.append(attrVar);
      _builder.append(" *goat.Attributes) (goat.Tuple, goat.Predicate, bool){");
      _builder.newLineIfNotEmpty();
      {
        if ((precond != null)) {
          _builder.append("\t");
          _builder.append("if (!");
          CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.BOOL, precond, this.map, attrVar);
          _builder.append(_cast, "\t");
          _builder.append("){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return goat.NewTuple(), goat.False(), false");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append(messageVar, "\t");
      _builder.append(" := goat.NewTuple(");
      String _join = IterableExtensions.join(messageParts, ", ");
      _builder.append(_join, "\t");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("pred := ");
      Expression _send_pred = this.send.getSend_pred();
      CharSequence _code = new CodeSendPred(_send_pred, this.map, attrVar).getCode();
      _builder.append(_code, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Update _updates = this.send.getUpdates();
      CharSequence _code_1 = new CodeUpdate(_updates, this.map, this.procRef, attrVar).getCode();
      _builder.append(_code_1, "\t");
      _builder.newLineIfNotEmpty();
      {
        PrintStatement _print = this.send.getPrint();
        boolean _tripleNotEquals = (_print != null);
        if (_tripleNotEquals) {
          _builder.append("\t");
          PrintStatement _print_1 = this.send.getPrint();
          List<Expression> _elvis_1 = null;
          EList<Expression> _msgOutParts_1 = this.send.getMsgOutParts();
          if (_msgOutParts_1 != null) {
            _elvis_1 = _msgOutParts_1;
          } else {
            _elvis_1 = Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList());
          }
          CharSequence _of = CodePrint.of(_print_1, attrVar, this.map, _elvis_1);
          _builder.append(_of, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("return ");
      _builder.append(messageVar, "\t");
      _builder.append(", pred, true");
      _builder.newLineIfNotEmpty();
      _builder.append("})");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence getCodeIfBranch(final String attrVar) {
    CharSequence _xblockexpression = null;
    {
      List<Expression> _elvis = null;
      EList<Expression> _msgOutParts = this.send.getMsgOutParts();
      if (_msgOutParts != null) {
        _elvis = _msgOutParts;
      } else {
        _elvis = Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList());
      }
      final Function1<Expression, CharSequence> _function = (Expression it) -> {
        return CodeExpression.getExpressionWithAttributes(it, this.map, attrVar);
      };
      final List<CharSequence> messageParts = ListExtensions.<Expression, CharSequence>map(_elvis, _function);
      final String messageVar = "msg";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(messageVar);
      _builder.append(" := goat.NewTuple(");
      String _join = IterableExtensions.join(messageParts, ", ");
      _builder.append(_join);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("pred := ");
      Expression _send_pred = this.send.getSend_pred();
      CharSequence _code = new CodeSendPred(_send_pred, this.map, attrVar).getCode();
      _builder.append(_code);
      _builder.newLineIfNotEmpty();
      Update _updates = this.send.getUpdates();
      CharSequence _code_1 = new CodeUpdate(_updates, this.map, this.procRef, attrVar).getCode();
      _builder.append(_code_1);
      _builder.newLineIfNotEmpty();
      {
        PrintStatement _print = this.send.getPrint();
        boolean _tripleNotEquals = (_print != null);
        if (_tripleNotEquals) {
          PrintStatement _print_1 = this.send.getPrint();
          List<Expression> _elvis_1 = null;
          EList<Expression> _msgOutParts_1 = this.send.getMsgOutParts();
          if (_msgOutParts_1 != null) {
            _elvis_1 = _msgOutParts_1;
          } else {
            _elvis_1 = Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList());
          }
          CharSequence _of = CodePrint.of(_print_1, attrVar, this.map, _elvis_1);
          _builder.append(_of);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("return goat.ThenSend(");
      _builder.append(messageVar);
      _builder.append(", pred.CloseUnder(");
      _builder.append(attrVar);
      _builder.append("))");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
