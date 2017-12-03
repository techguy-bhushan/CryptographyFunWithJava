package com.cryptographywithjava.service;

import java.security.NoSuchAlgorithmException;

public interface MessageDigestService {
    String digest(String text, String algorithm) throws NoSuchAlgorithmException;
}
