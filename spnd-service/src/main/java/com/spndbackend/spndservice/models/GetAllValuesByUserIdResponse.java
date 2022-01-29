package com.spndbackend.spndservice.models;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllValuesByUserIdResponse {

        Boolean success;
        String systemMessage;
        List<ValueResponse> data;

}
