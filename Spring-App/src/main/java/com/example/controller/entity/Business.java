package com.example.controller.entity;

public class Business {

	private Integer id;
	private String name;
	private String readName;
	private String company;
	private String department;
	private String position;
	private String mail;
	private String tell;
	private String image;
	private String memo;
	private Integer roleId;
	private String userName;
	
	
	public Business() {
	}

	public Business(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo, Integer roleId) {
	    this.name = name;
	    this.readName = readName;
	    this.company = company;
	    this.department = department;
	    this.position = position;
	    this.mail = mail;
	    this.tell = tell;
	    this.image = image;
	    this.memo = memo;
	    this.roleId = roleId;
	}

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
	    return readName;
	}

	public void setReadName(String readName) {
	    this.readName = readName;
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
	
	public void setMemo(String memo) {
	    this.memo = memo;
	}
	
	public String getMemo() {
	    return memo;
	}

	

	public Integer getRoleId() {
	    return roleId;
	}
	
	public void setRoleId(Integer roleId) {
	    this.roleId = roleId;
	}

}