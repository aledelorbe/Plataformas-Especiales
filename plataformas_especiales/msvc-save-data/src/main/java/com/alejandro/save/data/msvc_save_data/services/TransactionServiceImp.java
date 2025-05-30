package com.alejandro.save.data.msvc_save_data.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.save.data.msvc_save_data.dto.TransactionResponseDto;
import com.alejandro.save.data.msvc_save_data.entities.Transaction2;
import com.alejandro.save.data.msvc_save_data.repositories.TransactionRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImp implements TransactionService {

    // To inject the repository dependency.
    @Autowired
    private TransactionRepository repository;

    // -----------------------------
    // Methods for transaction entity
    // -----------------------------

    // To list all of transactions (records) in the table 'transactions'
    @Override
    @Transactional(readOnly = true)
    public List<Transaction2> findAll() {
        return (List<Transaction2>) repository.findAll(); // cast because the method findAll returns a iterable.
    }

    // To get a specific transaction based on its reference
    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction2> findByReference(String reference) {
        return Optional.ofNullable(repository.getTransactionByReference(reference));
    }

    // To cancel the transaction
    @Override
    @Transactional
    public Optional<Transaction2> cancelTransaction(Long id, String reference, String status) {

        // Find a specific transaction
        Optional<Transaction2> optionalTransaction = repository.findById(id);

        // If the transaction is present then...
        if (optionalTransaction.isPresent()) {
            // update that record and return an optional value
            Transaction2 transactionDb = optionalTransaction.get();

            transactionDb.setStatus(status);

            return Optional.of(repository.save(transactionDb));
        }

        return optionalTransaction;
    }

    // To save a new transaction in the db
    @Override
    @Transactional
    public TransactionResponseDto save(Transaction2 transaction) {

        transaction.setStatus("Aprobada");  
        transaction.setReference(this.generateReference());  

        Transaction2 newTransaction = repository.save(transaction);

        TransactionResponseDto response = new TransactionResponseDto();
        response.setId(newTransaction.getId());  
        response.setStatus(newTransaction.getStatus());  
        response.setReference(newTransaction.getReference());  
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