package com.sysma.goat.eclipse_plugin.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.sysma.goat.eclipse_plugin.tests.parser.*;
import com.sysma.goat.eclipse_plugin.tests.generator.*;
import com.sysma.goat.eclipse_plugin.tests.validator.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ComponentGeneratorTest.class,
	ExpressionGeneratorTest.class,
	ComponentsParsingTest.class,
	ExpressionParsingTest.class,
	FunctionParsingTest.class,
	ProcessParsingTest.class,
	ExpressionValidatorTest.class,
	FunctionValidationTest.class
})
public class TestSuite {
	
}