# quarkus-microservice-test

<b>Run application</b>
1. up postgres container  
<code>docker-compose -f docker/docker-compose.yml up -d</code>

2. running application (dev mode)  
<code>mvn clean compile quarkus:dev</code>

3. running application (prod mode)  
3.1. generate jar
<code>mvn clean install</code>  
3.2. running  
<code>java -jar target/quarkus-microservice-test-1.0.0-SNAPSHOT-runner.jar</code>

<b>Run tests</b>  
All tests  
<code>mvn clean test</code>

Run tests by tags (UNIT, INTEGRATION, CONTRACT, SERVICE)  
<code>mvn clean -Dtag=integration test</code>

<b>Jenkins start</b>  
<code>docker run --name jenkins-tdc2019 -u root -p 9090:9090 -p 50000:50000 -v ~/tdc2019/jenkins_folder:/var/jenkins_home jenkins/jenkins:lts</code>

Importante: será exibido no console a senha inicial de admin do Jenkins, guarde essa senha (password directory: /var/jenkins_home/secrets/initialAdminPassword)

Após inicializar o jenkins, basta acessar no navegador a URL: http://localhost:9090

### Como executar aplicação via docker:

1 - Execute o script 'generate-image.sh', presente na pasta raiz do projeto, para gerar a imagem docker da aplicação;

2 - Execute o script 'docker-start.sh' para iniciar o container da aplicação;

OBS: Caso tenha feito alguma alteração de código, gere novamente a imagem docker usando o comando 'generate-image.sh' e depois use o comando 'docker-update.sh', na pasta 'docker', para subir um novo container do docker

### Opções de compilação
Existem duas formas de compilar o projeto, com ou sem GraalVM.

**Com GraalVM**:  
mvn package -Pnative -DskipTests

**Sem GraalVM**:  
mvn package -DskipTests
