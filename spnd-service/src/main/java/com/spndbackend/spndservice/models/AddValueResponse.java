package com.spndbackend.spndservice.models;

import com.spndbackend.spndservice.entity.Value;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddValueResponse {
    boolean success;
    String systemMessage;
    Value data;

}
