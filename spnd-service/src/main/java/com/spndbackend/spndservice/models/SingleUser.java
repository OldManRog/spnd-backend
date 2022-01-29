package com.spndbackend.spndservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spndbackend.spndservice.entity.Value;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleUser {

    @JsonProperty("userId")
    @Column(name = "user_Id")
    private Integer userId;
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
