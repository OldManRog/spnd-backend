package com.spndbackend.spndservice.controller;

import com.spndbackend.spndservice.models.AddUserRequest;
import com.spndbackend.spndservice.models.AddUserResponse;
import com.spndbackend.spndservice.models.DeleteUserRequest;
import com.spndbackend.spndservice.models.DeletedUserResponse;
import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.models.request.mapper.UserMapper;
import com.spndbackend.spndservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spnd")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    List<User> getUsers(){
        List<User> users = userService.getallUsers();
        log.info("List of All Users :: ::" + users);
        return users;

    }

    @PostMapping("/add/user")
    AddUserResponse postUser(@RequestBody AddUserRequest user){
        AddUserResponse addUserResponse = userService.addUser(userMapper.toEntity(user));
        log.info("User Added :: :: " + addUserResponse.getData());
        return addUserResponse;

    }

    @DeleteMapping("/delete/user")
    DeletedUserResponse deleteUserById(@RequestBody DeleteUserRequest request){
        DeletedUserResponse deletedUserResponse = userService.deleteUserById(request);
        log.info(" DeletedUserResponse deletedUserResponse :: :: " + deletedUserResponse);
        log.info(" Deleted User :: :: " + deletedUserResponse.getUserDeleted());
        return deletedUserResponse;

    }


}
