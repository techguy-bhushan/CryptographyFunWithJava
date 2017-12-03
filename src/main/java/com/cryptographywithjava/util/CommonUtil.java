package com.cryptographywithjava.util;

public class CommonUtil {

    public static String convertByteToHexFormat(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<bytes.length;i++) {
            hexString.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return hexString.toString();
    }
}
