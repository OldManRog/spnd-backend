package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.*;

import com.spndbackend.spndservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public GetAllUsersResponse getallUsers() {
         List<User> users = userRepository.findAll();
         GetAllUsersResponse getAllUsersResponse = new GetAllUsersResponse();
         getAllUsersResponse.setSuccess(true);
         getAllUsersResponse.setSystemMessage("List of Users Retrieved");
         getAllUsersResponse.setData(users);
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
            deletedUserResponse.setData(user);
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
      getSingleUserResponse.setSuccess(true);
      getSingleUserResponse.setSystemMessage("User Foundd");
      getSingleUserResponse.setData(user);
      return getSingleUserResponse;
    }

}
