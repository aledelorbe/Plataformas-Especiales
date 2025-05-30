package com.alejandro.msvc_processing_data.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alejandro.msvc_processing_data.dto.TransactionResponseDto;
import com.alejandro.msvc_processing_data.models.Transaction;

@FeignClient(name = "msvc-save-data", url = "localhost:8086")
public interface MsvcSaveDataClientRest {
    
    @PostMapping("/api/transactions/save")
    public TransactionResponseDto saveTransaction(@RequestBody Transaction transaction);

}
