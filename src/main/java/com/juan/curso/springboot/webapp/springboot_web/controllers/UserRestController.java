package com.juan.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springboot_web.models.User;
import com.juan.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details () {

        UserDto userDto = new UserDto();

        User user = new User("Juan", "Cruz");

        userDto.setTitle("Hola Mundo Springboot");
        userDto.setUser(user);
        // Map <String, Object> body = new HashMap<>();

        // body.put("title", "Hola Mundo Spring Boot");
        // body.put("user", user);
        return userDto;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap () {
        User user = new User("Juan", "Cruz");
         Map <String, Object> body = new HashMap<>();

         body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }

    @GetMapping("/list")
    public List <User> list (){

        User user = new User("Juan", "Cruz");
        User user2 = new User("Paco", "Porras");
        User user3 = new User("Tamara", "NoCambié");

        // List <User> users = new ArrayList<User>();

        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        List <User> users = Arrays.asList(user, user2, user3);

        return users;

    }

    //@GetMapping("/details")
    // public String details (Map <String, Object>model) {

    //     model.put("title", "Hola Mundo Spring Boot");
    //     model.put("name", "Juan");
    //     model.put("lastname", "Cruz");
    //     return "details";
    // }
}
