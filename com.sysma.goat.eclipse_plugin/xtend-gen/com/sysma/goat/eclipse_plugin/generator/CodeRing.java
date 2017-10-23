package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeInfrastructure;
import com.sysma.goat.eclipse_plugin.generator.Utils;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class CodeRing implements CodeInfrastructure {
  private final Ring ring;
  
  public CodeRing(final Ring ring) {
    this.ring = ring;
  }
  
  @Override
  public String getCode() {
    String _xblockexpression = null;
    {
      final boolean mustWait = ((Utils.isLocalAddress(this.ring.getMid_assigner()) || Utils.isLocalAddress(this.ring.getRegistration())) || 
        (!IterableExtensions.isEmpty(IterableExtensions.<String>filter(this.ring.getNodes(), ((Function1<String, Boolean>) (String it) -> {
          return Boolean.valueOf(Utils.isLocalAddress(it));
        })))));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package main");
      _builder.newLine();
      _builder.append("import (");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _importPath = Utils.getImportPath();
      _builder.append(_importPath, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("\"fmt\"");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.newLine();
      _builder.append("func main(){");
      _builder.newLine();
      {
        boolean _isLocalAddress = Utils.isLocalAddress(this.ring.getMid_assigner());
        if (_isLocalAddress) {
          _builder.append("\t");
          _builder.append("go goat.NewClusterCounter(");
          int _portNumber = Utils.getPortNumber(this.ring.getMid_assigner());
          _builder.append(_portNumber, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _isLocalAddress_1 = Utils.isLocalAddress(this.ring.getRegistration());
        if (_isLocalAddress_1) {
          _builder.append("\t");
          _builder.append("go goat.NewRingAgentRegistration(");
          int _portNumber_1 = Utils.getPortNumber(this.ring.getRegistration());
          _builder.append(_portNumber_1, "\t");
          _builder.append(", ");
          CharSequence _goList = Utils.goList(this.ring.getNodes());
          _builder.append(_goList, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        final Function1<Pair<Integer, String>, Boolean> _function = (Pair<Integer, String> it) -> {
          return Boolean.valueOf(Utils.isLocalAddress(it.getValue()));
        };
        Iterable<Pair<Integer, String>> _filter = IterableExtensions.<Pair<Integer, String>>filter(IterableExtensions.<String>indexed(this.ring.getNodes()), _function);
        for(final Pair<Integer, String> node : _filter) {
          _builder.append("\t");
          _builder.append("go goat.NewRingNode(");
          int _portNumber_2 = Utils.getPortNumber(node.getValue());
          _builder.append(_portNumber_2, "\t");
          _builder.append(", \"");
          String _mid_assigner = this.ring.getMid_assigner();
          _builder.append(_mid_assigner, "\t");
          _builder.append("\", \"");
          EList<String> _nodes = this.ring.getNodes();
          Integer _key = node.getKey();
          int _plus = ((_key).intValue() + 1);
          int _length = ((Object[])Conversions.unwrapArray(this.ring.getNodes(), Object.class)).length;
          int _modulo = (_plus % _length);
          String _get = _nodes.get(_modulo);
          _builder.append(_get, "\t");
          _builder.append("\").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("fmt.Println(\"Started\")");
      _builder.newLine();
      {
        if (mustWait) {
          _builder.append("\t");
          _builder.append("<- make(chan bool)");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("_ = goat.NewClusterCounter");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
