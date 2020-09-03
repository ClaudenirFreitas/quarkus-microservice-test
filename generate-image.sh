#!/usr/bin/env bash
mvn clean package -DskipTests

cp target/quarkus-microservice-test-1.0.0-SNAPSHOT-runner.jar docker/app.jar

docker build -t tdc2019/quarkus-microservice-test:latest .
