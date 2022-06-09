package com.example.controller.service;

import java.util.List;

import com.example.controller.entity.Business;

public interface BusinessService {

	public List<Business> findAll();
    public Business findById(Integer id);
    public List<Business> findByName(String name);
    public List<Business> findByCompany(String company);
    public void insert(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo);
    public void delete(Integer id);
    public void update(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo);

}