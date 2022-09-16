package com.piotrczyszczon.tools.performance.test.report.util;

import com.piotrczyszczon.tools.performance.configuration.Configuration;
import com.piotrczyszczon.tools.performance.configuration.TestConfiguration;
import com.piotrczyszczon.tools.performance.test.execute.result.TestResult;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResultFilePathProvider
{
  public static File getOutputResultsFile(TestResult testResult, Configuration configuration)
  {
    return getOutputDirPath(testResult, configuration).resolve("output.csv").toFile();
  }

  public static Path getOutputDescriptionFilePath(TestResult testResult, Configuration configuration)
  {
    return getOutputDirPath(testResult, configuration).resolve("README");
  }

  public static Path getOutputDirPath(TestResult testResult, Configuration configuration)
  {
    return Paths.get(configuration.getOutputDirectory()).resolve(testResult.getName());
  }
}
