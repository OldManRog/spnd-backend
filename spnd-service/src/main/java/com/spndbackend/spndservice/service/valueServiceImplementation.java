package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.*;
import com.spndbackend.spndservice.repository.UserRepository;
import com.spndbackend.spndservice.repository.ValueRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class valueServiceImplementation implements ValueService {

    @Autowired
    ValueRepository valueRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AddValueResponse addValue(Value value) {
        Value addedValue = valueRepository.save(value);
        AddValueResponse addValueResponse = new AddValueResponse();
        addValueResponse.setSuccess(true);
        addValueResponse.setSystemMessage("Value is Added Succesfully");
        addValueResponse.setData(addedValue);
        return addValueResponse;

    }

    @Override
    public GetAllValuesByUserIdResponse getAllValuesByUserId(GetAllValuesByUserIdRequest request) {
        GetAllValuesByUserIdResponse getAllValuesByUserIdResponse = new GetAllValuesByUserIdResponse();
        List<ValueResponse> valueResponseList = new ArrayList<>();
       return userRepository.findById(request.getUserId()).map((user) -> {
            log.info("getAllValuesByUserId() value :: :: " + user);
            user.getValues().forEach((value -> {
                ValueResponse valueResponse = new ValueResponse();
                SingleValue singleValue = new SingleValue();
                BeanUtils.copyProperties(value,singleValue);
                valueResponse.setValue(singleValue);
                valueResponseList.add(valueResponse);
                log.info("getAllValuesByUserId()  valueResponse:: :: " + value);
            }));
            log.info("getAllValuesByUserId() valueResponseList :: :: " + valueResponseList);
            getAllValuesByUserIdResponse.setData(valueResponseList);
            getAllValuesByUserIdResponse.setSuccess(true);
            getAllValuesByUserIdResponse.setSystemMessage("Values Successfully retrieved");
            return getAllValuesByUserIdResponse;
        }).orElseThrow(RuntimeException::new);
    }


}
