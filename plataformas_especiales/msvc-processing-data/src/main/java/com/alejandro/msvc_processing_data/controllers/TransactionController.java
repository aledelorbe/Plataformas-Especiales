package com.alejandro.msvc_processing_data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.msvc_processing_data.entity.Transaction;
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
    // Methods for client entity
    // -----------------------------

    // To create an endpoint that allows invoking the method findAll.
    @GetMapping()
    public List<Transaction> transactions() {
        return service.findAll();
    }

    // To create an endpoint that allows invoking the method save.
    // The annotation called 'RequestBody' allows receiving data of a client
    @PostMapping()
    public ResponseEntity<?> saveTransaction(@Valid @RequestBody Transaction client, BindingResult result) {
        // To handle the obligations of object attributes
        if (result.hasFieldErrors()) {
            return utilValidation.validation(result);
        }

        // When a new client is created to respond return the same client
        Transaction newTransaction = service.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }

}

