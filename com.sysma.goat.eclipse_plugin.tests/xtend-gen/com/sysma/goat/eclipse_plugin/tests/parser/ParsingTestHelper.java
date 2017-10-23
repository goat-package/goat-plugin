package com.sysma.goat.eclipse_plugin.tests.parser;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class ParsingTestHelper {
  public static void checkNoErrorApartInfr(final EObject obj) {
    final Function1<Resource.Diagnostic, Boolean> _function = new Function1<Resource.Diagnostic, Boolean>() {
      public Boolean apply(final Resource.Diagnostic it) {
        String _message = it.getMessage();
        return Boolean.valueOf((!Objects.equal(_message, "Couldn\'t resolve reference to Infrastructure \'infr\'.")));
      }
    };
    int _length = ((Object[])Conversions.unwrapArray(IterableExtensions.<Resource.Diagnostic>filter(obj.eResource().getErrors(), _function), Object.class)).length;
    boolean _equals = (_length == 0);
    Assert.assertTrue(_equals);
  }
  
  public static void checkErrorApartInfr(final EObject obj) {
    final Function1<Resource.Diagnostic, Boolean> _function = new Function1<Resource.Diagnostic, Boolean>() {
      public Boolean apply(final Resource.Diagnostic it) {
        String _message = it.getMessage();
        return Boolean.valueOf((!Objects.equal(_message, "Couldn\'t resolve reference to Infrastructure \'infr\'.")));
      }
    };
    int _length = ((Object[])Conversions.unwrapArray(IterableExtensions.<Resource.Diagnostic>filter(obj.eResource().getErrors(), _function), Object.class)).length;
    boolean _equals = (_length == 0);
    Assert.assertFalse(_equals);
  }
}
