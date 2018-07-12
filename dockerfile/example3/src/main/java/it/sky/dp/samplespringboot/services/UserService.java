package it.sky.dp.samplespringboot.services;

import it.sky.dp.samplespringboot.models.User;



public interface UserService {

    User getUser(Integer id);
    void createUser(User user);

}
