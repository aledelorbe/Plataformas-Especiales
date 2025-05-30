package com.alejandro.save.data.msvc_save_data.dto;

// This class is used to send the response to the first API
public class TransactionResponseDto {
    
    private Long id;

    private String status;
    
    private String reference;
    
    private String operation;

    public TransactionResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
