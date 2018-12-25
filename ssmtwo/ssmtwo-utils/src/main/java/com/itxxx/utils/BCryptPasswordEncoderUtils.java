package com.itxxx.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    public static String encode(CharSequence password) {
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String encode = bpe.encode(password);
        return encode;
    }

    public static void main(String[] args) {
        String encode = encode("1234567");
        System.out.println(encode);
    }
}
