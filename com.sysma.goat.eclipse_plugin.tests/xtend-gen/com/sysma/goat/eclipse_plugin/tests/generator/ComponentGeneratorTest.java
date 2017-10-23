package com.sysma.goat.eclipse_plugin.tests.generator;

import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import com.sysma.goat.eclipse_plugin.tests.generator.GeneratorTestHelper;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class ComponentGeneratorTest {
  @Inject
  @Extension
  private GeneratorTestHelper _generatorTestHelper;
  
  @Test
  public void sendReceive() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{\"hello world\"}@(true);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receive(true){x}print(\"$x$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    _builder.append("component {} Q");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("hello world"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void sendReceiveSameComponent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{\"hello world\"}@(true);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receive(true){x}print(\"$x$\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process R {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receive(true){x};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{\"wow\"}@(true);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process PQ = P|Q");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} PQ");
    _builder.newLine();
    _builder.append("component {} R");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertFalse(out.contains("hello world"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void ifProcess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P1 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{0}@(true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{3}@(true);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{2}@(true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{1}@(true);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P = P1|P2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (comp.remaining > 0){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("receive(true){x}[comp.remaining := comp.remaining - 1];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("spawn(Qrep)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("call(Q)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Qrep{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (proc.x < 2) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{}@(false)print(\"$x$ is little\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{}@(false)print(\"$x$ is big\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    _builder.append("component {remaining := 4} Q");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("0 is little"));
        Assert.assertTrue(out.contains("1 is little"));
        Assert.assertTrue(out.contains("2 is big"));
        Assert.assertTrue(out.contains("3 is big"));
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function);
  }
  
  @Test
  public void infiniteServer() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set [proc.x := 0];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{proc.x}@(true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("call(Pp)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Pp {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (proc.x < 1000){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("set [proc.x := proc.x + 1];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{proc.x}@(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("call(Pp)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("loop{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("receive(true){x}[comp.remaining := comp.remaining - 1];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("spawn(Qrep)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Qrep {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (proc.x == 0){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{}@(false)print(\"$x$ is zero\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else if (proc.x%2 == 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{}@(false)print(\"$x$ is even\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{}@(false)print(\"$x$ is odd\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    _builder.append("component {remaining := 1000} Q");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        Assert.assertTrue(out.contains("0 is zero"));
        final Consumer<Integer> _function = new Consumer<Integer>() {
          public void accept(final Integer it) {
            String _plus = (it + " is ");
            String _xifexpression = null;
            if ((((it).intValue() % 2) == 0)) {
              _xifexpression = "even";
            } else {
              _xifexpression = "odd";
            }
            String _plus_1 = (_plus + _xifexpression);
            Assert.assertTrue(out.contains(_plus_1));
          }
        };
        new IntegerRange(1, 999).forEach(_function);
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function, 2000);
  }
  
  @Test
  public void infiniteServerPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("infrastructure infr");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process P {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set [proc.x := 0];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send{proc.x}@(true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("call(Pp)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Pp {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (proc.x < 1000){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("set [proc.x := proc.x + 1];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("send{proc.x}@(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("call(Pp)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("process Q {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("loop{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("receive{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case (even(proc.x)){x}print(\"$x$ is even\"):{} ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case (!(even(proc.x))){x}print(\"$x$ is odd\"):{}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function bool even(int x){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return x % 2 == 0");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("component {} P");
    _builder.newLine();
    _builder.append("component {} Q");
    _builder.newLine();
    final Procedure2<String, String> _function = new Procedure2<String, String>() {
      public void apply(final String out, final String err) {
        int init = 0;
        IntegerRange _upTo = new IntegerRange(0, 999);
        for (final Integer i : _upTo) {
          {
            String _substring = out.substring(init);
            String _plus = (i + " is ");
            String _xifexpression = null;
            if ((((i).intValue() % 2) == 0)) {
              _xifexpression = "even";
            } else {
              _xifexpression = "odd";
            }
            String _plus_1 = (_plus + _xifexpression);
            final int pl = _substring.indexOf(_plus_1);
            Assert.assertTrue((pl >= 0));
            init = (init + pl);
          }
        }
      }
    };
    this._generatorTestHelper.compileAndRun(_builder, _function, 2000);
  }
}
