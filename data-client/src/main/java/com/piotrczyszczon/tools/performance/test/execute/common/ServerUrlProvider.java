package com.piotrczyszczon.tools.performance.test.execute.common;

public class ServerUrlProvider
{
  private static final String SERVER_URL = "http://%s";
  private static final String ENDPOINT_URL = "%s/%s";

  public static String getServerUrl(String serverAddress)
  {
    return String.format(SERVER_URL, serverAddress);
  }

  public static String getEndpoint(String serverUrl, String endpointName)
  {
    return String.format(ENDPOINT_URL, serverUrl, endpointName);
  }
}
