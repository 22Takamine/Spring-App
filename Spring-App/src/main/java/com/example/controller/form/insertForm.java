package com.example.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class insertForm {
    
    private Integer id;
    private String department;
    private String position;
    private String mail;
    private String tell;
    private String image;
    private String memo;
    private Integer role_id;
    private String read_name;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String company;
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getReadName() {
    	return read_name;
    }
    
    public void setReadName(String read_name) {
    	this.read_name = read_name;
    }
    
    public String getCompany() {
    	return company;
    }
    
    public void setCompany(String company) {
    	this.company = company;
    }
    
    public String getDepartment() {
    	return department;
    }
    
    public void setDepartment(String department) {
    	this.department = department;
    }
    
    public String getPosition() {
    	return position;
    }
    
    public void setPosition(String position) {
    	this.position = position;
    }
    
    public String getMail() {
    	return mail;
    }
    
    public void setMail(String mail) {
    	this.mail = mail;
    }
    
    public String getTell() {
    	return tell;
    }
    
    public void setTell(String tell) {
    	this.tell = tell;
    }
    
    public String getImage() {
    	return image;
    }
    
    public void setImage(String image) {
    	this.image = image;
    }
    
    public String getMemo() {
    	return memo;
    }
    
    public void setMemo(String memo) {
    	this.memo = memo;
    }
    
    public Integer getRoleId() {
    	return role_id;
    }
    
    public void setRoleId(Integer role_id) {
    	this.role_id = role_id;
    }
    
    
}