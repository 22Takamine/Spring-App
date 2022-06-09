package com.example.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.dao.BusinessDao;
import com.example.controller.entity.Business;
import com.example.controller.service.BusinessService;



@Service
public class BusinessServiceImp implements BusinessService {

    @Autowired
    private BusinessDao businessDao;

    public List<Business> findAll() {
        return businessDao.findAll();
    }
    
    public Business findById(Integer id) {
        return businessDao.findById(id);
    }
    
    public List<Business> findByName(String name) {
        return businessDao.findByName(name);
    }
    
    public List<Business> findByCompany(String company) {
        return businessDao.findByCompany(company);
    }
    
    public void insert(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo) {
        businessDao.insert(name, readName, company, department, position, mail, tell, image, memo);
    }
    
    public void delete(Integer id) {
        businessDao.delete(id);
    }
    
    public void update(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo) {
        businessDao.update(name, readName, company, department, position, mail, tell, image, memo);
    }
}