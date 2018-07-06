# Images

_Images_ are the templates docker uses to create containers from. 
Check which images you have in your local repository by doing:

```
docker images
```

Let's try and get another image

```
docker pull mongo
```
This last command _pulled_ an image named `mongo` from [the public docker repository](https://hub.docker.com) to your local repository. This is very similar to what you achieve with `git pull` from a public `git` repository.

Cool! So now we have an image we didn't create a container from.


## Building images with Dockerfile

A docker image is made of one or more layers. Each layer is built on top of the previous one and they're all immutable. This means you can't modify an existing layer, instead you create a new one made of changes from the previous layer. This is very similar to how `git`'s diff works.

In order to build an image, you will need a `Dockerfile`:

```
cd ./dockerfile/example1
mvn package
docker build -t example1 .
docker run -p 8080:8080 example1
```

## Dockerfile commands