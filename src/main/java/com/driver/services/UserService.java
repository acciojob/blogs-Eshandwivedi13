package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User userEntityObj = new User(username, password);
        User user = userRepository3.save(userEntityObj);
        return user;
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        Optional<User> optUser = userRepository3.findById(id);
        User userObj = optUser.get();
        userObj.setPassword(password);
        User savedUser = userRepository3.save(userObj);
        return savedUser;//you can also return userObj, cuz that is also updated object
    }
}
