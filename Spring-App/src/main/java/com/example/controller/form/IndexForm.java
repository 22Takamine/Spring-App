package com.example.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class IndexForm {
    
    @NotBlank
    private String id;
    
    @NotBlank
    private String pass;
    
    
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
    
    


}

