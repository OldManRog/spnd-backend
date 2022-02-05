package com.spndbackend.spndservice.models.value.addsavingamount;

import com.spndbackend.spndservice.entity.Transaction;
import com.spndbackend.spndservice.entity.Value;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddSavingAmountRequest {

    Integer transactionAmount;
    Date transactionDate;
    Integer valueId;
    Value value;

}
