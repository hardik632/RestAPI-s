package com.assignment.RestAPI.Controller;

import com.assignment.RestAPI.Model.UserEntity;
import com.assignment.RestAPI.Respository.UserRepository;
import com.assignment.RestAPI.Service.UserService;
import com.mongodb.MongoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserService userService;
    UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }


    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserEntity> getUsersById(@PathVariable("id") String id) {
        if (userRepository.findById(id).isPresent()) {
            return new ResponseEntity<UserEntity>(userRepository.findById(id).get(), HttpStatus.OK);
        } else {
            System.out.println("user not found");
            return null;
        }

    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<String> createUser(@RequestBody UserEntity userEntity) {
        if (userRepository.findById(userEntity.getId()).isPresent()) {
            return new ResponseEntity<>("User with this id is already present! Try different id", HttpStatus.NOT_FOUND);
        } else {
            userRepository.save(userEntity);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/updateuser/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserEntity userEntity, @PathVariable(value = "id") String id) {
        if (userRepository.findById(id).isPresent()) {
            UserEntity userEntity1 = userRepository.findById(id).get();
            userEntity1.setName(userEntity.getName());
            userEntity1.setAge(userEntity.getAge());
            userRepository.save(userEntity1);
            return new ResponseEntity<String>("updated", HttpStatus.OK);
        } else
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/deleteuser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") String id) {

        if (userRepository.findById(id).isPresent()) {
            UserEntity userEntity = userRepository.findById(id).get();
            userRepository.delete(userEntity);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } else
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
