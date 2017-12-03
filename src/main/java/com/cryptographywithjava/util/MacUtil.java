package com.cryptographywithjava.util;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class MacUtil {

    private static final Log LOG = LogFactory.getLog(MacUtil.class);

    public final static String HMAC_MD5 = "HmacMD5";
    public final static String HMAC_SHA1= "HmacSHA1";
    public final static SecretKey HMAC_MD5_SECRET_KEY = getSecretKey(HMAC_MD5);
    public final static SecretKey HMAC_MD1_SECRET_KEY = getSecretKey(HMAC_SHA1);;

    private static SecretKey getSecretKey(String algorithm) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            LOG.error("Invalid algorith: exception occur:", e);
            System.exit(0);
        }
        return null;
    }

}
