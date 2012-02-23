package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class SomeUnitTestWithRuleChain {
	@Rule
	public TestRule chain = RuleChain.outerRule(new ConsoleOutRule("outer"))
			.around(new ConsoleOutRule("middle"))
			.around(new ConsoleOutRule("inner"));

	@Test
	public void testSomeMethod() {
		System.out.println("test started");
		assertTrue(true);
	}
}
