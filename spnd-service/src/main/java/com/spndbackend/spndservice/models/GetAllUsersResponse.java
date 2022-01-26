package com.spndbackend.spndservice.models;

import com.spndbackend.spndservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    Boolean success;
    String systemMessage;
    List<User> data;
}
