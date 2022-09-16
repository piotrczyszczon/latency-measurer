package com.piotrczyszczon.tools.performance.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class TestConfigurationProvider
{
  public Configuration readConfiguration(String configurationFilePath) throws IOException
  {
    ObjectMapper objectMapper = getConfiguredObjectMapper();

    return objectMapper.readValue(new File(configurationFilePath), Configuration.class);
  }

  private ObjectMapper getConfiguredObjectMapper()
  {
    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    return objectMapper;
  }
}
