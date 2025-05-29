package com.alejandro.msvc_processing_data.services;

import java.util.List;

import com.alejandro.msvc_processing_data.entity.Transaction;

public interface TransactionService {
    
    // Declaration of methods to use in 'serviceImp' file

    // -----------------------------
    // Methods for address entity
    // -----------------------------

    List<Transaction> findAll();

    Transaction save(Transaction transaction);
}
