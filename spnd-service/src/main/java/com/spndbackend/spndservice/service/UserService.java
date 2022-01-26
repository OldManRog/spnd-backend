package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.models.*;
import com.spndbackend.spndservice.entity.User;

import java.util.List;


public interface UserService {


    GetAllUsersResponse getallUsers();

    AddUserResponse addUser(User user);

    DeletedUserResponse deleteUserById(DeleteUserRequest request);

    GetSingleUserResponse findUserById(GetSingleUserRequest request);

}
