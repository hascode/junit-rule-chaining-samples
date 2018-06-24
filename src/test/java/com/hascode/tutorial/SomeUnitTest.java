package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

public class SomeUnitTest {
	@Rule
	public ConsoleOutRule rule = new ConsoleOutRule("somewhere");

	@Test
	public void testSomeMethod() {
		System.out.println("test started");
		assertTrue(true);
	}
}
