package com.spndbackend.spndservice.models.value.addsavingamount;

import com.spndbackend.spndservice.models.user.SingleValue;
import com.spndbackend.spndservice.models.user.UserResponse;
import com.spndbackend.spndservice.models.value.ValueResponse;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddSavingAmountResponse {

    Boolean success;
    String systemMessage;
    SingleValue data;
}
