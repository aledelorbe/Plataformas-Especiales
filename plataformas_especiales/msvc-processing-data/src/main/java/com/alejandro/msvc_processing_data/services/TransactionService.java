package com.alejandro.msvc_processing_data.services;

import com.alejandro.msvc_processing_data.dto.TransactionResponseDto;
import com.alejandro.msvc_processing_data.models.Transaction;

public interface TransactionService {
    
    // Declaration of methods to use in 'serviceImp' file

    // -----------------------------
    // Methods for address entity
    // -----------------------------

    TransactionResponseDto save(Transaction transaction);
}
