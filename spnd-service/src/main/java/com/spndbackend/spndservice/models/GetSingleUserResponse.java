package com.spndbackend.spndservice.models;

import com.spndbackend.spndservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSingleUserResponse {
    private boolean success;
    private String systemMessage;
    private Optional<User> data;
}
