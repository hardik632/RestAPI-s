package com.assignment.RestAPI.Service;

import com.assignment.RestAPI.Model.UserEntity;
import com.assignment.RestAPI.Respository.UserRepository;
import com.mongodb.MongoException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
