package com.app.demo.repository;

import com.app.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailId(String emailId);

    User findByEmailIdAndPassword(String emailId, String password);
}
