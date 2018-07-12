package it.sky.dp.samplespringboot.controllers;

import it.sky.dp.samplespringboot.models.User;
import it.sky.dp.samplespringboot.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/users", consumes = "application/json")
    public void postUser(@RequestBody User user) {
        log.info("[POSTED]" + user.toString());
        userService.createUser(user);
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public User getUser(@PathVariable("id") Integer id) {
        log.info("[REQUESTED ID]" + id);
        return userService.getUser(id);
    }

}
