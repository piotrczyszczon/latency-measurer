package com.piotrczyszczon.tools.performance.test.execute;

import com.piotrczyszczon.tools.performance.configuration.Configuration;
import com.piotrczyszczon.tools.performance.test.execute.common.ServerUrlProvider;
import com.piotrczyszczon.tools.performance.test.execute.result.TestResult;

import java.util.List;

public abstract class AbstractPerformanceTest
{
  protected abstract String getEndpointName();

  protected abstract String getTestName();

  protected abstract String getTestDescription();

  protected abstract boolean isTestConfigured(Configuration configuration);

  TestResult execute(String serverAddress, Configuration configuration)
  {
    if (isTestConfigured(configuration))
    {
      List<Long> executionTimes = performTest(ServerUrlProvider.getEndpoint(ServerUrlProvider.getServerUrl(serverAddress), getEndpointName()), configuration);

      return TestResult.testResult(
        getTestName(),
        getTestDescription(),
        executionTimes
      );
    }
    else
    {
      return TestResult.emptyResult();
    }
  }


  protected abstract List<Long> performTest(String endpointUrl, Configuration configuration);
}
