package com.example.freemoneynoscam.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email) {
        boolean checker = true;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) != '@') {
                checker = false;
            }
            if (!email.endsWith(".com") || !email.contains(".dk")) {
                checker = false;

            }

        }
        return checker;
    }
}
