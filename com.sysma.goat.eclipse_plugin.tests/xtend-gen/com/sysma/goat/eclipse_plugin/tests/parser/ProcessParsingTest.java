package com.sysma.goat.eclipse_plugin.tests.parser;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.BoolConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintFormattedStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessCall;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessIf;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSpawn;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor;
import com.sysma.goat.eclipse_plugin.goatComponents.ReceiveCase;
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateComponentAttribute;
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateLocalAttribute;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class ProcessParsingTest {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  private ProcessBlock encapsulateProcess(final CharSequence proc) {
    try {
      ProcessBlock _xblockexpression = null;
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("infrastructure infr");
        _builder.newLine();
        _builder.newLine();
        _builder.append("process P {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(proc, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        final Model result = this.parseHelper.parse(_builder);
        Assert.assertNotNull(result);
        _xblockexpression = result.getProcesses().get(0).getBlock();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void zeroProcess() {
    StringConcatenation _builder = new StringConcatenation();
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    Assert.assertTrue(result.getStatements().isEmpty());
  }
  
  @Test
  public void call() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("call(P)");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _get = result.getStatements().get(0);
    Assert.assertTrue((_get instanceof ProcessCall));
    ProcessStatement _get_1 = result.getStatements().get(0);
    final ProcessCall cp = ((ProcessCall) _get_1);
    String _name = cp.getProc().getName();
    boolean _equals = Objects.equal(_name, "P");
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void interleaving() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("spawn(P)");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _get = result.getStatements().get(0);
    Assert.assertTrue((_get instanceof ProcessSpawn));
    ProcessStatement _get_1 = result.getStatements().get(0);
    final ProcessSpawn p = ((ProcessSpawn) _get_1);
    String _name = p.getProc().getName();
    boolean _equals = Objects.equal(_name, "P");
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void defineInterleaving() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P = P|P|P|P");
      _builder.newLine();
      final Model defin = this.parseHelper.parse(_builder);
      Assert.assertNotNull(defin);
      final ProcessBlock result = defin.getProcesses().get(0).getBlock();
      Assert.assertNotNull(result);
      Assert.assertTrue(result.eResource().getErrors().isEmpty());
      final Function1<ProcessStatement, Boolean> _function = new Function1<ProcessStatement, Boolean>() {
        public Boolean apply(final ProcessStatement it) {
          return Boolean.valueOf((!(it instanceof ProcessSpawn)));
        }
      };
      Assert.assertTrue(IterableExtensions.isEmpty(IterableExtensions.<ProcessStatement>filter(IterableExtensions.<ProcessStatement>tail(ListExtensions.<ProcessStatement>reverseView(result.getStatements())), _function)));
      ProcessStatement _last = IterableExtensions.<ProcessStatement>last(result.getStatements());
      Assert.assertTrue((_last instanceof ProcessCall));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void inputProcessSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("receive (true) {x,y,z};");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _get = result.getStatements().get(0);
    Assert.assertTrue((_get instanceof ProcessReceive));
    ProcessStatement _get_1 = result.getStatements().get(0);
    final ProcessReceive iprocs = ((ProcessReceive) _get_1);
    int _length = ((Object[])Conversions.unwrapArray(iprocs.getCases(), Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
    final ReceiveCase case0 = IterableExtensions.<ReceiveCase>head(iprocs.getCases());
    Expression _cond = case0.getCond();
    Assert.assertTrue((_cond instanceof BoolConstant));
    int _length_1 = ((Object[])Conversions.unwrapArray(case0.getMsgInParts(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 3);
    Assert.assertTrue(_equals_1);
  }
  
  @Test
  public void threeInputProcessSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("receive {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case (true) {x,y,z} : {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case (true) {x,y,z} : {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case (true) {x,y,z} : {}");
    _builder.newLine();
    _builder.append("}");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _get = result.getStatements().get(0);
    Assert.assertTrue((_get instanceof ProcessReceive));
    ProcessStatement _get_1 = result.getStatements().get(0);
    final ProcessReceive iprocs = ((ProcessReceive) _get_1);
    int _length = ((Object[])Conversions.unwrapArray(iprocs.getCases(), Object.class)).length;
    boolean _equals = (_length == 3);
    Assert.assertTrue(_equals);
    final Consumer<ReceiveCase> _function = new Consumer<ReceiveCase>() {
      public void accept(final ReceiveCase it) {
        Expression _cond = it.getCond();
        Assert.assertTrue((_cond instanceof BoolConstant));
        int _length = ((Object[])Conversions.unwrapArray(it.getMsgInParts(), Object.class)).length;
        boolean _equals = (_length == 3);
        Assert.assertTrue(_equals);
      }
    };
    iprocs.getCases().forEach(_function);
  }
  
  @Test
  public void threeInputProcessUpdate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("receive {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case (true) {x,y,z} [proc.z := 5] : {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case (true) {x,y,z} [proc.z := 5] : {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case (true) {x,y,z} [proc.z := 5] : {}");
    _builder.newLine();
    _builder.append("}");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _get = result.getStatements().get(0);
    Assert.assertTrue((_get instanceof ProcessReceive));
    ProcessStatement _get_1 = result.getStatements().get(0);
    final ProcessReceive iprocs = ((ProcessReceive) _get_1);
    int _length = ((Object[])Conversions.unwrapArray(iprocs.getCases(), Object.class)).length;
    boolean _equals = (_length == 3);
    Assert.assertTrue(_equals);
    final Consumer<ReceiveCase> _function = new Consumer<ReceiveCase>() {
      public void accept(final ReceiveCase it) {
        Expression _cond = it.getCond();
        Assert.assertTrue((_cond instanceof BoolConstant));
        int _length = ((Object[])Conversions.unwrapArray(it.getMsgInParts(), Object.class)).length;
        boolean _equals = (_length == 3);
        Assert.assertTrue(_equals);
        EObject _get = it.getUpdates().getAttribute().get(0);
        Assert.assertTrue((_get instanceof UpdateLocalAttribute));
        EObject _get_1 = it.getUpdates().getAttribute().get(0);
        String _atname = ((UpdateLocalAttribute) _get_1).getAtname();
        boolean _equals_1 = Objects.equal(_atname, "z");
        Assert.assertTrue(_equals_1);
      }
    };
    iprocs.getCases().forEach(_function);
  }
  
  @Test
  public void outputProcess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessSend));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessSend p = ((ProcessSend) _head_1);
    Expression _send_pred = p.getSend_pred();
    Assert.assertTrue((_send_pred instanceof Expression));
    int _length = ((Object[])Conversions.unwrapArray(p.getMsgOutParts(), Object.class)).length;
    boolean _equals = (_length == 3);
    Assert.assertTrue(_equals);
    final Function1<Expression, Boolean> _function = new Function1<Expression, Boolean>() {
      public Boolean apply(final Expression it) {
        return Boolean.valueOf((it instanceof Expression));
      }
    };
    Assert.assertTrue(IterableExtensions.<Expression>forall(p.getMsgOutParts(), _function));
    Assert.assertTrue(p.getUpdates().getAttribute().isEmpty());
    Assert.assertNull(p.getPrint());
  }
  
  @Test
  public void outputProcessPrint() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1) print(\"Ciao ciao\");");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessSend));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessSend p = ((ProcessSend) _head_1);
    PrintStatement _print = p.getPrint();
    Assert.assertTrue((_print instanceof PrintFormattedStatement));
    PrintStatement _print_1 = p.getPrint();
    String _toPrint = ((PrintFormattedStatement) _print_1).getToPrint();
    boolean _equals = Objects.equal(_toPrint, "Ciao ciao");
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void inputProcessEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("receive (true) {};");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _get = result.getStatements().get(0);
    Assert.assertTrue((_get instanceof ProcessReceive));
    ProcessStatement _get_1 = result.getStatements().get(0);
    final ProcessReceive iprocs = ((ProcessReceive) _get_1);
    int _length = ((Object[])Conversions.unwrapArray(iprocs.getCases(), Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
    final ReceiveCase case0 = IterableExtensions.<ReceiveCase>head(iprocs.getCases());
    Expression _cond = case0.getCond();
    Assert.assertTrue((_cond instanceof BoolConstant));
    Assert.assertTrue(case0.getMsgInParts().isEmpty());
  }
  
  @Test
  public void outputProcessEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("send {} @ (true);");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessSend));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessSend p = ((ProcessSend) _head_1);
    Expression _send_pred = p.getSend_pred();
    Assert.assertTrue((_send_pred instanceof Expression));
    Assert.assertTrue(p.getMsgOutParts().isEmpty());
    Assert.assertTrue(p.getUpdates().getAttribute().isEmpty());
    Assert.assertNull(p.getPrint());
  }
  
  @Test
  public void sequence() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("send {} @ (true); receive (proc.x > 3) {a}; set [proc.s := 8];");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
  }
  
  @Test
  public void if_() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("}");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessIf));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessIf ifp = ((ProcessIf) _head_1);
    int _length = ((Object[])Conversions.unwrapArray(ifp.getCond(), Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
    int _length_1 = ((Object[])Conversions.unwrapArray(ifp.getAction(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 1);
    Assert.assertTrue(_equals_1);
    int _length_2 = ((Object[])Conversions.unwrapArray(ifp.getThen(), Object.class)).length;
    boolean _equals_2 = (_length_2 == 1);
    Assert.assertTrue(_equals_2);
    ProcessStatement _head_2 = IterableExtensions.<ProcessStatement>head(ifp.getAction());
    Assert.assertTrue((_head_2 instanceof ProcessSend));
    ProcessBlock _head_3 = IterableExtensions.<ProcessBlock>head(ifp.getThen());
    final ProcessBlock p = ((ProcessBlock) _head_3);
    Assert.assertTrue(p.getStatements().isEmpty());
  }
  
  @Test
  public void if_ElseIf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("} else if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("} ");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessIf));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessIf ifp = ((ProcessIf) _head_1);
    int _length = ((Object[])Conversions.unwrapArray(ifp.getCond(), Object.class)).length;
    boolean _equals = (_length == 2);
    Assert.assertTrue(_equals);
    int _length_1 = ((Object[])Conversions.unwrapArray(ifp.getAction(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 2);
    Assert.assertTrue(_equals_1);
    int _length_2 = ((Object[])Conversions.unwrapArray(ifp.getThen(), Object.class)).length;
    boolean _equals_2 = (_length_2 == 2);
    Assert.assertTrue(_equals_2);
    final Function1<ProcessStatement, Boolean> _function = new Function1<ProcessStatement, Boolean>() {
      public Boolean apply(final ProcessStatement it) {
        return Boolean.valueOf((!(it instanceof ProcessSend)));
      }
    };
    Assert.assertTrue(IterableExtensions.isEmpty(IterableExtensions.<ProcessStatement>filter(ifp.getAction(), _function)));
    final Function1<ProcessBlock, Boolean> _function_1 = new Function1<ProcessBlock, Boolean>() {
      public Boolean apply(final ProcessBlock it) {
        int _length = ((Object[])Conversions.unwrapArray(it.getStatements(), Object.class)).length;
        return Boolean.valueOf((_length != 1));
      }
    };
    Assert.assertTrue(IterableExtensions.isEmpty(IterableExtensions.<ProcessBlock>filter(ifp.getThen(), _function_1)));
  }
  
  @Test
  public void if_Else() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("} else { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("set;");
    _builder.newLine();
    _builder.append("} ");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessIf));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessIf ifp = ((ProcessIf) _head_1);
    int _length = ((Object[])Conversions.unwrapArray(ifp.getCond(), Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
    int _length_1 = ((Object[])Conversions.unwrapArray(ifp.getAction(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 2);
    Assert.assertTrue(_equals_1);
    int _length_2 = ((Object[])Conversions.unwrapArray(ifp.getThen(), Object.class)).length;
    boolean _equals_2 = (_length_2 == 2);
    Assert.assertTrue(_equals_2);
    final Function1<ProcessStatement, Boolean> _function = new Function1<ProcessStatement, Boolean>() {
      public Boolean apply(final ProcessStatement it) {
        return Boolean.valueOf((!(it instanceof ProcessSend)));
      }
    };
    Assert.assertTrue(IterableExtensions.isEmpty(IterableExtensions.<ProcessStatement>filter(ifp.getAction(), _function)));
    final Function1<ProcessBlock, Boolean> _function_1 = new Function1<ProcessBlock, Boolean>() {
      public Boolean apply(final ProcessBlock it) {
        int _length = ((Object[])Conversions.unwrapArray(it.getStatements(), Object.class)).length;
        return Boolean.valueOf((_length != 1));
      }
    };
    Assert.assertTrue(IterableExtensions.isEmpty(IterableExtensions.<ProcessBlock>filter(ifp.getThen(), _function_1)));
  }
  
  @Test
  public void if_Else_Else() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("} else { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("} else { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("}");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertFalse(result.eResource().getErrors().isEmpty());
  }
  
  @Test
  public void if_Else_ElseIf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("} else { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("} else if (true) { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);");
    _builder.newLine();
    _builder.append("}");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertFalse(result.eResource().getErrors().isEmpty());
  }
  
  @Test
  public void sleep() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("waitfor(100);");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessWaitFor));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessWaitFor p = ((ProcessWaitFor) _head_1);
    Expression _cond = p.getCond();
    Assert.assertTrue((_cond instanceof IntConstant));
  }
  
  @Test
  public void awareness() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("waitfor(proc.x > 0);");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessWaitFor));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessWaitFor p = ((ProcessWaitFor) _head_1);
    Expression _cond = p.getCond();
    Assert.assertTrue((_cond instanceof Expression));
  }
  
  @Test
  public void set_() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set [comp.d := 9, proc.f := comp.d];");
    final ProcessBlock result = this.encapsulateProcess(_builder);
    Assert.assertNotNull(result);
    Assert.assertTrue(result.eResource().getErrors().isEmpty());
    ProcessStatement _head = IterableExtensions.<ProcessStatement>head(result.getStatements());
    Assert.assertTrue((_head instanceof ProcessSet));
    ProcessStatement _head_1 = IterableExtensions.<ProcessStatement>head(result.getStatements());
    final ProcessSet p = ((ProcessSet) _head_1);
    int _length = ((Object[])Conversions.unwrapArray(p.getUpdate().getAttribute(), Object.class)).length;
    boolean _equals = (_length == 2);
    Assert.assertTrue(_equals);
    int _length_1 = ((Object[])Conversions.unwrapArray(p.getUpdate().getValue(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 2);
    Assert.assertTrue(_equals_1);
    EObject _get = p.getUpdate().getAttribute().get(0);
    Assert.assertTrue((_get instanceof UpdateComponentAttribute));
    EObject _get_1 = p.getUpdate().getAttribute().get(0);
    String _atname = ((UpdateComponentAttribute) _get_1).getAtname();
    boolean _equals_2 = Objects.equal(_atname, "d");
    Assert.assertTrue(_equals_2);
    EObject _get_2 = p.getUpdate().getAttribute().get(1);
    Assert.assertTrue((_get_2 instanceof UpdateLocalAttribute));
    EObject _get_3 = p.getUpdate().getAttribute().get(1);
    String _atname_1 = ((UpdateLocalAttribute) _get_3).getAtname();
    boolean _equals_3 = Objects.equal(_atname_1, "f");
    Assert.assertTrue(_equals_3);
  }
}
