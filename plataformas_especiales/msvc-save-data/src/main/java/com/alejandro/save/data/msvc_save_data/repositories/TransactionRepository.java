package com.alejandro.save.data.msvc_save_data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.save.data.msvc_save_data.entities.Transaction2;

public interface TransactionRepository extends CrudRepository<Transaction2, Long> {
    
}

