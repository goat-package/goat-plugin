package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CodeAttribute {
  private final String attribute;
  
  private final boolean comp;
  
  private final String componentMap;
  
  private final LocalVariableMap localMap;
  
  public CodeAttribute(final String attrName, final boolean comp, final String componentMap, final LocalVariableMap localMap) {
    this.attribute = attrName;
    this.comp = comp;
    this.componentMap = componentMap;
    this.localMap = localMap;
  }
  
  public CharSequence assign(final CharSequence value) {
    CharSequence _xifexpression = null;
    if (this.comp) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.componentMap);
      _builder.append(".Set(\"");
      _builder.append(this.attribute);
      _builder.append("\", ");
      _builder.append(value);
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      _xifexpression = this.localMap.assign(this.attribute, value);
    }
    return _xifexpression;
  }
  
  public CharSequence getName() {
    CharSequence _xifexpression = null;
    if (this.comp) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("comp.");
      _builder.append(this.attribute);
      _xifexpression = _builder;
    } else {
      _xifexpression = this.attribute;
    }
    return _xifexpression;
  }
  
  public CharSequence read() {
    CharSequence _xifexpression = null;
    if (this.comp) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.componentMap);
      _builder.append(".GetValue(\"");
      _builder.append(this.attribute);
      _builder.append("\")");
      _xifexpression = _builder;
    } else {
      _xifexpression = this.localMap.readValue(this.attribute);
    }
    return _xifexpression;
  }
  
  public CharSequence exists() {
    CharSequence _xifexpression = null;
    if (this.comp) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.componentMap);
      _builder.append(".Has(\"");
      _builder.append(this.attribute);
      _builder.append("\")");
      _xifexpression = _builder;
    } else {
      _xifexpression = this.localMap.has(this.attribute);
    }
    return _xifexpression;
  }
}
