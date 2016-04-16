package com.doctor.ch08;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Symmetric encryption techniques
 * 
 * @author sdcuike
 * 
 *         Created on 2016年4月16日 上午11:18:29
 */
public class SymmetricEncryptionTechniques {

    public static void main(String[] args) throws Throwable {
        String base64Key = generateBase64Key(aes_algorithm);
        System.out.println(base64Key);
        String plainText = "hello doctor ?";
        String encryptToBase64String = encryptToBase64String(plainText, base64Key);
        System.out.println(encryptToBase64String);
        System.out.println(decrpt(encryptToBase64String, base64Key));
    }

    static final String aes_algorithm = "AES";

    static String encryptToBase64String(String plainText, String base64Key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = getKey(base64Key);
        Cipher cipher = Cipher.getInstance(aes_algorithm);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] doFinal = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(doFinal);
    }

    static String decrpt(String encryptedBase64String, String base64Key) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
        SecretKey secretKey = getKey(base64Key);
        Cipher cipher = Cipher.getInstance(aes_algorithm);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decode = Base64.getDecoder().decode(encryptedBase64String);
        byte[] doFinal = cipher.doFinal(decode);
        return new String(doFinal, StandardCharsets.UTF_8);
    }

    static String generateBase64Key(String encryptionAlgorithm) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(encryptionAlgorithm);
        SecretKey secretKey = generator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(encoded);
    }

    static SecretKey getKey(String base64Key) throws NoSuchAlgorithmException {
        return new SecretKeySpec(Base64.getDecoder().decode(base64Key), aes_algorithm);
    }
}
