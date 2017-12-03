package com.cryptographywithjava.service;

import com.cryptographywithjava.util.CommonUtil;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* Message digests are secure one-way hash functions that take arbitrary-sized data and output a fixed-length hash value.
They are used to produce unique and reliable identifiers of data and are sometimes called the "digital fingerprints" of data.
Different algorithms can be used to compute the hash value*/
@Service
public class MessageDigestServiceImpl implements MessageDigestService {
    private static final Log LOG = LogFactory.getLog(MessageDigestServiceImpl.class);

    public String digest(String text, String algorithm) throws NoSuchAlgorithmException {
        // Creates the message digest.(The MessageDigest class manipulates message digests. )
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // Calculates the message digest with a string.
        messageDigest.update( text.getBytes());
        // Reads the message digest.
        // return new String( messageDigest.digest());
        byte[] bytes = messageDigest.digest();
        //convert the byte to hex format method 1
        return CommonUtil.convertByteToHexFormat(bytes);
    }

}