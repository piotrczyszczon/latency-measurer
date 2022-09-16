package com.piotrczyszczon.tools.performance.arguments;

import java.nio.file.Path;

public class ArgumentsValidator
{
  public void validateArguments(String serverAddress, String configurationFilePath)
  {
    if (!Path.of(configurationFilePath).toFile().exists())
    {
      throw new IllegalArgumentException("Configuration file does not exists: " + configurationFilePath);
    }
  }
}
