package com.spndbackend.spndservice.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllValuesByUserIdRequest {
    Integer userId;
}
