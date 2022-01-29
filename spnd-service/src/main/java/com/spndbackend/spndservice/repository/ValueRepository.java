package com.spndbackend.spndservice.repository;

import com.spndbackend.spndservice.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ValueRepository extends JpaRepository<Value,Integer> {


}

