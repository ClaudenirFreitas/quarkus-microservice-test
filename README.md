![Java CI with Maven](https://github.com/ClaudenirFreitas/quarkus-microservice-test/workflows/Java%20CI%20with%20Maven/badge.svg)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=quarkus-microservice-test&metric=alert_status)](https://sonarcloud.io/dashboard?id=quarkus-microservice-test)

# quarkus-microservice-test

## Run application

1 - up mysql container  
`docker-compose -f docker/docker-compose.yml up -d`

2 - running application (dev mode)  
`mvn clean compile quarkus:dev`

3 - running application (prod mode)  
`mvn clean install && java -jar target/quarkus-microservice-test-1.0.0-SNAPSHOT-runner.jar`


## Como executar aplicação via docker:

1 - Execute o script 'generate-image.sh', presente na pasta raiz do projeto, para gerar a imagem docker da aplicação;

2 - Execute o script 'docker-start.sh' para iniciar o container da aplicação;


## Opções de compilação
Existem duas formas de compilar o projeto, com ou sem GraalVM.

**Com GraalVM**:  
mvn package -Pnative -DskipTests

**Sem GraalVM**:  
mvn package -DskipTests
