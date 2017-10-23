package com.sysma.goat.eclipse_plugin.generator;

import com.sysma.goat.eclipse_plugin.generator.CodeExpression;
import com.sysma.goat.eclipse_plugin.generator.LocalVariableMap;
import com.sysma.goat.eclipse_plugin.goatComponents.Update;
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateComponentAttribute;
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateLocalAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class CodeUpdate {
  private final Update update;
  
  private final LocalVariableMap map;
  
  private final CharSequence procRef;
  
  private final CharSequence attrName;
  
  public CodeUpdate(final Update update, final LocalVariableMap map, final CharSequence procRef, final CharSequence attrName) {
    this.update = update;
    this.map = map;
    this.procRef = procRef;
    this.attrName = attrName;
  }
  
  public CharSequence getCode() {
    final Function1<Pair<Integer, EObject>, CharSequence> _function = (Pair<Integer, EObject> vidx) -> {
      CharSequence _xblockexpression = null;
      {
        final EObject varUpd = vidx.getValue();
        final CharSequence valUpd = CodeExpression.getExpressionWithAttributes(this.update.getValue().get((vidx.getKey()).intValue()), this.map, this.attrName);
        CharSequence _switchResult = null;
        boolean _matched = false;
        if (varUpd instanceof UpdateComponentAttribute) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(this.attrName);
          _builder.append(".Set(\"");
          String _atname = ((UpdateComponentAttribute)varUpd).getAtname();
          _builder.append(_atname);
          _builder.append("\", ");
          _builder.append(valUpd);
          _builder.append(")");
          _switchResult = _builder.toString();
        }
        if (!_matched) {
          if (varUpd instanceof UpdateLocalAttribute) {
            _matched=true;
            _switchResult = this.map.assign(((UpdateLocalAttribute)varUpd).getAtname(), valUpd);
          }
        }
        if (!_matched) {
          _switchResult = "";
        }
        _xblockexpression = _switchResult;
      }
      return _xblockexpression;
    };
    return IterableExtensions.join(IterableExtensions.<Pair<Integer, EObject>, CharSequence>map(IterableExtensions.<EObject>indexed(this.update.getAttribute()), _function), "\n");
  }
}
