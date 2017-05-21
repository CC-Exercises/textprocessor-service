# SimpleTextProcessor

A simple REST service that takes a string and returns the processed string. Currently, the service only appends some text to the string (something like `'[processed by <serviceID>] - <original string>'`).

How to start the SimpleTextProcessor application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/SimpleTextProcessor-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running, POST a string to `http://localhost/api`

Processing Latency
---

The service can be configured to include a latency when processing text. The default latency is 0 (no latency). Setting the latency is done like that:

`curl -X POST http://localhost:8081/tasks/latency?latencyMs=500`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
