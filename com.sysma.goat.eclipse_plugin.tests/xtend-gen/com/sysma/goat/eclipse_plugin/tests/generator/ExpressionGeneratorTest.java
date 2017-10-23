package com.sysma.goat.eclipse_plugin.tests.generator;

import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import com.sysma.goat.eclipse_plugin.tests.generator.GeneratorTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class ExpressionGeneratorTest {
  @Inject
  @Extension
  private GeneratorTestHelper _generatorTestHelper;
  
  @Test
  public void sumExpression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{}@(false) [proc.x := 1+5] print(\"EXPRESSION $x$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("EXPRESSION 6"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionWithAttributes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{}@(false) [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("proc.g := 3, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("proc.f := ((comp.seven+5)*proc.g)/7");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("] print(\"EXPRESSION $f$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {seven := 7} P");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("EXPRESSION 5"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionWithComparisonInt() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{}@(false) [proc.g := 3, proc.f := comp.seven > 3] print(\"EXPRESSION $f$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {seven := 7} P");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("EXPRESSION true"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionWithComparisonIntBool() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{}@(false) [proc.g := 3, proc.f := comp.seven > 3 == 3 > 4] print(\"EXPRESSION $f$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {seven := 7} P");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("EXPRESSION false"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionFunctionRecursive() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {} @ (false) [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("proc.six := 6, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("proc.f := fact(proc.six)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("] print(\"EXPRESSION $f$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function int fact(int n){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (n <= 1) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return n * fact(n-1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("EXPRESSION 720"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionWithNegativeConst() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {} @ (false) [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("proc.val := -1, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("proc.f := fn(proc.val)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("] print(\"EXPRESSION $f$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function int fn(int n){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return -n");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("EXPRESSION 1"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionSendPredicate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{1}@(receiver.pname == \"Q\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receive(true){x} print(\"P got $x$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receive(true){x}print(\"Q got $x$\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{proc.x + 1}@(receiver.pname == \"P\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {pname := \"P\"} P");
    _builder.newLine();
    _builder.append("component {pname := \"Q\"} Q");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("Q got 1"));
        Assert.assertTrue(out.contains("P got 2"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void expressionSendPredicateStrings() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {\"ciao: come (va)\"} @ (receiver.pname == \"Q\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receive (true) {x} print(\"$x$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {pname := \"P\"} P");
    _builder.newLine();
    _builder.append("component {pname := \"Q\"} Q");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("ciao: come (va)"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
}
