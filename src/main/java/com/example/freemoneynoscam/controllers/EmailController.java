package com.example.freemoneynoscam.controllers;


import com.example.freemoneynoscam.EmailDirectory.EmailDirectory;
import com.example.freemoneynoscam.Model.Email;
import com.example.freemoneynoscam.services.ServiceIndex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class EmailController {

    ServiceIndex serviceIndex = new ServiceIndex();
    EmailDirectory emailDirectory = new EmailDirectory();


    @GetMapping("/")
    public String index(){
        //emailDirectory.connectDB();
        return "index";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        String email = dataFromForm.getParameter("email");
        serviceIndex.insertToDatabase(email);

        return "redirect:/knapside";
    }

    @GetMapping("/knapside")
    public String knap(){
        return "knapside";
    }

    @GetMapping("/totalEmails")
    public String email(Model model){
        ArrayList<Email> emails = emailDirectory.getEMailsFromDatabase();
        model.addAttribute("emails", emails);
        return "totalEmail";
    }


}
