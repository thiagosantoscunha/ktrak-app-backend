package com.ktrakapp.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class Utils {

    public static String getFirstAndLastName(String fullname) {
        String[] values = fullname.split(" ");
        return values[0] + " " + values[values.length - 1];
    }

    public static String getUsernameByFullname(String fullname) {
        String[] values = fullname.split(" ");
        return values[0].toLowerCase() + "." + values[values.length - 1].toLowerCase();
    }

    public static String encodePassword(String value) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(value);
    }

}
