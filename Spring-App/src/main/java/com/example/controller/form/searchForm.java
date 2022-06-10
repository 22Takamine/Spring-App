package com.example.controller.form;

import lombok.Data;

@Data
public class searchForm {
    
    
    private String keyword;

    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }  
    
}

