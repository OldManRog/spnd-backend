package com.spndbackend.spndservice.controller;

import com.spndbackend.spndservice.models.GetAllValuesByUserIdRequest;
import com.spndbackend.spndservice.models.GetAllValuesByUserIdResponse;
import com.spndbackend.spndservice.service.ValueService;
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

    @PostMapping("/get/users/value")
    GetAllValuesByUserIdResponse getAllValuesByUserIdResponse(@RequestBody GetAllValuesByUserIdRequest request){
        return valueService.getAllValuesByUserId(request);
    }


}
