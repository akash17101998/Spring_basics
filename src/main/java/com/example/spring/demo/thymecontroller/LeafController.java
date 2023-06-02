package com.example.spring.demo.thymecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class LeafController{
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(Model model){
        System.out.println("this is about page");
        model.addAttribute("name","Akash");
        model.addAttribute("currentDate",new Date().toString());
        return "about";
        }
    @GetMapping("/iterate")
    public String iterateHandle(Model m){
//        int[] a= new int[]{1,2,3,4,5};
//        for(int e:a) {
//            System.out.println(e);
//
//        }
//        m.addAttribute("e",a.toString());
        List<String> e = List.of("akash","arun","aman");
        m.addAttribute("e",e);
        return "iterate";
    }
}
