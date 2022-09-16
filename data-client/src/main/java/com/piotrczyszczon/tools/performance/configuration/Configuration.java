package com.piotrczyszczon.tools.performance.configuration;

public class Configuration
{
  private TestConfiguration quickTest;
  private String outputDirectory = ".";

  public TestConfiguration getQuickTest()
  {
    return quickTest;
  }

  public void setQuickTest(TestConfiguration quickTest)
  {
    this.quickTest = quickTest;
  }

  public String getOutputDirectory()
  {
    return outputDirectory;
  }

  public void setOutputDirectory(String outputDirectory)
  {
    this.outputDirectory = outputDirectory;
  }
}
