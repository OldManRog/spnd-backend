package com.spndbackend.spndservice.models.value;

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
