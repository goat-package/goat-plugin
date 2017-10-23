package com.sysma.goat.eclipse_plugin.tests.validator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
public class ExpressionValidatorTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
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
  public void intExpression() {
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
      _builder.append("return (x+y) * 6 - 5");
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
  public void boolExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function bool fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return ((x+y) * 6 - 5) > 10 == false");
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
  public void stringExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function string fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return \"o\" ++ fun()");
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
  public void mixedSumExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function string fun (int i, string s, bool b){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return \"3\" + 9");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getPlus(), null, "Expected a int expression");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void noGlobalAttributeInFunc() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function string fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return \"o\" ++ comp.z");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getComponentAttributeRef(), null, "Attributes cannot be used inside functions");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void noRecAttributeInFunc() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("function string fun (){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = 0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return \"o\" ++ receiver.z");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getRecAttributeRef(), null, "Receiver attributes can be used only in output predicates");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void receiveBoolExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("receive (proc.x > 10) {w};");
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
  public void receiveNonBoolExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("receive (10) {w};");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getReceiveCase(), null, "Expected a bool expression");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void globalAttributeInReceive() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("receive (comp.l) {w};");
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
  public void noRecAttributeInReceive() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("receive (receiver.l) {w};");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getRecAttributeRef(), null, "Receiver attributes can be used only in output predicates");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void sendBoolExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {proc.w} @ (proc.x > 10);");
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
  public void sendNonBoolExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {proc.w} @ (\"k\");");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getProcessSend(), null, "Expected a bool expression");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void globalAttributeInSendMessage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {comp.w} @ (true);");
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
  public void globalAttributeInSendPred() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {proc.w} @ (receiver.s == comp.d);");
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
  public void globalAttributeInPreconditions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("waitfor (comp.x == 8);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {} @ (true);");
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
  public void noReceiverAttributeInSendPreconditions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("waitfor (receiver.x == 8);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {} @ (true);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getRecAttributeRef(), null, "Receiver attributes can be used only in output predicates");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void awarenessBoolExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("waitfor(true);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {proc.w} @ (true);");
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
  public void sleep() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("waitfor(4);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {proc.w} @ (false);");
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
  public void awarenessNoStringExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("waitfor(\"4\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("send {proc.w} @ (false);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model result = this._parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, GoatComponentsPackage.eINSTANCE.getProcessWaitFor(), null, "Expected a bool or int expression");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
