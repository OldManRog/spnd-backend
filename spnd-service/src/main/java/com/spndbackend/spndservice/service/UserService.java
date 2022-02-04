package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.models.user.*;


public interface UserService {


    GetAllUsersResponse getallUsers();

    AddUserResponse addUser(User user);

    DeletedUserResponse deleteUserById(DeleteUserRequest request);

    GetSingleUserResponse findUserById(GetSingleUserRequest request);


}
