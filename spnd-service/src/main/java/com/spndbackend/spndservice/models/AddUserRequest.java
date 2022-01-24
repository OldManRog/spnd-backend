package com.spndbackend.spndservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("homeAddress")
    private String homeAddress;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("lastLoginDate")
    private Date lastLoginDate;
}
