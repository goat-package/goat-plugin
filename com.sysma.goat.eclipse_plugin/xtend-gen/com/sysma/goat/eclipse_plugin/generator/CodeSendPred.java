package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;

@SuppressWarnings("all")
public class CodeSendPred {
  private final Expression pred;
  
  private final LocalVariableMap localAttributes;
  
  private final CharSequence attrName;
  
  public CodeSendPred(final Expression pred, final LocalVariableMap localAttributes, final CharSequence attrName) {
    this.pred = pred;
    this.localAttributes = localAttributes;
    this.attrName = attrName;
  }
  
  public CharSequence getCode() {
    return CodeExpression.getOutputPredicate(this.pred, this.localAttributes, this.attrName);
  }
}
