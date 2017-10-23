package com.sysma.goat.eclipse_plugin.generator;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LocalVariableMap {
  public final CharSequence name;
  
  public LocalVariableMap(final CharSequence name) {
    this.name = name;
  }
  
  public CharSequence assign(final CharSequence varname, final CharSequence value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(*");
    _builder.append(this.name);
    _builder.append(")[\"");
    _builder.append(varname);
    _builder.append("\"] = ");
    _builder.append(value);
    return _builder;
  }
  
  public CharSequence declare() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.name);
    _builder.append(" := new(map[string]interface{})");
    return _builder;
  }
  
  public CharSequence copy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mapCopy(");
    _builder.append(this.name);
    _builder.append(")");
    return _builder;
  }
  
  public String readValue(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("getValue(");
    _builder.append(this.name);
    _builder.append(", \"");
    _builder.append(string);
    _builder.append("\")");
    return _builder.toString();
  }
  
  public String has(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("has(");
    _builder.append(this.name);
    _builder.append(", ");
    _builder.append(string);
    _builder.append(")");
    return _builder.toString();
  }
}
