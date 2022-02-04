package com.spndbackend.spndservice.models.value;

import com.spndbackend.spndservice.models.user.SingleValue;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValueResponse {

    SingleValue value;
}
