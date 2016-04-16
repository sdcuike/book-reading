package com.doctor.ch08;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Asymmetric encryption techniques
 * 
 * @author sdcuike
 *
 *         Created on 2016年4月16日 下午2:50:41
 */
public class AsymmetricEncryptionTechniques {
    static final String rsa_algorithm = "RSA";

    public static void main(String[] args) throws Throwable {
        String message = "hello doctor?";
        Pair<String, String> base64PrivateAndPublicKey = generateBase64PrivateAndPublicKey();
        System.out.println("Private key:" + base64PrivateAndPublicKey.getLeft());
        System.out.println("Public key:" + base64PrivateAndPublicKey.getRight());
        System.out.println("==========================");
        String encryptedBase64String = encryptToBase64String(base64PrivateAndPublicKey, message);
        System.out.println(encryptedBase64String);
        String decrypt = decrypt(base64PrivateAndPublicKey, encryptedBase64String);
        System.out.println(decrypt);
    }

    static String encryptToBase64String(Pair<String, String> base64PrivateAndPublicKey, String message) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(rsa_algorithm);
        PublicKey publicKey = getPublicKey(base64PrivateAndPublicKey);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] doFinal = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(doFinal);
    }

    static String decrypt(Pair<String, String> base64PrivateAndPublicKey, String encryptedBase64String) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decode = Base64.getDecoder().decode(encryptedBase64String);
        Cipher cipher = Cipher.getInstance(rsa_algorithm);
        PrivateKey privateKey = getPrivateKey(base64PrivateAndPublicKey);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] doFinal = cipher.doFinal(decode);
        return new String(doFinal, StandardCharsets.UTF_8);
    }

    static Pair<String, String> generateBase64PrivateAndPublicKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(rsa_algorithm);
        keyPairGenerator.initialize(1024);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(pkcs8EncodedKeySpec.getEncoded());

        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
        String publicKey = Base64.getEncoder().encodeToString(x509EncodedKeySpec.getEncoded());

        return new ImmutablePair<String, String>(privateKey, publicKey);
    }

    static PrivateKey getPrivateKey(Pair<String, String> base64PrivateAndPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String base64PrivateKey = base64PrivateAndPublicKey.getLeft();
        byte[] decode = Base64.getDecoder().decode(base64PrivateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance(rsa_algorithm);
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    static PublicKey getPublicKey(Pair<String, String> base64PrivateAndPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String base64PublicKey = base64PrivateAndPublicKey.getRight();
        byte[] decode = Base64.getDecoder().decode(base64PublicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance(rsa_algorithm);
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

}
