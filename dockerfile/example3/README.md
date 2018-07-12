# Docker Workshop - Live Session

## 1st Part - Mysql
#### Pull Image
```sh
docker pull mysql:5.7
```
#### Run Container
```sh
docker run -d --name mysql.c -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:5.7
```
#### Logs
```sh
docker logs -f mysql.c
```
#### Execute a command
```sh
docker exec -it mysql.c bash
```
#### Dockerfile
```
FROM mysql:5.7
VOLUME /var/lib/mysql
ENV MYSQL_ROOT_PASSWORD=root
ADD init.sql /docker-entrypoint-initdb.d
EXPOSE 3306
...
```
#### Build Dockerfile
```sh
docker build -t mysql.docker_ws:1.0 .
```
#### Run with Volume
```sh
docker run -d --name mysql.c -p 3306:3306 -v data:/var/lib/mysql mysql.docker_ws:1.0
```
## 2nd Part - Java App
#### Dockerfile
```
FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```
#### Build Dockerfile
```
docker build -t sample-spring-boot:latest --build-arg JAR_FILE=target/sample-spring-boot-0.0.1-SNAPSHOT.jar .
```
#### Logs
```
docker logs -f sample.c
```
#### Run Container
```
docker run -d --name sample.c -p 8080:8080 --link mysql.c sample-spring-boot:latest
```
