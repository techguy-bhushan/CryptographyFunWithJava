package com.cryptographywithjava.util;

import java.util.Arrays;
import java.util.List;

public class MessageDigestUtil {
    /*MD2 and MD5 , which are 128-bit algorithms*/
    public final static String MD2 = "MD2";
    public final static String MD5 = "MD5";

    /*SHA-1, which is a 160-bit algorithm*/
    public final static String SHA_1 = "SHA-1";

    /*SHA-224,SHA-256,SHA-383, and SHA-512, which offer longer fingerprint sizes of 224, 256, 383, and 512 bits, respectively*/
    public final static String SHA_224 = "SHA-224";
    public final static String SHA_256 = "SHA-256";
    public final static String SHA_384 = "SHA-384";
    public final static String SHA_512 = "SHA-512";

    public final static List<String> MESSAGE_DIGEST_ALGORITHMS = Arrays.asList(MD2, MD5, SHA_1, SHA_224, SHA_256, SHA_384, SHA_512);

}
