package com.sysma.goat.eclipse_plugin.generator;

import com.google.common.collect.Iterables;
import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessBlock;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessReceive;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessSend;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessSet;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessIf;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessStatement;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class CodeProcessIf {
  private final ProcessIf ifProcess;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  public CodeProcessIf(final ProcessIf ifProcess, final LocalVariableMap map, final CharSequence procRef) {
    this.ifProcess = ifProcess;
    this.map = map;
    this.procRef = procRef;
  }
  
  public CharSequence code() {
    CharSequence _xblockexpression = null;
    {
      final String attrVar = "attr";
      final String branchChoiceVar = "branchIf";
      final String branchReceiveVar = "branchReceive";
      final Function1<Expression, CharSequence> _function = (Expression it) -> {
        return CodeExpression.cast(ExpressionTyping.ExprType.BOOL, it, this.map, attrVar);
      };
      List<CharSequence> _map = ListExtensions.<Expression, CharSequence>map(this.ifProcess.getCond(), _function);
      List<? extends CharSequence> _xifexpression = null;
      int _length = ((Object[])Conversions.unwrapArray(this.ifProcess.getAction(), Object.class)).length;
      int _length_1 = ((Object[])Conversions.unwrapArray(this.ifProcess.getCond(), Object.class)).length;
      boolean _greaterThan = (_length > _length_1);
      if (_greaterThan) {
        _xifexpression = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("true"));
      } else {
        _xifexpression = Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList());
      }
      final Iterable<CharSequence> conds = Iterables.<CharSequence>concat(_map, _xifexpression);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var ");
      _builder.append(branchChoiceVar, "\t");
      _builder.append(" int");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("var ");
      _builder.append(branchReceiveVar, "\t");
      _builder.append(" int");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("_ = ");
      _builder.append(branchReceiveVar, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(this.procRef, "\t");
      _builder.append(".SendOrReceive(func(");
      _builder.append(attrVar, "\t");
      _builder.append(" *goat.Attributes, receiving bool) goat.SendReceive{");
      _builder.newLineIfNotEmpty();
      {
        Iterable<Pair<Integer, CharSequence>> _indexed = IterableExtensions.<CharSequence>indexed(conds);
        for(final Pair<Integer, CharSequence> branch : _indexed) {
          _builder.append("\t\t");
          ProcessStatement action = this.ifProcess.getAction().get((branch.getKey()).intValue());
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          CharSequence cond = branch.getValue();
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("if(");
          _builder.append(cond, "\t\t");
          _builder.append("){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append(branchChoiceVar, "\t\t\t");
          _builder.append(" = ");
          Integer _key = branch.getKey();
          _builder.append(_key, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("if (receiving != ");
          _builder.append((action instanceof ProcessReceive), "\t\t\t");
          _builder.append("){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("return goat.ThenFail()");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("} else {");
          _builder.newLine();
          {
            if ((action instanceof ProcessReceive)) {
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("return goat.ThenReceive(");
              CharSequence _acceptCode = new CodeProcessReceive(((ProcessReceive)action), this.map, this.procRef).getAcceptCode(branchReceiveVar);
              _builder.append(_acceptCode, "\t\t\t\t");
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            } else {
              if ((action instanceof ProcessSend)) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                CharSequence _codeIfBranch = new CodeProcessSend(((ProcessSend) action), this.map, this.procRef).getCodeIfBranch(attrVar);
                _builder.append(_codeIfBranch, "\t\t\t\t");
                _builder.newLineIfNotEmpty();
              } else {
                if ((action instanceof ProcessSet)) {
                  _builder.append("\t\t");
                  _builder.append("\t\t");
                  CharSequence _codeIfBranch_1 = new CodeProcessSet(((ProcessSet) action), this.map, this.procRef).getCodeIfBranch(attrVar);
                  _builder.append(_codeIfBranch_1, "\t\t\t\t");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t\t");
                  _builder.append("\t\t");
                  _builder.append("@ERR NOT IMPLEMENTED");
                  _builder.newLine();
                }
              }
            }
          }
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return goat.ThenFail()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("})");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch ");
      _builder.append(branchChoiceVar, "\t");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        Iterable<Pair<Integer, ProcessStatement>> _indexed_1 = IterableExtensions.<ProcessStatement>indexed(this.ifProcess.getAction());
        for(final Pair<Integer, ProcessStatement> branch_1 : _indexed_1) {
          _builder.append("\t\t");
          _builder.append("case ");
          Integer _key_1 = branch_1.getKey();
          _builder.append(_key_1, "\t\t");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          ProcessStatement action_1 = branch_1.getValue();
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          ProcessBlock then = this.ifProcess.getThen().get((branch_1.getKey()).intValue());
          _builder.newLineIfNotEmpty();
          {
            if ((action_1 instanceof ProcessReceive)) {
              _builder.append("\t\t");
              _builder.append("\t");
              CharSequence _thenCode = new CodeProcessReceive(((ProcessReceive)action_1), this.map, this.procRef).getThenCode(branchReceiveVar);
              _builder.append(_thenCode, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("\t");
          CharSequence _code = new CodeProcessBlock(then, this.map, this.procRef).getCode();
          _builder.append(_code, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("panic(\"Invalid branch!\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
