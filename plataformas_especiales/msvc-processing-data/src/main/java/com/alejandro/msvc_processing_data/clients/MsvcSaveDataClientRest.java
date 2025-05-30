package com.alejandro.msvc_processing_data.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alejandro.msvc_processing_data.dto.TransactionResponseDto;
import com.alejandro.msvc_processing_data.models.Transaction;

@FeignClient(name = "msvc-save-data", url = "localhost:8086")
public interface MsvcSaveDataClientRest {

    @GetMapping("/api/transactions/get-all-transactions")
    public List<TransactionResponseDto> allTransactions();

    @GetMapping("/api/transactions/by-reference/{reference}")
    public TransactionResponseDto transactionByReference(@PathVariable String reference);

    @PutMapping("api/transactions/cancel-Transaction/{id}/{reference}/{status}")
    public TransactionResponseDto cancelTransaction(@PathVariable Long id, @PathVariable String reference, @PathVariable String status);
    
    @PostMapping("/api/transactions/save")
    public TransactionResponseDto saveTransaction(@RequestBody Transaction transaction);

}
