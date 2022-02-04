package com.spndbackend.spndservice.models.request.mapper;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.user.AddUserRequest;
import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.models.value.AddValueRequest;
import com.spndbackend.spndservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {

    @Autowired
    UserRepository userRepository;

    public User mapToUserEntity(AddUserRequest dto) {
        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setHomeAddress(dto.getHomeAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setLastLoginDate(dto.getLastLoginDate());
        return entity;
    }

    public Value mapToValueEntity(AddValueRequest dto, User user) {
        Value value = new Value();
        value.setBudgetFrequency(dto.getBudgetFrequency());
        value.setBudgetedAmount(dto.getBudgetedAmount());
        value.setFullyValued(dto.isFullyValued());
        value.setLastUpdateAmount(dto.getLastUpdateAmount());
        value.setValueName(dto.getValueName());
        value.setValueAmount(dto.getValueAmount());
        value.setValueByDate(dto.getValueByDate());
        value.setUser(user);
        return value;
    }

}
