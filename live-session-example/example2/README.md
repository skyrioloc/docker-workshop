# Apache simple website

In this example we will run an Apache server that will host a simple static website.

We first create an image starting from a Dockerfile. The image name will be example1:
```
docker build -t example2 .
```

Let's go look inside the **Dockerfile**:
```
FROM httpd
COPY ./index.html /usr/local/apache2/htdocs/
```

Now we can run the container from the image that we have created:
```
docker run -p 8080:80 -d example2
```
The container will be executed in background by means of the flag ``-d``
We are mapping the host port 8080 to the container port 80.

## Interacting with container

```
docker exec -it <container-id> bash
cd htdocs
echo "Let's create a new homepage!" > ./index.html
```


