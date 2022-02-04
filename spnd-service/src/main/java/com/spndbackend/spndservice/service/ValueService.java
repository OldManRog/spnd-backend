package com.spndbackend.spndservice.service;

import com.spndbackend.spndservice.entity.Value;
import com.spndbackend.spndservice.models.value.AddValueResponse;
import com.spndbackend.spndservice.models.value.GetAllValuesByUserIdRequest;
import com.spndbackend.spndservice.models.value.GetAllValuesByUserIdResponse;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountRequest;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountResponse;
import com.spndbackend.spndservice.models.value.delete.DeleteSingleValueRequest;
import com.spndbackend.spndservice.models.value.delete.DeleteSingleValueResponse;

public interface ValueService {

     AddValueResponse addValue(Value value);

     GetAllValuesByUserIdResponse getAllValuesByUserId(GetAllValuesByUserIdRequest request);

     DeleteSingleValueResponse deleteValue(DeleteSingleValueRequest request);

     AddSavingAmountResponse addSavingAmount(AddSavingAmountRequest request) throws Exception;



}
