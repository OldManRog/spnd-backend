package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.AddValueResponse;
import com.spndbackend.spndservice.models.GetAllValuesByUserIdRequest;
import com.spndbackend.spndservice.models.GetAllValuesByUserIdResponse;
import com.spndbackend.spndservice.models.ValueResponse;

public interface ValueService {

    AddValueResponse addValue(Value value);

    GetAllValuesByUserIdResponse getAllValuesByUserId(GetAllValuesByUserIdRequest request);


}
