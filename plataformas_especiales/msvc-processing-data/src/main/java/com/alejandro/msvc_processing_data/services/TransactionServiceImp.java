package com.alejandro.msvc_processing_data.services;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandro.msvc_processing_data.clients.MsvcSaveDataClientRest;
import com.alejandro.msvc_processing_data.dto.TransactionResponseDto;
import com.alejandro.msvc_processing_data.models.Transaction;


@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private MsvcSaveDataClientRest client; 

    // -----------------------------
    // Methods for transaction entity
    // -----------------------------

    // To save a new transaction in the db
    @Override
    @Transactional
    public TransactionResponseDto save(Transaction transaction) {

        // try {
        //     transaction.setSecret(this.decrypt(transaction.getSecret()));
        // } catch (Exception e) {
        //     throw new RuntimeException("Error when decript the secret", e);
        // }

        return client.saveTransaction(transaction);
    }

    private String decrypt(String encryptedBase64) throws Exception {

        String keyBase64 = "TU_CLAVE_BASE64";
        String ivBase64 = "TU_IV_BASE64";

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);
        byte[] keyBytes = Base64.getDecoder().decode(keyBase64);
        byte[] ivBytes = Base64.getDecoder().decode(ivBase64);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decrypted = cipher.doFinal(encryptedBytes);

        return new String(decrypted);
    }
}
