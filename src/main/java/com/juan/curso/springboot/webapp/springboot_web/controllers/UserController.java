package com.juan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details (Model model) {

        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("name", "Juan");
        model.addAttribute("lastname", "Cruz");
        return "details";
    }

    //@GetMapping("/details")
    // public String details (Map model) {

    //     model.put("title", "Hola Mundo Spring Boot");
    //     model.put("name", "Juan");
    //     model.put("lastname", "Cruz");
    //     return "details";
    // }
}
