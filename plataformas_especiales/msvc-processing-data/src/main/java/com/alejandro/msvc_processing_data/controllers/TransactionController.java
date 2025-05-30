package com.alejandro.msvc_processing_data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.msvc_processing_data.dto.TransactionResponseDto;
import com.alejandro.msvc_processing_data.models.Transaction;
import com.alejandro.msvc_processing_data.services.TransactionService;
import com.alejandro.msvc_processing_data.utils.UtilValidation;

import jakarta.validation.Valid;

@RestController // To create a api rest.
@RequestMapping("/api/transactions") // To create a base path.
public class TransactionController {

    // To Inject the service dependency
    @Autowired
    private TransactionService service;

    @Autowired
    private UtilValidation utilValidation;

    // -----------------------------
    // Methods for transaction entity
    // -----------------------------

    // To create an endpoint that allows invoking the method save.
    // The annotation called 'RequestBody' allows receiving data of a transaction
    @PostMapping()
    public ResponseEntity<?> saveTransaction(@Valid @RequestBody Transaction transaction, BindingResult result) {
        // To handle the obligations of object attributes
        if (result.hasFieldErrors()) {
            return utilValidation.validation(result);
        }

        // When a new transaction is created to respond return the object of transactionDto
        TransactionResponseDto response = service.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

