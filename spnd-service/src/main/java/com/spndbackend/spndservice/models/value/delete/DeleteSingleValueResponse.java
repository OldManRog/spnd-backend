package com.spndbackend.spndservice.models.value.delete;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteSingleValueResponse {
    Boolean success;
    String systemMessage;

}
