package com.piotrczyszczon.tools.performance.test.execute;

import com.piotrczyszczon.tools.performance.configuration.Configuration;
import com.piotrczyszczon.tools.performance.test.execute.definitions.quick.QuickPerformanceTest;
import com.piotrczyszczon.tools.performance.test.execute.result.TestResult;

import java.util.List;
import java.util.stream.Collectors;

public class PerformanceTestExecutor
{
  private final List<AbstractPerformanceTest> performanceTests = List.of(
    new QuickPerformanceTest()
  );

  public List<TestResult> performTest(String serverAddress, Configuration configuration)
  {
    return performanceTests.stream()
                           .map(test -> test.execute(serverAddress, configuration))
                           .collect(Collectors.toList());
  }
}
