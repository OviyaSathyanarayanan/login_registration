package com.app.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isUserValid(String email) {
        return email != null && !email.equals("");
    }

    public boolean isValidCredentials(String tempEmail, String tempPassword) {
        return ((tempEmail != null && !tempEmail.equals("")) && (tempPassword != null && !tempPassword.equals("")));
    }
}
