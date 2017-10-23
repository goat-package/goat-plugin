package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeInfrastructure;
import com.sysma.goat.eclipse_plugin.generator.Utils;
import com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeSingleServer implements CodeInfrastructure {
  private final SingleServer ssrv;
  
  public CodeSingleServer(final SingleServer ssrv) {
    this.ssrv = ssrv;
  }
  
  @Override
  public String getCode() {
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
      boolean _isLocalAddress = Utils.isLocalAddress(this.ssrv.getServer());
      if (_isLocalAddress) {
        _builder.append("\t");
        _builder.append("term := make(chan struct{})");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("goat.RunCentralServer(");
        int _portNumber = Utils.getPortNumber(this.ssrv.getServer());
        _builder.append(_portNumber, "\t");
        _builder.append(", term, ");
        int _timeout = this.ssrv.getTimeout();
        _builder.append(_timeout, "\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("fmt.Println(\"Started\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<- term");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("fmt.Println(\"Terminated\")");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("fmt.Println(\"Started\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("_ = goat.RunCentralServer");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String getServerAddress() {
    return this.ssrv.getServer();
  }
}
