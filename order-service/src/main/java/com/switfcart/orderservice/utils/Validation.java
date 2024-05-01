package com.switfcart.orderservice.utils;


public class Validation {
    public static boolean validateUserName(String username) {
        if (username == null || username.length() < 3) return false;
        return true;
    }

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 5) return false;
        return true;
    }
}
