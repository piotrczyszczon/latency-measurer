package com.piotrczyszczon.tools.performance.test.execute.result;

import java.util.List;

public class TestResult
{
  private String name;
  private String description;
  private List<Long> executionTimes;
  private boolean executed;

  private TestResult(String name, String description, List<Long> executionTimes, boolean executed)
  {
    this.name = name;
    this.description = description;
    this.executionTimes = executionTimes;
    this.executed = executed;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public List<Long> getExecutionTimes()
  {
    return executionTimes;
  }

  public boolean wasExecuted()
  {
    return executed;
  }

  public static TestResult emptyResult()
  {
    return new TestResult("", "", null, false);
  }

  public static TestResult testResult(String name, String description, List<Long> executionTimes)
  {
    return new TestResult(name, description, executionTimes, true);
  }
}
