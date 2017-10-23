package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.CodePrint;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessBlock;
import com.sysma.goat.eclipse_plugin.generator.CodeUpdate;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive;
import com.sysma.goat.eclipse_plugin.goatComponents.ReceiveCase;
import com.sysma.goat.eclipse_plugin.goatComponents.Update;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class CodeProcessReceive {
  private final ProcessReceive receive;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  public CodeProcessReceive(final ProcessReceive receive, final LocalVariableMap map, final CharSequence procRef) {
    this.receive = receive;
    this.map = map;
    this.procRef = procRef;
  }
  
  public CharSequence getCode() {
    CharSequence _xblockexpression = null;
    {
      final String varForChoice = "branch";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var ");
      _builder.append(varForChoice, "\t");
      _builder.append(" int");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(this.procRef, "\t");
      _builder.append(".Receive(");
      CharSequence _acceptCode = this.getAcceptCode(varForChoice);
      _builder.append(_acceptCode, "\t");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _thenCode = this.getThenCode(varForChoice);
      _builder.append(_thenCode, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence getAcceptCode(final String varForChoice) {
    CharSequence _xblockexpression = null;
    {
      final String messageVar = "msg";
      final String attributesVar = "attrs";
      final LocalVariableMap locVarBak = new LocalVariableMap("locvarBak");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("func(");
      _builder.append(attributesVar);
      _builder.append(" *goat.Attributes, ");
      _builder.append(messageVar);
      _builder.append(" goat.Tuple)bool{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _declare = locVarBak.declare();
      _builder.append(_declare, "\t");
      _builder.newLineIfNotEmpty();
      {
        Iterable<Pair<Integer, ReceiveCase>> _indexed = IterableExtensions.<ReceiveCase>indexed(this.receive.getCases());
        for(final Pair<Integer, ReceiveCase> input : _indexed) {
          _builder.append("\t");
          _builder.append("if (");
          _builder.append(messageVar, "\t");
          _builder.append(".IsLong(");
          List<String> _elvis = null;
          EList<String> _msgInParts = input.getValue().getMsgInParts();
          if (_msgInParts != null) {
            _elvis = _msgInParts;
          } else {
            _elvis = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
          }
          int _length = ((Object[])Conversions.unwrapArray(_elvis, Object.class)).length;
          _builder.append(_length, "\t");
          _builder.append(")) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(locVarBak.name, "\t\t");
          _builder.append(" = ");
          CharSequence _copy = this.map.copy();
          _builder.append(_copy, "\t\t");
          _builder.newLineIfNotEmpty();
          {
            List<String> _elvis_1 = null;
            EList<String> _msgInParts_1 = input.getValue().getMsgInParts();
            if (_msgInParts_1 != null) {
              _elvis_1 = _msgInParts_1;
            } else {
              _elvis_1 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
            }
            Iterable<Pair<Integer, String>> _indexed_1 = IterableExtensions.<String>indexed(_elvis_1);
            for(final Pair<Integer, String> v : _indexed_1) {
              _builder.append("\t");
              _builder.append("\t");
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(messageVar);
              _builder_1.append(".Get(");
              Integer _key = v.getKey();
              _builder_1.append(_key);
              _builder_1.append(")");
              CharSequence _assign = locVarBak.assign(v.getValue(), _builder_1);
              _builder.append(_assign, "\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if(");
          CharSequence _cast = CodeExpression.cast(ExpressionTyping.ExprType.BOOL, input.getValue().getCond(), locVarBak, attributesVar);
          _builder.append(_cast, "\t\t");
          _builder.append("){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append(varForChoice, "\t\t\t");
          _builder.append(" = ");
          Integer _key_1 = input.getKey();
          _builder.append(_key_1, "\t\t\t");
          _builder.newLineIfNotEmpty();
          {
            List<String> _elvis_2 = null;
            EList<String> _msgInParts_2 = input.getValue().getMsgInParts();
            if (_msgInParts_2 != null) {
              _elvis_2 = _msgInParts_2;
            } else {
              _elvis_2 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
            }
            Iterable<Pair<Integer, String>> _indexed_2 = IterableExtensions.<String>indexed(_elvis_2);
            for(final Pair<Integer, String> v_1 : _indexed_2) {
              _builder.append("\t");
              _builder.append("\t\t");
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append(messageVar);
              _builder_2.append(".Get(");
              Integer _key_2 = v_1.getKey();
              _builder_2.append(_key_2);
              _builder_2.append(")");
              CharSequence _assign_1 = this.map.assign(v_1.getValue(), _builder_2);
              _builder.append(_assign_1, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("\t\t");
          Update _updates = input.getValue().getUpdates();
          CharSequence _code = new CodeUpdate(_updates, this.map, this.procRef, attributesVar).getCode();
          _builder.append(_code, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          PrintStatement _print = input.getValue().getPrint();
          List<String> _elvis_3 = null;
          EList<String> _msgInParts_3 = input.getValue().getMsgInParts();
          if (_msgInParts_3 != null) {
            _elvis_3 = _msgInParts_3;
          } else {
            _elvis_3 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
          }
          CharSequence _ofProcAttrs = CodePrint.ofProcAttrs(_print, attributesVar, this.map, _elvis_3);
          _builder.append(_ofProcAttrs, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return true");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("return false");
      _builder.newLine();
      _builder.append("}");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence getThenCode(final String varForChoice) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch(");
    _builder.append(varForChoice);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Pair<Integer, ReceiveCase>> _indexed = IterableExtensions.<ReceiveCase>indexed(this.receive.getCases());
      for(final Pair<Integer, ReceiveCase> input : _indexed) {
        _builder.append("\t");
        _builder.append("case ");
        Integer _key = input.getKey();
        _builder.append(_key, "\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        ProcessBlock _get = this.receive.getThen().get((input.getKey()).intValue());
        CharSequence _code = new CodeProcessBlock(_get, this.map, this.procRef).getCode();
        _builder.append(_code, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("panic(\"Invalid branch!\")");
    _builder.newLine();
    _builder.append("}");
    return _builder;
  }
}
