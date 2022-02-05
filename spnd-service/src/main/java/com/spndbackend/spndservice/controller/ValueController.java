package com.spndbackend.spndservice.controller;

import com.spndbackend.spndservice.entity.Transaction;
import com.spndbackend.spndservice.models.value.GetAllValuesByUserIdRequest;
import com.spndbackend.spndservice.models.value.GetAllValuesByUserIdResponse;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountRequest;
import com.spndbackend.spndservice.models.value.addsavingamount.AddSavingAmountResponse;
import com.spndbackend.spndservice.models.value.delete.DeleteSingleValueRequest;
import com.spndbackend.spndservice.models.value.delete.DeleteSingleValueResponse;
import com.spndbackend.spndservice.service.transaction.TransactionService;
import com.spndbackend.spndservice.service.value.ValueService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/spnd")
@Log4j2
@CrossOrigin
public class ValueController {

    @Autowired
    ValueService valueService;

    @Autowired
    TransactionService transactionService;



    @PostMapping("/get/users/value")
    GetAllValuesByUserIdResponse getAllValuesByUserIdResponse(@RequestBody GetAllValuesByUserIdRequest request){
        return valueService.getAllValuesByUserId(request);
    }

    @DeleteMapping("/delete/user/value")
        DeleteSingleValueResponse deleteValue(@RequestBody DeleteSingleValueRequest request){
        return valueService.deleteValue(request);
    }

    @PutMapping("/put/value/amount")
    AddSavingAmountResponse addSavingAmount(@RequestBody AddSavingAmountRequest request) throws Exception {
        return transactionService.addSavingAmount(request);
    }



}
