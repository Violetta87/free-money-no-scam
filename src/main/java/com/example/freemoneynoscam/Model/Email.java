package com.example.freemoneynoscam.Model;

public class Email {

    private String email;

    public Email(String email) {
        this.email = email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "email='" + email + '\'' +
                '}';
    }



    }