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
docker ps
docker ps -a
```

And there you are! We can also look a lot closer to that container with

```
docker inspect <container-id>
```

Now let's get serious. Let's run a full-fledged Ubuntu Linux:

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