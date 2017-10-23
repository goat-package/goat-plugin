package com.sysma.goat.eclipse_plugin.tests.parser;

import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.goatComponents.Model;
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider;
import com.sysma.goat.eclipse_plugin.tests.parser.ParsingTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(GoatComponentsInjectorProvider.class)
@SuppressWarnings("all")
public class ComponentsParsingTest {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Test
  public void emptyComponent() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attrs is undefined for the type EnvironmentDefinition"
      + "\nlength cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  @Test
  public void filledComponent() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attrs is undefined for the type EnvironmentDefinition"
      + "\nlength cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  @Test
  public void numberedAttributeNotAllowed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {}");
      _builder.newLine();
      _builder.append("component {5 := 4} P at \"ip\"");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void componentMustReferAProcess() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("infrastructure infr");
      _builder.newLine();
      _builder.newLine();
      _builder.append("process P {}");
      _builder.newLine();
      _builder.append("component {x := 4}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      ParsingTestHelper.checkErrorApartInfr(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
