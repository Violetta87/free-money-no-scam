package com.example.freemoneynoscam.services;

import Emailrepository.Mysql;

public class ServiceIndex {

    ValidateEmailService validateEmailService = new ValidateEmailService();
    Mysql mysqlnew = new Mysql();



    public boolean insertToDatabase(String email){

        mysqlnew.connectDB();

        boolean validEmail = validateEmailService.isEmailValid(email);

        if(validateEmailService.isEmailValid(email)==true){
            mysqlnew.makeTableMovie(email);
            System.out.println("email is correct");
            return true;
        }
        return false;
    }

}
