package com.spndbackend.spndservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spndbackend.spndservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleValue {

    @JsonProperty("valueId")
    @Column(name = "value_Id")
    Integer valueId;

    @JsonProperty("valueAmount")
    int valueAmount;

    @JsonProperty("valueName")
    String valueName;

    @JsonProperty("budgetedAmount")
    int budgetedAmount;

    @JsonProperty("lastUpdateAmount")
    int lastUpdateAmount;

    @JsonProperty("budgetFrequency")
    int budgetFrequency;

    @JsonProperty("valueByDate")
    Date valueByDate;

    @JsonProperty("isFullyValued")
    boolean isFullyValued;
}

