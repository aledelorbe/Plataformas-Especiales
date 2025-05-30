package com.alejandro.save.data.msvc_save_data.services;


import java.util.List;
import java.util.Optional;

import com.alejandro.save.data.msvc_save_data.dto.TransactionResponseDto;
import com.alejandro.save.data.msvc_save_data.entities.Transaction2;

public interface TransactionService {
    
    // Declaration of methods to use in 'serviceImp' file

    // -----------------------------
    // Methods for address entity
    // -----------------------------

    List<Transaction2> findAll();

    Optional<Transaction2> findByReference(String reference);
    
    Optional<Transaction2> cancelTransaction(Long id, String reference, String status);

    TransactionResponseDto save(Transaction2 transaction);

}
