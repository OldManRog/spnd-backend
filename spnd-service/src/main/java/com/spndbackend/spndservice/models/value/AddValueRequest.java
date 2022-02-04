package com.spndbackend.spndservice.models.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spndbackend.spndservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddValueRequest {

    int budgetFrequency;
    int budgetedAmount;
    boolean isFullyValued;
    int lastUpdateAmount;
    String valueName;
    int valueAmount;
    Date valueByDate;
    int userId;
    User user;
}
