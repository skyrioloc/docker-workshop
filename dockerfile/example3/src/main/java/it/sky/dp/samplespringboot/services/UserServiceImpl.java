package it.sky.dp.samplespringboot.services;

import it.sky.dp.samplespringboot.models.User;
import it.sky.dp.samplespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id);
    }
}
