package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.CodePrint;
import com.sysma.goat.eclipse_plugin.generator.CodeUpdate;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet;
import com.sysma.goat.eclipse_plugin.goatComponents.Update;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class CodeProcessSet {
  private final ProcessSet set;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  public CodeProcessSet(final ProcessSet set, final LocalVariableMap map, final CharSequence procRef) {
    this.set = set;
    this.map = map;
    this.procRef = procRef;
  }
  
  public CharSequence getCode() {
    return this.getCodeWithPrecondition(null);
  }
  
  public CharSequence getCodeWithPrecondition(final Expression precond) {
    CharSequence _xblockexpression = null;
    {
      final String attrVar = "attrs";
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
      Update _update = this.set.getUpdate();
      CharSequence _code = new CodeUpdate(_update, this.map, this.procRef, attrVar).getCode();
      _builder.append(_code, "\t");
      _builder.newLineIfNotEmpty();
      {
        PrintStatement _print = this.set.getPrint();
        boolean _tripleNotEquals = (_print != null);
        if (_tripleNotEquals) {
          _builder.append("\t");
          CharSequence _of = CodePrint.of(this.set.getPrint(), attrVar, this.map, Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList()));
          _builder.append(_of, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("return goat.NewTuple(), goat.False(), true");
      _builder.newLine();
      _builder.append("})");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence getCodeIfBranch(final String attrVar) {
    StringConcatenation _builder = new StringConcatenation();
    Update _update = this.set.getUpdate();
    CharSequence _code = new CodeUpdate(_update, this.map, this.procRef, attrVar).getCode();
    _builder.append(_code);
    _builder.newLineIfNotEmpty();
    {
      PrintStatement _print = this.set.getPrint();
      boolean _tripleNotEquals = (_print != null);
      if (_tripleNotEquals) {
        CharSequence _of = CodePrint.of(this.set.getPrint(), attrVar, this.map, Collections.<Expression>unmodifiableList(CollectionLiterals.<Expression>newArrayList()));
        _builder.append(_of);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("return goat.ThenSend(goat.NewTuple(), goat.False())");
    _builder.newLine();
    return _builder;
  }
}
