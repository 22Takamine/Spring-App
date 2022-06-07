package com.example.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.dao.UserDao;
import com.example.controller.entity.User;
import com.example.controller.service.UserService;



@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
    
    public User findById(String id) {
        return userDao.findById(id);
    }
    
    public User findByIdAndPass(String id, String pass) {
        return userDao.findByIdAndPass(id, pass);
    }
    
    public void insert(String id, String pass, String name) {
        userDao.insert(id, pass, name);
    }
    
    public void delete(String id) {
        userDao.delete(id);
    }
    
    public void update(String id, String pass, String name) {
        userDao.update(id, pass, name);
    }
}