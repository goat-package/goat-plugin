package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeInfrastructure;
import com.sysma.goat.eclipse_plugin.generator.Utils;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CodeCluster implements CodeInfrastructure {
  private final Cluster cluster;
  
  public CodeCluster(final Cluster cluster) {
    this.cluster = cluster;
  }
  
  @Override
  public String getCode() {
    String _xblockexpression = null;
    {
      final boolean mustWait = (((Utils.isLocalAddress(this.cluster.getMid_assigner()) || Utils.isLocalAddress(this.cluster.getRegistration())) || 
        Utils.isLocalAddress(this.cluster.getMessage_queue())) || (!IterableExtensions.isEmpty(IterableExtensions.<String>filter(this.cluster.getNodes(), ((Function1<String, Boolean>) (String it) -> {
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
        boolean _isLocalAddress = Utils.isLocalAddress(this.cluster.getMid_assigner());
        if (_isLocalAddress) {
          _builder.append("\t");
          _builder.append("go goat.NewClusterCounter(");
          int _portNumber = Utils.getPortNumber(this.cluster.getMid_assigner());
          _builder.append(_portNumber, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _isLocalAddress_1 = Utils.isLocalAddress(this.cluster.getRegistration());
        if (_isLocalAddress_1) {
          _builder.append("\t");
          _builder.append("go goat.NewClusterAgentRegistration(");
          int _portNumber_1 = Utils.getPortNumber(this.cluster.getRegistration());
          _builder.append(_portNumber_1, "\t");
          _builder.append(", \"");
          String _mid_assigner = this.cluster.getMid_assigner();
          _builder.append(_mid_assigner, "\t");
          _builder.append("\", ");
          CharSequence _goList = Utils.goList(this.cluster.getNodes());
          _builder.append(_goList, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _isLocalAddress_2 = Utils.isLocalAddress(this.cluster.getMessage_queue());
        if (_isLocalAddress_2) {
          _builder.append("\t");
          _builder.append("go goat.NewClusterMessageQueue(");
          int _portNumber_2 = Utils.getPortNumber(this.cluster.getMessage_queue());
          _builder.append(_portNumber_2, "\t");
          _builder.append(").Work(0, make(chan struct{}))");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        final Function1<String, Boolean> _function = (String it) -> {
          return Boolean.valueOf(Utils.isLocalAddress(it));
        };
        Iterable<String> _filter = IterableExtensions.<String>filter(this.cluster.getNodes(), _function);
        for(final String node : _filter) {
          _builder.append("\t");
          _builder.append("go goat.NewClusterNode(");
          int _portNumber_3 = Utils.getPortNumber(node);
          _builder.append(_portNumber_3, "\t");
          _builder.append(", \"");
          String _message_queue = this.cluster.getMessage_queue();
          _builder.append(_message_queue, "\t");
          _builder.append("\", \"");
          String _mid_assigner_1 = this.cluster.getMid_assigner();
          _builder.append(_mid_assigner_1, "\t");
          _builder.append("\", \"");
          String _registration = this.cluster.getRegistration();
          _builder.append(_registration, "\t");
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
