package com.sysma.goat.eclipse_plugin.tests.validator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import com.sysma.goat.eclipse_plugin.tests.validator.ValidationTestHelper2;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class FunctionValidationTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper2 _validationTestHelper2;
  
  public void checkNoErrorApartInfr(final EObject obj) {
    final Function1<Resource.Diagnostic, Boolean> _function = new Function1<Resource.Diagnostic, Boolean>() {
      public Boolean apply(final Resource.Diagnostic it) {
        String _message = it.getMessage();
        return Boolean.valueOf((!Objects.equal(_message, "Couldn\'t resolve reference to Infrastructure \'infr\'.")));
      }
    };
    int _length = ((Object[])Conversions.unwrapArray(IterableExtensions.<Resource.Diagnostic>filter(obj.eResource().getErrors(), _function), Object.class)).length;
    boolean _equals = (_length == 0);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void useVarBeforeDefinition() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = y");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 7");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getLocalVarRef(), Diagnostic.LINKING_DIAGNOSTIC, "Couldn\'t resolve reference to LRef \'y\'.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void twoDifferentNames() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return x+y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sameName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int funS (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return x+x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncVarDeclaration(), null, "Variable x declared multiple times");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sameNameTwoFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return x+x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun2 (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return x+x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sameNameTwoBlocksNotAllowed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 0){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x+x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var x = 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncVarDeclaration(), null, "Variable x declared multiple times");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sameNameFunc() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int x){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 4");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncDefinition(), null, "Function fun declared multiple times");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void twoFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun1 (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun2 (int x){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 4");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void twoParams() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun1 (int x, int y){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sameNameParams() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int x, int y, string x){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncParam(), null, "Parameter x declared multiple times");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sameNameParams2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (int x, int y, string z, bool y, string x){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncParam(), null, "Parameter x declared multiple times");
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncParam(), null, "Parameter y declared multiple times");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void twoParamsTwoFunc() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun1 (int x, int y){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun2 (int x){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningAtTheEnd() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningAtTheMiddle() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = x");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningIf() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 8");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 3){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = 9");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncDefinition(), null, "Functions must eventually return");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningIfElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 3){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningIfElifElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 3){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (6 < 9){ ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 8");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningIfElif() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 8");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 3){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (9 < 0) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 123");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = 9");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncDefinition(), null, "Functions must eventually return");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void returningTypeOk() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 8");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 3){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 3");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (9 < 0) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 123");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = 9");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.checkNoErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void returningTypeWrong() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function int fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 8");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (5 > 3){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return \"3\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} else if (9 < 0) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 123");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = 9");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper2.assertError(result, GoatComponentsPackage.eINSTANCE.getFuncReturn(), null, "Must return a int");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
