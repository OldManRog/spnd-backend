package com.spndbackend.spndservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "user_table") // This tells Hibernate to make a table out of this class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("userId")
    @Column(name = "user_Id")
    private Integer userId;
    @JsonProperty("name")
    @Column(name = "name_Id")
    private String name;
    @JsonProperty("email")
    @Column(name = "email_Id")
    private String email;
    @JsonProperty("homeAddress")
    @Column(name = "home_address")
    private String homeAddress;
    @JsonProperty("phoneNumber")
    @Column(name = "phone_number")
    private String phoneNumber;
    @JsonProperty("lastLoginDate")
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Value> values;

}


