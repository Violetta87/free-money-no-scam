package com.example.freemoneynoscam.controllers;

import Emailrepository.Mysql;
import com.example.freemoneynoscam.services.ServiceIndex;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    Mysql mysql= new Mysql();
    ServiceIndex serviceIndex = new ServiceIndex();


    @GetMapping("/")
    public String index(){
        mysql.connectDB();
        return "index";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        String email = dataFromForm.getParameter("email");
        serviceIndex.insertToDatabase(email);

        return "redirect:/";
    }


}
