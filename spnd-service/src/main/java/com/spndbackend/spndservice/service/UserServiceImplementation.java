package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.User;

import com.spndbackend.spndservice.models.user.*;
import com.spndbackend.spndservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public GetAllUsersResponse getallUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseLists = new ArrayList<>();
        users.forEach((user -> {
            UserResponse userResponse = new UserResponse();
            SingleUser singleUser = new SingleUser();
            BeanUtils.copyProperties(user,singleUser);
            userResponse.setUser(singleUser);
            userResponseLists.add(userResponse);
        }));
        GetAllUsersResponse getAllUsersResponse = new GetAllUsersResponse();
        getAllUsersResponse.setSuccess(true);
        getAllUsersResponse.setSystemMessage("List of Users Retrieved");
        getAllUsersResponse.setData(userResponseLists);
        return getAllUsersResponse;
    }

    @Override
    public AddUserResponse addUser(User user) {
        User newUser = userRepository.save(user);
        AddUserResponse addUserResponse = new AddUserResponse();
        addUserResponse.setData(newUser);
        addUserResponse.setSystemMessage("User is Added");
        addUserResponse.setSuccess(true);
        return addUserResponse;
    }

    @Override
    public DeletedUserResponse deleteUserById(DeleteUserRequest request) {
        DeletedUserResponse deletedUserResponse = new DeletedUserResponse();

        if (userRepository.findById(request.getId()).isPresent()) {
            Optional<User> user = userRepository.findById(request.getId());
            deletedUserResponse.setData(user.get());
            try {
                userRepository.deleteById(request.getId());
                deletedUserResponse.setSuccess(true);
                deletedUserResponse.setSystemMessage("User Deleted");
            } catch (Exception e) {
                throw e;
            }
        } else {
            deletedUserResponse.setData(null);
            deletedUserResponse.setSuccess(false);
        }

        return deletedUserResponse;
    }

    @Override
    public GetSingleUserResponse findUserById(GetSingleUserRequest request) {
        Optional<User> user = userRepository.findById(request.getId());
        GetSingleUserResponse getSingleUserResponse = new GetSingleUserResponse();
        SingleUser singleUser = new SingleUser();
        BeanUtils.copyProperties(user.get(),singleUser);
        getSingleUserResponse.setSuccess(true);
        getSingleUserResponse.setSystemMessage("User Foundd");
        getSingleUserResponse.setData(singleUser);
        return getSingleUserResponse;
    }

}
