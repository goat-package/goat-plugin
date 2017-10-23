package com.sysma.goat.eclipse_plugin.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncBlock;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncParam;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncReturn;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarAssign;
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration;
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping;
import com.sysma.goat.eclipse_plugin.validation.AbstractGoatComponentsValidator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FunctionValidator extends AbstractGoatComponentsValidator {
  @Inject
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  @Check
  public void checkMustReturn(final FuncDefinition fdef) {
    boolean _isAlwaysReturning = this.isAlwaysReturning(fdef);
    boolean _not = (!_isAlwaysReturning);
    if (_not) {
      this.error("Functions must eventually return", 
        GoatComponentsPackage.eINSTANCE.getFuncDefinition_Blk());
    }
  }
  
  public boolean isAlwaysReturning(final Object x) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (x instanceof FuncDefinition) {
      _matched=true;
      _switchResult = this.isAlwaysReturning(((FuncDefinition)x).getBlk());
    }
    if (!_matched) {
      if (x instanceof FuncBlock) {
        _matched=true;
        final Function1<FuncStatement, Boolean> _function = (FuncStatement it) -> {
          return Boolean.valueOf(this.isAlwaysReturning(it));
        };
        _switchResult = IterableExtensions.<FuncStatement>exists(((FuncBlock)x).getStatements(), _function);
      }
    }
    if (!_matched) {
      if (x instanceof FuncVarDeclaration) {
        _matched=true;
      }
      if (!_matched) {
        if (x instanceof FuncVarAssign) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (x instanceof FuncIfElse) {
        _matched=true;
        _switchResult = (IterableExtensions.<FuncBlock>forall(((FuncIfElse)x).getThen(), ((Function1<FuncBlock, Boolean>) (FuncBlock it) -> {
          return Boolean.valueOf(this.isAlwaysReturning(it));
        })) && ((((FuncIfElse)x).getElseBranch() != null) && 
          this.isAlwaysReturning(((FuncIfElse)x).getElseBranch())));
      }
    }
    if (!_matched) {
      if (x instanceof FuncReturn) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  @Check
  public void checkReturningThePromisedType(final FuncReturn fRet) {
    EObject eobj = fRet.eContainer();
    while (((eobj != null) && (!(eobj instanceof FuncDefinition)))) {
      eobj = eobj.eContainer();
    }
    if ((eobj != null)) {
      FuncDefinition fdef = ((FuncDefinition) eobj);
      final ExpressionTyping.ExprType promise = ExpressionTyping.typeOf(fdef.getType());
      ExpressionTyping.ExprType _typeOf = ExpressionTyping.typeOf(fRet.getVal());
      boolean _notEquals = (!Objects.equal(_typeOf, promise));
      if (_notEquals) {
        String _goType = ExpressionTyping.goType(promise);
        String _plus = ("Must return a " + _goType);
        this.error(_plus, GoatComponentsPackage.eINSTANCE.getFuncReturn_Val());
      }
    }
  }
  
  @Check
  public void noDuplicateVars(final FuncVarDeclaration vdecl) {
    EObject eobj = vdecl.eContainer();
    while (((eobj != null) && (!(eobj instanceof FuncDefinition)))) {
      eobj = eobj.eContainer();
    }
    if ((eobj != null)) {
      FuncDefinition fdef = ((FuncDefinition) eobj);
      final Function1<FuncVarDeclaration, Boolean> _function = (FuncVarDeclaration it) -> {
        return Boolean.valueOf(((!Objects.equal(vdecl, it)) && Objects.equal(vdecl.getName(), it.getName())));
      };
      FuncVarDeclaration _findFirst = IterableExtensions.<FuncVarDeclaration>findFirst(EcoreUtil2.<FuncVarDeclaration>getAllContentsOfType(fdef.getBlk(), FuncVarDeclaration.class), _function);
      boolean _tripleNotEquals = (_findFirst != null);
      if (_tripleNotEquals) {
        String _name = vdecl.getName();
        String _plus = ("Variable " + _name);
        String _plus_1 = (_plus + " declared multiple times");
        this.error(_plus_1, GoatComponentsPackage.eINSTANCE.getLRef_Name());
      }
    }
  }
  
  @Check
  public void noDuplicateFunctions(final FuncDefinition func) {
    EObject eobj = func.eContainer();
    while (((eobj != null) && (!(eobj instanceof Model)))) {
      eobj = eobj.eContainer();
    }
    if ((eobj != null)) {
      Model model = ((Model) eobj);
      final Function1<FuncDefinition, Boolean> _function = (FuncDefinition it) -> {
        return Boolean.valueOf(((!Objects.equal(func, it)) && Objects.equal(func.getName(), it.getName())));
      };
      FuncDefinition _findFirst = IterableExtensions.<FuncDefinition>findFirst(EcoreUtil2.<FuncDefinition>getAllContentsOfType(model, FuncDefinition.class), _function);
      boolean _tripleNotEquals = (_findFirst != null);
      if (_tripleNotEquals) {
        String _name = func.getName();
        String _plus = ("Function " + _name);
        String _plus_1 = (_plus + " declared multiple times");
        this.error(_plus_1, GoatComponentsPackage.eINSTANCE.getFuncDefinition_Name());
      }
    }
  }
  
  @Check
  public void noVarsHidingParams(final FuncVarDeclaration vdecl) {
    EObject eobj = vdecl.eContainer();
    while (((eobj != null) && (!(eobj instanceof FuncDefinition)))) {
      eobj = eobj.eContainer();
    }
    if ((eobj != null)) {
      FuncDefinition fdef = ((FuncDefinition) eobj);
      final Function1<FuncParam, Boolean> _function = (FuncParam param) -> {
        String _name = param.getName();
        String _name_1 = vdecl.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      boolean _exists = IterableExtensions.<FuncParam>exists(fdef.getParams(), _function);
      if (_exists) {
        String _name = vdecl.getName();
        String _plus = ("Cannot declare " + _name);
        String _plus_1 = (_plus + " as one of the params has the same name");
        this.error(_plus_1, GoatComponentsPackage.eINSTANCE.getLRef_Name());
      }
    }
  }
  
  @Check
  public void noDuplicateParams(final FuncParam pdecl) {
    EObject _eContainer = pdecl.eContainer();
    if ((_eContainer instanceof FuncDefinition)) {
      EObject _eContainer_1 = pdecl.eContainer();
      FuncDefinition fdef = ((FuncDefinition) _eContainer_1);
      final Function1<FuncParam, Boolean> _function = (FuncParam param) -> {
        return Boolean.valueOf((Objects.equal(param.getName(), pdecl.getName()) && (pdecl != param)));
      };
      boolean _exists = IterableExtensions.<FuncParam>exists(fdef.getParams(), _function);
      if (_exists) {
        String _name = pdecl.getName();
        String _plus = ("Parameter " + _name);
        String _plus_1 = (_plus + " declared multiple times");
        this.error(_plus_1, GoatComponentsPackage.eINSTANCE.getLRef_Name());
      }
    }
  }
}
