# quarkus-microservice-test

<b>Run application</b>
1. up postgres container
</br><code>docker-compose -f docker/docker-compose.yml up -d</code>

2. running application (dev mode)
</br><code>mvn clean compile quarkus:dev</code>

3. running application (prod mode)
</br><code>mvn clean install</code>
</br><code>java -jar target/quarkus-microservice-test-1.0.0-SNAPSHOT-runner.jar</code>

<b>Run tests</b>
</br>All tests
</br><code>mvn clean test</code>

Run tests by tags (UNIT, INTEGRATION, CONTRACT, SERVICE)
</br><code>mvn clean -Dtag=integration test</code>
