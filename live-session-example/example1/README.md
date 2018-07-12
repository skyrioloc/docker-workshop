# TomCat and Servlet

In this example we will deploy two servlets on a **Tomcat JavaEE** inside a **Docker** container

First of all, we need to produce the .war that will be deployed:
```
mvn package
```

Then, we create an image starting from a Dockerfile. The image name will be example1:
```
docker build -t example1 .
```
Let's go look inside the Dockerfile:
```
FROM tomcat
COPY ./target/servlet-example-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/myapp.war
COPY ./tomcat-users.xml /usr/local/tomcat/conf

EXPOSE 8080
```

And finally we can run the container from the image that we have created:
```
docker run -p 8080:8080 example1
```

We are mapping the host port 8080 to the container port 8080.


## Scalability and Expandability

- What if we want to pass from Tomcat 8.5 to another version? 
    - We simple change the Tomcat version into Dockerfile