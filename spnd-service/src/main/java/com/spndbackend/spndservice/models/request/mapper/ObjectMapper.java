package com.spndbackend.spndservice.models.request.mapper;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.AddUserRequest;
import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.models.AddValueRequest;
import com.spndbackend.spndservice.models.GetSingleUserRequest;
import com.spndbackend.spndservice.repository.UserRepository;
import com.spndbackend.spndservice.service.UserService;
import com.spndbackend.spndservice.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.html.Option;
import java.util.Optional;

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
        Value entity = new Value();
        entity.setBudgetFrequency(dto.getBudgetFrequency());
        entity.setBudgetedAmount(dto.getBudgetedAmount());
        entity.setFullyValued(dto.isFullyValued());
        entity.setLastUpdateAmount(dto.getLastUpdateAmount());
        entity.setValueAmount(dto.getValueAmount());
        entity.setValueByDate(dto.getValueByDate());
        entity.setUser(user);
        return entity;
    }

}
