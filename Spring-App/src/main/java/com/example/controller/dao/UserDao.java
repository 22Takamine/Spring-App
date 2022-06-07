package com.example.controller.dao;

import java.util.List;

import com.example.controller.entity.User;

public interface UserDao {

	public List<User> findAll();
    public User findById(String id);
    public User findByIdAndPass(String id, String pass);
    public void insert(String id, String pass, String name);
    public void delete(String id);
    public void update(String id, String pass, String name);

}