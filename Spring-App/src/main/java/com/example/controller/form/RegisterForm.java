package com.example.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegisterForm {
    
    @NotBlank
    private String id;
    
    @NotBlank
    private String pass;
    
    @NotBlank
    private String name;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getPass() {
    	return pass;
    }
    
    public void setPass(String pass) {
    	this.pass = pass;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    
}