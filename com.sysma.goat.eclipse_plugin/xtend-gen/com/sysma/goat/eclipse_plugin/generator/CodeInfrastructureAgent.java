package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeInfrastructureAgent {
  private final Infrastructure infr;
  
  public CodeInfrastructureAgent(final Infrastructure infr) {
    this.infr = infr;
  }
  
  public CharSequence getCode() {
    CharSequence _switchResult = null;
    final Infrastructure infr = this.infr;
    boolean _matched = false;
    if (infr instanceof SingleServer) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("goat.NewSingleServerAgent(\"");
      String _server = ((SingleServer)this.infr).getServer();
      _builder.append(_server);
      _builder.append("\")");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (infr instanceof Cluster) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("goat.NewClusterAgent(\"");
        String _message_queue = ((Cluster)this.infr).getMessage_queue();
        _builder.append(_message_queue);
        _builder.append("\", \"");
        String _registration = ((Cluster)this.infr).getRegistration();
        _builder.append(_registration);
        _builder.append("\")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (infr instanceof Ring) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("goat.NewRingAgent(\"");
        String _registration = ((Ring)this.infr).getRegistration();
        _builder.append(_registration);
        _builder.append("\")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (infr instanceof Tree) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("goat.NewTreeAgent(\"");
        String _registration = ((Tree)this.infr).getRegistration();
        _builder.append(_registration);
        _builder.append("\")");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
}
