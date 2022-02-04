package com.spndbackend.spndservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity(name = "value_table") // This tells Hibernate to make a table out of this class
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Value {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("valueId")
    @Column(name = "value_Id")
    Integer valueId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false,targetEntity = User.class)
    @JoinColumn(name = "user_Id", nullable = false)
    @JsonIgnoreProperties({"values", "value"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @JsonProperty("valueAmount")
    @Column(name = "value_Amount")
    int valueAmount;

    @JsonProperty("valueName")
    @Column(name = "value_name")
    String valueName;

    @JsonProperty("budgetedAmount")
    @Column(name = "budgeted_Amount")
    int budgetedAmount;

    @JsonProperty("lastUpdateAmount")
    @Column(name = "last_Update_Amount")
    int lastUpdateAmount;

    @JsonProperty("budgetFrequency")
    @Column(name = "budget_Frequency")
    int budgetFrequency;

    @JsonProperty("valueByDate")
    @Column(name = "value_By_Date")
    Date valueByDate;

    @JsonProperty("isFullyValued")
    @Column(name = "is_Fully_Valued")
    boolean isFullyValued;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "value",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("value")
    private List<Transaction> transactions;


}
