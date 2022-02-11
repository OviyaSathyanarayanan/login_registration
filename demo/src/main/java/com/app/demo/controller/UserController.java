package com.app.demo.controller;

import com.app.demo.model.User;
import com.app.demo.service.UserService;
import com.app.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) throws Exception {
//        System.out.println("Hit");
        User userObj = null;

        if(validationService.isUserValid(user.getEmailId())) {
//            System.out.println("Hit");
            if (service.fetchUserByEmailId(user.getEmailId()) != null) {
                throw new Exception("User with " + user.getEmailId() + " is already exists");
            } else {
                userObj = service.saveUser(user);
                return userObj;
            }
        } else {
            throw new Exception("Enter a valid email id");
        }
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmailId();
        String tempPassword = user.getPassword();
        System.out.println(tempEmail + " " + tempPassword);
        User userObj = null;

        if(validationService.isValidCredentials(tempEmail, tempPassword)) {
            userObj = service.fetchUserByEmailIdAndPassword(tempEmail, tempPassword);
            if(userObj != null) {
                return userObj;
            } else {
                throw new Exception("Invalid credentials");
            }
        } else {
            throw new Exception("Enter valid credentials");
        }
    }
}
