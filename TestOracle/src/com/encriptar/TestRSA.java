package com.encriptar;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;


public class TestRSA {

	private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
           * RSA maximum decrypted ciphertext size
     */
    private static final int MAX_DECRYPT_BLOCK = 2000;

    /**
           * Get the key pair
     *
           * @return key pair
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    /**
           * Get private key
     *
           * @param privateKey private key string
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
           * Get public key
     *
           * @param publicKey public key string
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    /**
           * RSA encryption
     *
           * @param data Data to be encrypted
           * @param publicKey public key
     * @return
     */
    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.getBytes().length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // Encrypt data segments
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data.getBytes(), offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        // Obtain encrypted content using base64 for encoding, and convert it into a string using UTF-8 as the standard
        // The encrypted string
        return new String(Base64.encodeBase64String(encryptedData));
    }

    /**
           * RSA decryption
     *
           * @param data Data to be decrypted
           * @param privateKey private key
     * @return
     */
    public static String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] dataBytes = Base64.decodeBase64(data);
        int inputLen = dataBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // Decrypt data segments
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        // Decrypted content
        return new String(decryptedData, "UTF-8");
    }

    /**
           * Signature
     *
           * @param data to be signed data
           * @param privateKey private key
           * @return signature
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(key);
        signature.update(data.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
           * Verification
     *
           * @param srcData original string
           * @param publicKey public key
           * @param sign signature
           * @return Is the verification passed
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(srcData.getBytes());
        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }

    public static void main(String[] args) {
        try {
            // Generate key pair
            KeyPair keyPair = getKeyPair();
            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
            System.out.println("Private Key:" + privateKey);
            System.out.println("Public Key:" + publicKey);
            // RSA encryption
            String data = "4003101111111111";
            String encryptData = encrypt(data, getPublicKey(publicKey));
//            String encryptData = encrypt(data, getPublicKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCWFJKskpFbNsq5qKBaVOSQIjFdlXiyx6BxinJtYv9k3VBPZWNWtABKX7KNwOpYGYZU+gS3cWop7KR91HJqaoH+W4c49/vZ8mtEAkTOkXEC17CFq7GcOx6loT1Mwgp1VPTkbogYCUK9bR1D0rk+QPrj9nGEM+c34ULvwlI6Jj0bBdq4r6dVr1oQyquFaPA4/vmLrU8as/cEhSy9RUiGSTyeu5kfLAwuxmgjQUiX5vFNWpmsRXv+i9MSD3yjjyLtmjQYsKPzkm8Yxcw3J8nPAF5PwC2RGNVUjgfQMWrer5ER6tn/1VwWPZvq6QrnKHjV3UzUk/zW9yQDiNOFKF5BjA8PAgMBAAECggEAVtGf5+UB4VpY+/3ohVkGv7qIBDMrl4CT+Bq3B0B1rcu5YbStOsL2SBAEIqyu5Dgf1ZiskdIyL/6NSZ1UcusaOCKKnxIVx4bNNpJ5a2YHkjVkEG+6Vz58BCS6aWT219lFsb+fSwhQa3RrsYh9UN4WRTmTgX7lCxZsunYXSzxDrRVaEC6SIEHByhWregk9yLpkrGJyZRZ5kkTGTZnmj1lRDWbYC1L1O+yLGpaii9HbXHJ16l5XCo9i+jelJDpDoxXpj5gQ04lm8+DbDShGDUvdGBVmNiPVsuolJrsXcJvksKkp0DwR+MIk/CddLX28zjzmkgpdUFH9V44+EFOUgoTEQQKBgQDX/C4vvxPzKc+HSMPIoyiG13VMjCMAuEa2cyVbEycUroMXfqPqjxbhsrZd30cMsrv1FzYsV/hVD130ZKROz6Oht4t3XfCi9pJqBPMy9tpko9aHk/aEWPwjLF1uQplgW3CnTN2uuWTgifYR7hoDO5eyIgNcZBJv93Ie7OWUEUy+GwKBgQCx4qOzO+9/PUEdG7cXJmTA/KpS/t4cifIg0Gqps09QWpYj1YFEXbcmBSO0Tn/5CPFipTyto52cTgiP/5wtNrGccaoPY7PgkksNLqvzjwvr7IDqWqDptIjs5imssHvR4JLCpwscBEfCCN4O0XC0uZeFGMOgNu+hj991kDNqXr/yHQKBgQCHOPyVqhTMbcXfViA1kmkCGwz2UtprTfP/sJGXtqMGIMg0QnZPmSxjO+dPWEX8Xj6tEM467wyr/IX/R69TJE63JdnsbuUEskkylUzKAKD011qt4WY6sBeT0efg61Npb3ZVWBuGk83jgpyL1z1z/rBXt1HRW1nrvck2MWz+yeH5NwKBgQCZrIrxZ4Dysk9TP0NAC5oVIvJd+vKVQxLbCFJtQovthiSY1nTzQ+baQKxks0BZO0GVj9xIwcWCZ+N7yz33zX1JAuUAoIigJKITxFMmeVi6Oznvu9WxsJZt2jT8jAab/N+sq7SsQoJffVug/4zXhFIC2K7/9RW1xF4u6SGR7kLyfQKBgF1jyoWd8hOv+MrJ/sBl5USpC6JDDsA5xLFlRiIQ658nLWyT48tcNEMb9+FTejd33QpV2jMn8QmpdpjW5F/0Jmu8sAIiSktg0Lz9Dt5yObVQwJ4yREKK8976rDxfMdN8W9EA5kdv6pSXzX7EPQmdlyglsJIx3g1a/2eoGPKVF8f7"));
            System.out.println("Encrypted content:" + encryptData);
            // RSA decryption
            String decryptData = decrypt(encryptData, getPrivateKey(privateKey));
            System.out.println("Decrypted content:" + decryptData);

            // RSA signature
            String sign = sign(data, getPrivateKey(privateKey));
            // RSA verification
            boolean result = verify(data, getPublicKey(publicKey), sign);
            System.out.print("Verification result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Encryption and decryption exception");
        }
    }
}