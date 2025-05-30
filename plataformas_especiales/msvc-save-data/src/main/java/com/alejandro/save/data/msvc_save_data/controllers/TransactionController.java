package com.alejandro.save.data.msvc_save_data.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.save.data.msvc_save_data.dto.TransactionResponseDto;
import com.alejandro.save.data.msvc_save_data.entities.Transaction2;
import com.alejandro.save.data.msvc_save_data.services.TransactionService;


@RestController // To create a api rest.
@RequestMapping("/api/transactions") // To create a base path.
public class TransactionController {

    // To Inject the service dependency
    @Autowired
    private TransactionService service;

    // -----------------------------
    // Methods for transaction entity
    // -----------------------------

    // To create an endpoint that allows invoking the method save.
    // The annotation called 'RequestBody' allows receiving data of a transaction
    @PostMapping("/save")
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction2 transaction) {

        // When a new transaction is created to respond return the same transaction
        TransactionResponseDto response = service.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
