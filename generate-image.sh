#!/usr/bin/env bash
mvn clean install -Pnative -DskipTests

docker build -t tdc2019/quarkus-microservice-test:latest .
