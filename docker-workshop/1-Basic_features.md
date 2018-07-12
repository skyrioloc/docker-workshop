# Docker basics

## Containers

The most fundamental part of `Docker` are *containers*. With the following command we can
see all the containers on this Host.

```
docker ps
```
Of course we have not any of them. 
Let's just run a really simple container:

```
docker run hello-world
```

Let's look at this container. The `-a` flag is used to show all containers, stopped ones as well.

```
docker ps -a
```

And there you are! We can also look a lot closer to that container with

```
docker inspect <container-id>
```

Now let's get **serious**. Let's run a full-fledged Ubuntu Linux:

```
docker run ubuntu
```

It looks like it downloaded something, but not sure what...

```
docker ps -a
```

So it stops after it runs? Let's try something else:

```
docker run -it ubuntu
```

Cool, we're inside the container! `-it` specifies you want to go into the interactive mode (TBH, `i` is interactive and `t` is for docker to allocate a pseudo TTY interface for the interaction)

After toying around just `exit`. Let's give it another look:

```
docker ps -a
```

We can also "connect" to a terminal into the container with the command

```
docker attach <container-id>
```

So the way containers work is that there is one single main process that gets assigned `pid 1`, which runs as the containers starts, and as soon as that process exits, the container is stopped, even if there were other processes running inside of it.

You may also have noticed that the first time you ran `docker run ubuntu` it took a while, but the second time it was immediate. What really happened is that docker tried to run a container based on the `ubuntu` image, and since it didn't have it locally, it pulled it from the public repository.

## Images

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


### Building images with Dockerfile

A docker image is made of one or more layers. Each layer is built on top of the previous one and they're all immutable. This means you can't modify an existing layer, instead you create a new one made of changes from the previous layer. This is very similar to how `git`'s diff works.

In order to build an image, you will need a `Dockerfile`:


### Dockerfile commands
(reference: https://docs.docker.com/engine/reference/builder)
- `FROM` defines the base image
- `RUN` will execute any commands in a new layer on top of the current image and commit the results.
- `CMD` represents the command that will be executed after all the layers have been istantiated. There can be only one CMD command for Dockerfile
- `EXPOSE` is used to specify port on container that will be open for the host machine (open port container side)


