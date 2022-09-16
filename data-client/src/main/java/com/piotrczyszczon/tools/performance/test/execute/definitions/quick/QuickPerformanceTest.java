package com.piotrczyszczon.tools.performance.test.execute.definitions.quick;

import com.piotrczyszczon.tools.performance.configuration.Configuration;
import com.piotrczyszczon.tools.performance.configuration.TestConfiguration;
import com.piotrczyszczon.tools.performance.test.execute.AbstractPerformanceTest;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

public class QuickPerformanceTest extends AbstractPerformanceTest
{
  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  protected String getEndpointName()
  {
    return "quick";
  }

  @Override
  protected String getTestName()
  {
    return "quick";
  }

  @Override
  protected String getTestDescription()
  {
    return "Quick test checking latency of REST call that return small piece of text. Results in milliseconds.";
  }

  @Override
  protected boolean isTestConfigured(Configuration configuration)
  {
    return configuration.getQuickTest() != null;
  }


  @Override
  protected List<Long> performTest(String endpointUrl, Configuration configuration)
  {
    TestConfiguration quickTestConfiguration = configuration.getQuickTest();

    List<Long> executionTimes = new LinkedList<>();

    int testLength = quickTestConfiguration.getRepeats();

    for (int i = 0; i < testLength; ++i)
    {
      long t1 = System.currentTimeMillis();
      restTemplate.getForObject(endpointUrl, String.class);
      long t2 = System.currentTimeMillis();

      executionTimes.add(t2 - t1);
    }

    return executionTimes;
  }
}
