package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.AddValueResponse;

public interface ValueService {

    AddValueResponse addValue(Value value);

}
