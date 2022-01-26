package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.AddValueResponse;
import com.spndbackend.spndservice.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class valueServiceImplementation implements ValueService {

    @Autowired
    ValueRepository valueRepository;

    @Override
    public AddValueResponse addValue(Value value) {
        Value addedValue = valueRepository.save(value);
        AddValueResponse addValueResponse = new AddValueResponse();
        addValueResponse.setSuccess(true);
        addValueResponse.setSystemMessage("Value is Added Succesfully");
        addValueResponse.setData(addedValue);
        return addValueResponse;

    }


}
