# quarkus-microservice-test

<b>Run application (dev mode)</b>
1. up postgres container
</br><code>docker-compose -f docker/docker-compose.yml up -d</code>

2. running application
</br><code>mvn clean compile quarkus:dev</code>

<b>Run tests</b>
</br>All tests
</br><code>mvn clean test</code>

Run tests by tags (UNIT, INTEGRATION, CONTRACT, SERVICE)
</br><code>mvn clean -Dtag=integration test</code>
