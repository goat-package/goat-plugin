package com.sysma.goat.eclipse_plugin.tests.validator;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ValidationTestHelper2 extends ValidationTestHelper {
  public Iterable<Issue> errors(final EObject resource) {
    Iterable<Issue> _xblockexpression = null;
    {
      final List<Issue> validate = this.validate(resource);
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
        }
      };
      _xblockexpression = IterableExtensions.<Issue>filter(validate, _function);
    }
    return _xblockexpression;
  }
}
