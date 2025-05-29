package com.alejandro.msvc_processing_data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.msvc_processing_data.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    
}
