package com.spndbackend.spndservice.controller;

import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.*;
import com.spndbackend.spndservice.models.request.mapper.ObjectMapper;
import com.spndbackend.spndservice.repository.UserRepository;
import com.spndbackend.spndservice.repository.ValueRepository;
import com.spndbackend.spndservice.service.UserService;
import com.spndbackend.spndservice.service.ValueService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/spnd")
@Log4j2
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ValueService valueService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ObjectMapper userMapper;

    /**
     * API to get all users
     *
     * @return
     */
    @GetMapping("/users")
    GetAllUsersResponse getUsers() {
       GetAllUsersResponse users = userService.getallUsers();
        log.info("List of All Users :: ::" + users);
        return users;
    }

    /**
     * API to add a user
     *
     * @param user
     * @return
     */
    @PostMapping("/add/user")
    AddUserResponse postUser(@RequestBody AddUserRequest user) {
        ObjectMapper objectMapper = new ObjectMapper();
        AddUserResponse addUserResponse = userService.addUser(objectMapper.mapToUserEntity(user));
        log.info("User Added :: :: " + addUserResponse.getData());
        return addUserResponse;

    }

    /**
     * API to delete a single user
     *
     * @param request
     * @return
     */
    @DeleteMapping("/delete/user")
    DeletedUserResponse deleteUserById(@RequestBody DeleteUserRequest request) {
        DeletedUserResponse deletedUserResponse = userService.deleteUserById(request);
        log.info(" DeletedUserResponse deletedUserResponse :: :: " + deletedUserResponse);
        log.info(" Deleted User :: :: " + deletedUserResponse.getData());
        return deletedUserResponse;
    }

    /**
     * API to get a single user
     *
     * @param request
     * @return
     */
    @PostMapping("/get/user")
    GetSingleUserResponse findUserById(@RequestBody GetSingleUserRequest request) {
        GetSingleUserResponse getSingleUserResponse = userService.findUserById(request);
        log.info(" GetSingleUserResponse getSingleUserResponse:: :: " + getSingleUserResponse);
        return getSingleUserResponse;
    }

    @PostMapping("/add/user/value")
    AddValueResponse addValueToUser(@RequestBody AddValueRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
     return userRepository.findById(request.getUserId()).map(userFound -> {
           Value value = objectMapper.mapToValueEntity(request,userFound);
          return valueService.addValue(value);
        }).orElseThrow(RuntimeException::new);
    }


}
