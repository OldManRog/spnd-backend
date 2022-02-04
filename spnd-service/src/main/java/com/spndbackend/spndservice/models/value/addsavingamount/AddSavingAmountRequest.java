package com.spndbackend.spndservice.models.value.addsavingamount;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddSavingAmountRequest {

    Integer transactionAmount;
    Integer valueId;
    Date transactionDate;

}
