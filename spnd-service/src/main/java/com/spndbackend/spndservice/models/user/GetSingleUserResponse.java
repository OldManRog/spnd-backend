package com.spndbackend.spndservice.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSingleUserResponse {
    private boolean success;
    private String systemMessage;
    private SingleUser data;
}
