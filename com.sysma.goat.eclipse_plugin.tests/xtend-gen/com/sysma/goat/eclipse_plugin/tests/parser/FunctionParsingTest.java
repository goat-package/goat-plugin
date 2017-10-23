package com.sysma.goat.eclipse_plugin.tests.parser;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.Comparison;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncReturn;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarAssign;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration;
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import com.sysma.goat.eclipse_plugin.tests.parser.ParsingTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class FunctionParsingTest {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Test
  public void functionDecl() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 4");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkNoErrorApartInfr(result);
      FuncDefinition func = result.getFunctions().get(0);
      String _type = func.getType();
      boolean _equals = Objects.equal(_type, "int");
      Assert.assertTrue(_equals);
      String _name = func.getName();
      boolean _equals_1 = Objects.equal(_name, "fun");
      Assert.assertTrue(_equals_1);
      int _length = ((Object[])Conversions.unwrapArray(func.getParams(), Object.class)).length;
      boolean _equals_2 = (_length == 3);
      Assert.assertTrue(_equals_2);
      String _name_1 = func.getParams().get(0).getName();
      boolean _equals_3 = Objects.equal(_name_1, "i");
      Assert.assertTrue(_equals_3);
      String _type_1 = func.getParams().get(0).getType();
      boolean _equals_4 = Objects.equal(_type_1, "int");
      Assert.assertTrue(_equals_4);
      String _name_2 = func.getParams().get(1).getName();
      boolean _equals_5 = Objects.equal(_name_2, "s");
      Assert.assertTrue(_equals_5);
      String _type_2 = func.getParams().get(1).getType();
      boolean _equals_6 = Objects.equal(_type_2, "string");
      Assert.assertTrue(_equals_6);
      String _name_3 = func.getParams().get(2).getName();
      boolean _equals_7 = Objects.equal(_name_3, "b");
      Assert.assertTrue(_equals_7);
      String _type_3 = func.getParams().get(2).getType();
      boolean _equals_8 = Objects.equal(_type_3, "bool");
      Assert.assertTrue(_equals_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionMix() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = i");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (y > 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (y < 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkNoErrorApartInfr(result);
      FuncDefinition func = result.getFunctions().get(0);
      String _type = func.getType();
      boolean _equals = Objects.equal(_type, "int");
      Assert.assertTrue(_equals);
      String _name = func.getName();
      boolean _equals_1 = Objects.equal(_name, "fun");
      Assert.assertTrue(_equals_1);
      int _length = ((Object[])Conversions.unwrapArray(func.getParams(), Object.class)).length;
      boolean _equals_2 = (_length == 3);
      Assert.assertTrue(_equals_2);
      String _name_1 = func.getParams().get(0).getName();
      boolean _equals_3 = Objects.equal(_name_1, "i");
      Assert.assertTrue(_equals_3);
      String _type_1 = func.getParams().get(0).getType();
      boolean _equals_4 = Objects.equal(_type_1, "int");
      Assert.assertTrue(_equals_4);
      String _name_2 = func.getParams().get(1).getName();
      boolean _equals_5 = Objects.equal(_name_2, "s");
      Assert.assertTrue(_equals_5);
      String _type_2 = func.getParams().get(1).getType();
      boolean _equals_6 = Objects.equal(_type_2, "string");
      Assert.assertTrue(_equals_6);
      String _name_3 = func.getParams().get(2).getName();
      boolean _equals_7 = Objects.equal(_name_3, "b");
      Assert.assertTrue(_equals_7);
      String _type_3 = func.getParams().get(2).getType();
      boolean _equals_8 = Objects.equal(_type_3, "bool");
      Assert.assertTrue(_equals_8);
      int _length_1 = ((Object[])Conversions.unwrapArray(func.getBlk().getStatements(), Object.class)).length;
      boolean _equals_9 = (_length_1 == 2);
      Assert.assertTrue(_equals_9);
      FuncStatement _get = func.getBlk().getStatements().get(0);
      final FuncVarDeclaration ass = ((FuncVarDeclaration) _get);
      String _name_4 = ass.getName();
      boolean _equals_10 = Objects.equal(_name_4, "y");
      Assert.assertTrue(_equals_10);
      FuncStatement _get_1 = func.getBlk().getStatements().get(1);
      final FuncIfElse if_ = ((FuncIfElse) _get_1);
      int _length_2 = ((Object[])Conversions.unwrapArray(if_.getTest(), Object.class)).length;
      boolean _equals_11 = (_length_2 == 2);
      Assert.assertTrue(_equals_11);
      Expression _get_2 = if_.getTest().get(0);
      String _op = ((Comparison) _get_2).getOp();
      boolean _equals_12 = Objects.equal(_op, ">");
      Assert.assertTrue(_equals_12);
      Expression _get_3 = if_.getTest().get(1);
      String _op_1 = ((Comparison) _get_3).getOp();
      boolean _equals_13 = Objects.equal(_op_1, "<");
      Assert.assertTrue(_equals_13);
      FuncStatement _get_4 = if_.getThen().get(0).getStatements().get(0);
      Expression _val = ((FuncReturn) _get_4).getVal();
      int _value = ((IntConstant) _val).getValue();
      boolean _equals_14 = (_value == 0);
      Assert.assertTrue(_equals_14);
      FuncStatement _get_5 = if_.getThen().get(1).getStatements().get(0);
      Expression _val_1 = ((FuncReturn) _get_5).getVal();
      int _value_1 = ((IntConstant) _val_1).getValue();
      boolean _equals_15 = (_value_1 == 1);
      Assert.assertTrue(_equals_15);
      FuncStatement _get_6 = if_.getElseBranch().getStatements().get(0);
      Expression _val_2 = ((FuncReturn) _get_6).getVal();
      int _value_2 = ((IntConstant) _val_2).getValue();
      boolean _equals_16 = (_value_2 == 2);
      Assert.assertTrue(_equals_16);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void ifElifNoElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = i");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (y > 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (y < 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkNoErrorApartInfr(result);
      FuncDefinition func = result.getFunctions().get(0);
      String _type = func.getType();
      boolean _equals = Objects.equal(_type, "int");
      Assert.assertTrue(_equals);
      String _name = func.getName();
      boolean _equals_1 = Objects.equal(_name, "fun");
      Assert.assertTrue(_equals_1);
      int _length = ((Object[])Conversions.unwrapArray(func.getParams(), Object.class)).length;
      boolean _equals_2 = (_length == 3);
      Assert.assertTrue(_equals_2);
      String _name_1 = func.getParams().get(0).getName();
      boolean _equals_3 = Objects.equal(_name_1, "i");
      Assert.assertTrue(_equals_3);
      String _type_1 = func.getParams().get(0).getType();
      boolean _equals_4 = Objects.equal(_type_1, "int");
      Assert.assertTrue(_equals_4);
      String _name_2 = func.getParams().get(1).getName();
      boolean _equals_5 = Objects.equal(_name_2, "s");
      Assert.assertTrue(_equals_5);
      String _type_2 = func.getParams().get(1).getType();
      boolean _equals_6 = Objects.equal(_type_2, "string");
      Assert.assertTrue(_equals_6);
      String _name_3 = func.getParams().get(2).getName();
      boolean _equals_7 = Objects.equal(_name_3, "b");
      Assert.assertTrue(_equals_7);
      String _type_3 = func.getParams().get(2).getType();
      boolean _equals_8 = Objects.equal(_type_3, "bool");
      Assert.assertTrue(_equals_8);
      int _length_1 = ((Object[])Conversions.unwrapArray(func.getBlk().getStatements(), Object.class)).length;
      boolean _equals_9 = (_length_1 == 2);
      Assert.assertTrue(_equals_9);
      FuncStatement _get = func.getBlk().getStatements().get(0);
      final FuncVarDeclaration ass = ((FuncVarDeclaration) _get);
      String _name_4 = ass.getName();
      boolean _equals_10 = Objects.equal(_name_4, "y");
      Assert.assertTrue(_equals_10);
      FuncStatement _get_1 = func.getBlk().getStatements().get(1);
      final FuncIfElse if_ = ((FuncIfElse) _get_1);
      int _length_2 = ((Object[])Conversions.unwrapArray(if_.getTest(), Object.class)).length;
      boolean _equals_11 = (_length_2 == 2);
      Assert.assertTrue(_equals_11);
      Expression _get_2 = if_.getTest().get(0);
      String _op = ((Comparison) _get_2).getOp();
      boolean _equals_12 = Objects.equal(_op, ">");
      Assert.assertTrue(_equals_12);
      Expression _get_3 = if_.getTest().get(1);
      String _op_1 = ((Comparison) _get_3).getOp();
      boolean _equals_13 = Objects.equal(_op_1, "<");
      Assert.assertTrue(_equals_13);
      FuncStatement _get_4 = if_.getThen().get(0).getStatements().get(0);
      Expression _val = ((FuncReturn) _get_4).getVal();
      int _value = ((IntConstant) _val).getValue();
      boolean _equals_14 = (_value == 0);
      Assert.assertTrue(_equals_14);
      FuncStatement _get_5 = if_.getThen().get(1).getStatements().get(0);
      Expression _val_1 = ((FuncReturn) _get_5).getVal();
      int _value_1 = ((IntConstant) _val_1).getValue();
      boolean _equals_15 = (_value_1 == 1);
      Assert.assertTrue(_equals_15);
      Assert.assertNull(if_.getElseBranch());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void ifElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = i");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (y > 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void elseNoConds() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = i");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (y > 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else (true) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void maxOneElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = i");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (y > 5) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void elseAlone() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void assign() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = i");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 9");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkNoErrorApartInfr(result);
      FuncStatement _get = result.getFunctions().get(0).getBlk().getStatements().get(2);
      String _name = ((FuncVarAssign) _get).getVar().getName();
      boolean _equals = Objects.equal(_name, "y");
      Assert.assertTrue(_equals);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
