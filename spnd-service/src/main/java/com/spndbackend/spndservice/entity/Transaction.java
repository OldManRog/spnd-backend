package com.spndbackend.spndservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "transaction_table") // This tells Hibernate to make a table out of this class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("transactionId")
    @Column(name = "transaction_id")
    private Integer transactionId;

    @JsonProperty("transactionAmount")
    @Column(name = "transaction_amount")
    private Integer transactionAmount;

    @JsonProperty("transactionDate")
    @Column(name = "transaction_date")
    private Date transactionDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false,targetEntity = Value.class)
    @JoinColumn(name = "value_Id", nullable = false)
    @JsonIgnoreProperties({"values", "value"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Value value;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false,targetEntity = Value.class)
//    @JoinColumn(name = "value_Id", nullable = false)
//    @JsonIgnoreProperties({"values", "value"})
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Value value;



}
