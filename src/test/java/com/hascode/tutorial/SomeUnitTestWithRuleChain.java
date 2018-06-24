package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class SomeUnitTestWithRuleChain {

  @ClassRule
  public static TestRule chain = RuleChain.outerRule(new ConsoleOutTestWrapper("outer"))
      .around(new ConsoleOutTestWrapper("middle"))
      .around(new ConsoleOutTestWrapper("inner"));

  @Test
  public void testSomeMethod1() {
    System.out.println("test 1 started");
    assertTrue(true);
  }

  @Test
  public void testSomeMethod2() {
    System.out.println("test 2 started");
    assertTrue(true);
  }

  static class ConsoleOutTestWrapper extends ExternalResource {

    private final String note;

    ConsoleOutTestWrapper(String note) {
      this.note = note;
    }

    @Override
    protected void before() throws Throwable {
      System.out.printf("[BEFORE] rule applied. note: %s%n", note);
    }

    @Override
    protected void after() {
      System.out.printf("[AFTER] rule applied. note: %s%n", note);
    }
  }

}
