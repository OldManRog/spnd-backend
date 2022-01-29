package com.spndbackend.spndservice.models;

import com.spndbackend.spndservice.entity.Value;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValueResponse {

    SingleValue value;
}
