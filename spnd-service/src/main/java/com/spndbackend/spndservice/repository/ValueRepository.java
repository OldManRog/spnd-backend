package com.spndbackend.spndservice.repository;

import com.spndbackend.spndservice.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueRepository extends JpaRepository<Value,Integer> {


}

