package com.spndbackend.spndservice.models;

import com.spndbackend.spndservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedUserResponse implements Serializable {

    boolean isDeleted;
    Optional<User> UserDeleted;
}
