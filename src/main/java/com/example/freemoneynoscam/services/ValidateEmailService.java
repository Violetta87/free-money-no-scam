package com.example.freemoneynoscam.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email){
        boolean checker=false;
        for(int i=0; i<email.length(); i++){
            if(email.charAt(i)=='@'){
                checker=true;
            }
            if(email.endsWith(".string") || email.contains(".dk")){
                checker=true;

            }
        }
        return checker;
    }
}
