package com.juan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springboot_web.models.User;
import com.juan.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





//http://localhost:8080/api/var/baz/hola el parámetro se pasa como parte del path
@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private String [] listOfValues;

    //Incluye Spring Expression Language para manejar el valor con @value
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private List<String> valuesList;

    @Value("${config.code}")
    private Integer code;

    @Value("#{${config.valueMap}}")
    private Map <String, Object> valueMap;

    @Value("#{${config.valueMap}.product}")
    private String product;

    @Autowired
    private Environment environtment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;

    }
    
    @GetMapping("/mix/{product}/{id}")
    public Map <String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map <String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values() {
        
        Map <String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("code2", environtment.getProperty("config.code", Integer.class));
        json.put("username", username);
        json.put("message", message);
        json.put("message2", environtment.getProperty("config.message"));
        json.put("listOfValues", listOfValues);
        json.put("valuesList", valuesList);
        json.put("valuesMap", valueMap);
        json.put("product", product);
        return  json;
    }
    
    
    
}
