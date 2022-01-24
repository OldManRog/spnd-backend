package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.models.AddUserResponse;
import com.spndbackend.spndservice.models.DeleteUserRequest;
import com.spndbackend.spndservice.models.DeletedUserResponse;
import com.spndbackend.spndservice.entity.User;
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
    public List<User> getallUsers() {
        return userRepository.findAll();
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
            deletedUserResponse.setUserDeleted(user);
            try {
                userRepository.deleteById(request.getId());
                deletedUserResponse.setDeleted(true);
            } catch (Exception e) {
                throw e;
            }
        } else {
            deletedUserResponse.setUserDeleted(null);
            deletedUserResponse.setDeleted(false);
        }

        return deletedUserResponse;
    }
}
