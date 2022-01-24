package com.spndbackend.spndservice.models.request.mapper;

import com.spndbackend.spndservice.models.AddUserRequest;
import com.spndbackend.spndservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User toEntity(AddUserRequest dto) {
        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setHomeAddress(dto.getHomeAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setLastLoginDate(dto.getLastLoginDate());
        return entity;
    }

}
