package com.spndbackend.spndservice.repository;

import com.spndbackend.spndservice.entity.User;
import com.spndbackend.spndservice.models.ValueResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();






}
