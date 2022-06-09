package com.example.controller.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.controller.dao.UserDao;
import com.example.controller.entity.User;


@Repository
public class PgUserDao implements UserDao {

	private static final String SELECT_BY_USER_ALL = "SELECT * FROM users ORDER BY id";
    private static final String SELECT_BY_USER_ID = "SELECT * FROM users WHERE login_id = :id ORDER BY id";
    private static final String SELECT_BY_USER_ID_AND_PASS = "SELECT * FROM users WHERE login_id = :id AND password = :pass ORDER BY id";
    private static final String INSERT = "INSERT INTO users (login_id, password, name, role) VALUES (:id, :pass, :name, 2)";
    private static final String DELETE = "DELETE FROM users WHERE login_id = :id";
    private static final String UPDATE = "UPDATE users SET login_name = :id, password = :pass, name = :name WHERE id = :id";
    
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public List<User> findAll() {
        String sql = SELECT_BY_USER_ALL;

        MapSqlParameterSource param = new MapSqlParameterSource();

        List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));

        return resultList.isEmpty() ? null : resultList;
    }

    public User findById(String id) {
        String sql = SELECT_BY_USER_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public User findByIdAndPass(String id, String pass) {
        String sql = SELECT_BY_USER_ID_AND_PASS;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        param.addValue("pass", pass);

        List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public void insert(String id, String pass, String name) {
    	String sql = INSERT;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        param.addValue("pass", pass);
        param.addValue("name", name);
        
        jdbcTemplate.update(sql, param);
        
    }
    
    public void delete(String id) {
    	String sql = DELETE;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        
        jdbcTemplate.update(sql, param);  
    	
    }
    
    public void update(String id, String pass, String name) {
    	String sql = UPDATE;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        param.addValue("pass", pass);
        param.addValue("name", name);
        
        
        jdbcTemplate.update(sql, param);  
    	
    }

}