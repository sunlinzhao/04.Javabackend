package com.hotel.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    /**
     * 使用Md5进行加密
     * @param text 明文
     * @return 密文
     */
    public static String getMd5String(String text)  {
        MessageDigest messageDigest= null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));
        StringBuilder builder=new StringBuilder();
        String tmp;
        for (byte b : digest) {
            tmp=Integer.toHexString(b&0xff);//11111111
            if (tmp.length()==1)
                builder.append(0);
            builder.append(tmp);
        }
        return builder.toString();
    }
}
