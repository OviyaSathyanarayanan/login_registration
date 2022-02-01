package com.app.demo.service;

import com.app.demo.model.User;
import com.app.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User fetchUserByEmailId(String emailId) {
        return repository.findByEmailId(emailId);
    }

    public User fetchUserByEmailIdAndPassword(String emailId, String password) {
        return repository.findByEmailIdAndPassword(emailId, password);
    }

}
