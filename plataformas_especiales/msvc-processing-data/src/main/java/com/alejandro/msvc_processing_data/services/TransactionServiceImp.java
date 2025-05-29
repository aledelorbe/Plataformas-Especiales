package com.alejandro.msvc_processing_data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandro.msvc_processing_data.entity.Transaction;
import com.alejandro.msvc_processing_data.repositories.TransactionRepository;


@Service
public class TransactionServiceImp implements TransactionService {

    // To inject the repository dependency.
    @Autowired
    private TransactionRepository repository;

    // -----------------------------
    // Methods for client entity
    // -----------------------------

    // To list all of transactions (records) in the table 'transactions'
    @Override
    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
        return (List<Transaction>) repository.findAll(); // cast because the method findAll returns a iterable.
    }

    // To save a new client in the db
    // This method is a 'join point'
    @Override
    @Transactional
    public Transaction save(Transaction client) {
        return repository.save(client);
    }

}
