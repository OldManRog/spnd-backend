package com.spndbackend.spndservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spndbackend.spndservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserResponse {

    private boolean success;
    private String systemMessage;
    private User data;


}
