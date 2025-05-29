package com.alejandro.msvc_processing_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// To specific the name of the table in mysql
// In mysql the name of this table is 'transaction' but in this project 
// the name of this class is 'Transaction'
@Entity
@Table(name = "transaction") 
public class Transaction {
    
    // Mapping of class attributes with table fields in mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long id;

    // to disallow numeric characters
    @Pattern(regexp = "^[^0-9]+$")
    @NotBlank // To obligate to this attribute not to empty or blank values.
    private String operation;
    
    // to allow only numeric characters and one character: .
    @NotBlank // To obligate to this attribute not to empty or blank values.
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$")
    private String amount;

    // to disallow numeric characters
    @Pattern(regexp = "^[^0-9]+$")
    @NotBlank // To obligate to this attribute not to empty or blank values.
    @Size(max = 30)
    private String client;

    @NotBlank // To obligate to this attribute not to empty or blank values.
    private String secret;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
