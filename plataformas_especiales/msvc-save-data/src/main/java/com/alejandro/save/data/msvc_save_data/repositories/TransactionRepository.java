package com.alejandro.save.data.msvc_save_data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alejandro.save.data.msvc_save_data.entities.Transaction2;

public interface TransactionRepository extends CrudRepository<Transaction2, Long> {
 
    // ---------------------
    // Custom queries ------
    // ---------------------

    // To get a specific transaction based on its reference value
    @Query("SELECT t FROM Transaction2 t WHERE t.reference = ?1")
    Transaction2 getTransactionByReference(String reference);


}

