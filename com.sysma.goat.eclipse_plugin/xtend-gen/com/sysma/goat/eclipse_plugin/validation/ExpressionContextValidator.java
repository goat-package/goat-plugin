package com.sysma.goat.eclipse_plugin.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.ComponentAttributeRef;
import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage;
import com.sysma.goat.eclipse_plugin.goatComponents.LocalAttributeRef;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend;
import com.sysma.goat.eclipse_plugin.goatComponents.RecAttributeRef;
import com.sysma.goat.eclipse_plugin.validation.AbstractGoatComponentsValidator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

@SuppressWarnings("all")
public class ExpressionContextValidator extends AbstractGoatComponentsValidator {
  @Inject
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  @Check
  public void checkExpressionContext(final Expression expr) {
    boolean _matched = false;
    if (expr instanceof RecAttributeRef) {
      _matched=true;
      EObject eobj = expr;
      EObject eobjCont = eobj.eContainer();
      while ((eobjCont != null)) {
        if ((eobjCont instanceof ProcessSend)) {
          Expression _send_pred = ((ProcessSend)eobjCont).getSend_pred();
          boolean _equals = Objects.equal(_send_pred, eobj);
          if (_equals) {
            return;
          }
        } else {
          eobj = eobjCont;
          eobjCont = eobjCont.eContainer();
        }
      }
      this.error("Receiver attributes can be used only in output predicates", GoatComponentsPackage.eINSTANCE.getRecAttributeRef_Attribute());
    }
    if (!_matched) {
      if (expr instanceof ComponentAttributeRef) {
        _matched=true;
        EObject eobjCont = ((ComponentAttributeRef)expr).eContainer();
        while ((eobjCont != null)) {
          if ((eobjCont instanceof FuncDefinition)) {
            this.error("Attributes cannot be used inside functions", GoatComponentsPackage.eINSTANCE.getComponentAttributeRef_Attribute());
            eobjCont = null;
          } else {
            eobjCont = eobjCont.eContainer();
          }
        }
      }
    }
    if (!_matched) {
      if (expr instanceof LocalAttributeRef) {
        _matched=true;
        EObject eobjCont = ((LocalAttributeRef)expr).eContainer();
        while ((eobjCont != null)) {
          {
            if ((eobjCont instanceof FuncDefinition)) {
              this.error("Attributes cannot be used inside functions", GoatComponentsPackage.eINSTANCE.getLocalAttributeRef_Attribute());
            }
            eobjCont = eobjCont.eContainer();
          }
        }
      }
    }
  }
}
