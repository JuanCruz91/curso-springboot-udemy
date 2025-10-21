package com.juan.curso.springboot.webapp.springboot_web.models;

public class User {

    private String name;
    private String lasname;

    


    public User(String name, String lasname) {
        this.name = name;
        this.lasname = lasname;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLasname() {
        return lasname;
    }
    public void setLasname(String lasname) {
        this.lasname = lasname;
    }

    
}
