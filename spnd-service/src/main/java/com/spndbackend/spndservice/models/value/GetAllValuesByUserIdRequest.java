package com.spndbackend.spndservice.models.value;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllValuesByUserIdRequest {
    Integer userId;
}
