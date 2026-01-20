package com.xworkz.module.crypt;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

@Component
public class PasswordCipherUtil {

    private static final String SECRET_KEY = "MySecretKey12345";

    // Encrypt password
    public String encrypt(String password) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encrypted = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    // Decrypt password (optional, for login)
    public String decrypt(String encryptedPassword) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decoded = Base64.getDecoder().decode(encryptedPassword);
            return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }
}

