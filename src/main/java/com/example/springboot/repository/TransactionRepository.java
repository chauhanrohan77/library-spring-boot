package com.example.springboot.repository;

import com.example.springboot.model.TransactionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository <TransactionEntity,Integer> {

    @Query(nativeQuery = true,value =  "SELECT * FROM transactions t WHERE t.person_id = :personId ORDER BY t.issue_date DESC LIMIT 1" )
    public TransactionEntity findByName(Integer personId);

}
