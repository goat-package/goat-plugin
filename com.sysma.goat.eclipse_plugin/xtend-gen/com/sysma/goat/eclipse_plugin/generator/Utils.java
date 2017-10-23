package com.sysma.goat.eclipse_plugin.generator;

import com.google.common.net.HostAndPort;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessCall;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessIf;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessLoop;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessReceive;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessSend;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessSet;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessSpawn;
import com.sysma.goat.eclipse_plugin.generator.CodeProcessWaitFor;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessCall;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessIf;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessLoop;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSpawn;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor;
import java.net.InetAddress;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Utils {
  public static CharSequence getImportPath() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"github.com/goat-package/goat/goat\"");
    return _builder;
  }
  
  public static CharSequence getCode(final ProcessStatement stmt, final LocalVariableMap locvars, final CharSequence processRef) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (stmt instanceof ProcessSpawn) {
      _matched=true;
      _switchResult = new CodeProcessSpawn(((ProcessSpawn)stmt), locvars, processRef).getCode();
    }
    if (!_matched) {
      if (stmt instanceof ProcessCall) {
        _matched=true;
        _switchResult = new CodeProcessCall(((ProcessCall)stmt)).getCode();
      }
    }
    if (!_matched) {
      if (stmt instanceof ProcessLoop) {
        _matched=true;
        _switchResult = new CodeProcessLoop(((ProcessLoop)stmt), locvars, processRef).getCode();
      }
    }
    if (!_matched) {
      if (stmt instanceof ProcessSend) {
        _matched=true;
        _switchResult = new CodeProcessSend(((ProcessSend)stmt), locvars, processRef).getCode();
      }
    }
    if (!_matched) {
      if (stmt instanceof ProcessReceive) {
        _matched=true;
        _switchResult = new CodeProcessReceive(((ProcessReceive)stmt), locvars, processRef).getCode();
      }
    }
    if (!_matched) {
      if (stmt instanceof ProcessIf) {
        _matched=true;
        _switchResult = new CodeProcessIf(((ProcessIf)stmt), locvars, processRef).code();
      }
    }
    if (!_matched) {
      if (stmt instanceof ProcessSet) {
        _matched=true;
        _switchResult = new CodeProcessSet(((ProcessSet)stmt), locvars, processRef).getCode();
      }
    }
    if (!_matched) {
      if (stmt instanceof ProcessWaitFor) {
        _matched=true;
        _switchResult = new CodeProcessWaitFor(((ProcessWaitFor)stmt), locvars, processRef).getCode();
      }
    }
    if (!_matched) {
      throw new UnsupportedOperationException("not implemented");
    }
    return _switchResult;
  }
  
  public static CharSequence utilityFunctions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("func runWith(wg *sync.WaitGroup, pfunc continuationProcess, vars *map[string]interface{}) func(*goat.Process){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("wg.Add(1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return func(p *goat.Process){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for fnc := pfunc; fnc != nil; fnc = fnc(wg, vars, p) {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("wg.Done()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("func mapCopy(x *map[string]interface{}) *map[string]interface{}{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("cx := map[string]interface{}{}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for k,v := range *x {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cx[k] = v");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return &cx");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("func getValue(x *map[string]interface{}, k string) interface{}{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("v, _ := (*x)[k]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return v");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("func has(x *map[string]interface{}, k string) bool{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("_, h := (*x)[k]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return h");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public static boolean isLocalAddress(final String address) {
    try {
      boolean _xblockexpression = false;
      {
        final InetAddress ad = InetAddress.getByName(HostAndPort.fromString(address).getHost());
        _xblockexpression = ad.isLoopbackAddress();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static int getPortNumber(final String address) {
    return HostAndPort.fromString(address).getPort();
  }
  
  public static CharSequence goList(final List<String> strings) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[]string{");
    final Function1<String, String> _function = (String it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"");
      _builder_1.append(it);
      _builder_1.append("\"");
      return _builder_1.toString();
    };
    String _join = IterableExtensions.join(ListExtensions.<String, String>map(strings, _function), ", ");
    _builder.append(_join);
    _builder.append("}");
    return _builder;
  }
}
