package com.example.spring.demo.thymecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class LeafController{
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(Model model){
        System.out.println("this is about page");
        model.addAttribute("name","Akash");
        model.addAttribute("currentDate",new Date().toString());
        return "about";
    }
}
