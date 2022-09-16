package com.piotrczyszczon.tools.performance.test.report;

import com.piotrczyszczon.tools.performance.configuration.Configuration;
import com.piotrczyszczon.tools.performance.test.execute.result.TestResult;
import com.piotrczyszczon.tools.performance.test.report.util.ResultFilePathProvider;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.piotrczyszczon.tools.performance.test.report.util.ResultFilePathProvider.getOutputDescriptionFilePath;
import static com.piotrczyszczon.tools.performance.test.report.util.ResultFilePathProvider.getOutputDirPath;

public class TestReportPrinter
{
  public void printResults(List<TestResult> testResults, Configuration configuration) throws IOException
  {
    for (TestResult testResult : testResults)
    {
      if (testResult.wasExecuted())
      {
        ensureOutputDirectoryExists(testResult, configuration);

        printTestDescription(testResult, configuration);
        printExecutionTimes(testResult, configuration);
      }
    }
  }

  private void ensureOutputDirectoryExists(TestResult testResult, Configuration configuration) throws IOException
  {
    Path outputDirPath = getOutputDirPath(testResult, configuration);

    Files.createDirectories(outputDirPath);
  }

  private void printTestDescription(TestResult testResult, Configuration configuration) throws IOException
  {
    Path descriptionFilePath = getOutputDescriptionFilePath(testResult, configuration);
    Files.writeString(descriptionFilePath, testResult.getDescription());
  }

  private void printExecutionTimes(TestResult testResult, Configuration configuration) throws IOException
  {
    File outputFile = ResultFilePathProvider.getOutputResultsFile(testResult, configuration);
    FileUtils.writeLines(outputFile, testResult.getExecutionTimes());
  }
}
