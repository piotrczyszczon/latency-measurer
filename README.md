# latency-measurer
Client-Server tool to perform measurement of connection latency. It's designed to perform multiple client-server requests and aggregate request times into .csv reports.

# Usage

Compile project in root directory
```
mvn clean install
```

Run data-host application on remote host
```
java -jar data-host.jar
```

Run data-client application on source machine and provide server-address and configuration file in arguments
```
java -jar data-client.jar <server-address[host:port]> <configuration-file>
```

Example configuration file [.yaml]
```
# Directory path to store test results
outputDirectory: test-results
quickTest:
  # Amount of requests to execute
  repeats: 100
```