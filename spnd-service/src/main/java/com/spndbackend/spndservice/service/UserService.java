package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.models.AddUserResponse;
import com.spndbackend.spndservice.models.DeleteUserRequest;
import com.spndbackend.spndservice.models.DeletedUserResponse;
import com.spndbackend.spndservice.entity.User;

import java.util.List;


public interface UserService {


    List<User> getallUsers();

    AddUserResponse addUser(User user);

    DeletedUserResponse deleteUserById(DeleteUserRequest request);

}
