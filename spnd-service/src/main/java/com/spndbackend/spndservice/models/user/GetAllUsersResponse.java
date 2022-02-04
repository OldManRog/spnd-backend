package com.spndbackend.spndservice.models.user;

import com.spndbackend.spndservice.models.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    Boolean success;
    String systemMessage;
    List<UserResponse> data;
}
