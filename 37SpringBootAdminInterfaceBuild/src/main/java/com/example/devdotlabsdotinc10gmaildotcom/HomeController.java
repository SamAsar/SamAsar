package com.example.devdotlabsdotinc10gmaildotcom;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String viewHome(){
        return "index";
    }
}
