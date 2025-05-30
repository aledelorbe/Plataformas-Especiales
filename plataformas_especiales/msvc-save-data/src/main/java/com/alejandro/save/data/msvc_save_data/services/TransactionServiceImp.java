package com.alejandro.save.data.msvc_save_data.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.save.data.msvc_save_data.dto.TransactionResponseDto;
import com.alejandro.save.data.msvc_save_data.entities.Transaction2;
import com.alejandro.save.data.msvc_save_data.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImp implements TransactionService {

    // To inject the repository dependency.
    @Autowired
    private TransactionRepository repository;

    // -----------------------------
    // Methods for transaction entity
    // -----------------------------

    // To save a new transaction in the db
    @Override
    @Transactional
    public TransactionResponseDto save(Transaction2 transaction) {

        Transaction2 newTransaction = repository.save(transaction);

        TransactionResponseDto response = new TransactionResponseDto();
        response.setId(newTransaction.getId());  
        response.setStatus("Aprobada");  
        response.setReference(this.generateReference());  
        response.setOperation(newTransaction.getOperation());  

        return response;
    }

    private String generateReference() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        // Six numbers
        for (int i = 0; i < 6; i++) {
            sb.append(rand.nextInt(10));
        }

        return sb.toString();
    }
}