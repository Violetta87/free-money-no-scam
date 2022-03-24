package com.example.freemoneynoscam.services;


import com.example.freemoneynoscam.EmailDirectory.EmailDirectory;

public class ServiceIndex {

    ValidateEmailService validateEmailService = new ValidateEmailService();
    EmailDirectory emailDirectory = new EmailDirectory();



    public boolean insertToDatabase(String email){

        emailDirectory.connectDB();

        boolean validEmail = validateEmailService.isEmailValid(email);

        if(validateEmailService.isEmailValid(email)==true){
            emailDirectory.makeTableEmail(email);
            System.out.println("email is correct");
            return true;
        }
        return false;
    }

}
