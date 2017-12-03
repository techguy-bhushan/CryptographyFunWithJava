package com.cryptographywithjava.service;

import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface MessageAuthenticationCodeService {
    String mac(String text, SecretKey secretKey) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException;
    boolean isValidText(String text, String originalHash, SecretKey secretKey) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException;
    }
