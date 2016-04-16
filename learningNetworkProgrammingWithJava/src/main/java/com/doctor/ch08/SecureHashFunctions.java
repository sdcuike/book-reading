package com.doctor.ch08;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * Secure hash functions
 * 
 * @author sdcuike
 *
 *         Created on 2016年4月16日 下午8:22:01
 */
public class SecureHashFunctions {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "This is a simple text message";
        String hashValue = getHashValue(message);
        System.out.println(hashValue);
        // 83c660972991049c25e6cad7a5600fc4d7c062c097b9a75c1c4f13238375c26c
    }

    static final String hash_algorithm = "SHA-256";

    static String getHashValue(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(hash_algorithm);
        byte[] b = digest.digest(message.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(b);
    }
}
