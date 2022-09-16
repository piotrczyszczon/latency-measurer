package com.piotrczyszczon.tools.performance;

import com.piotrczyszczon.tools.performance.arguments.ArgumentsValidator;
import com.piotrczyszczon.tools.performance.configuration.Configuration;
import com.piotrczyszczon.tools.performance.configuration.TestConfiguration;
import com.piotrczyszczon.tools.performance.configuration.TestConfigurationProvider;
import com.piotrczyszczon.tools.performance.test.execute.PerformanceTestExecutor;
import com.piotrczyszczon.tools.performance.test.execute.result.TestResult;
import com.piotrczyszczon.tools.performance.test.report.TestReportPrinter;

import java.io.IOException;
import java.util.List;

public class Runner
{
  private final ArgumentsValidator argumentsValidator = new ArgumentsValidator();
  private final TestConfigurationProvider testConfigurationProvider = new TestConfigurationProvider();
  private final PerformanceTestExecutor performanceTestExecutor = new PerformanceTestExecutor();
  private final TestReportPrinter testReportPrinter = new TestReportPrinter();

  public static void main(String[] args) throws IOException
  {
    new Runner().run(args);
  }

  private void run(String[] args) throws IOException
  {
    if (args.length < 2)
    {
      System.out.println("Usage: <app> <server_address> <configuration>");
      System.exit(1);
    }

    String serverAddress = args[0];
    String configurationFilePath = args[1];

    argumentsValidator.validateArguments(serverAddress, configurationFilePath);

    Configuration configuration = testConfigurationProvider.readConfiguration(configurationFilePath);
    List<TestResult> testResults = performanceTestExecutor.performTest(serverAddress, configuration);
    testReportPrinter.printResults(testResults, configuration);
  }
}
