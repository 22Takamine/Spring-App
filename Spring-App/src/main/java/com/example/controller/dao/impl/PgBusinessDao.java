package com.example.controller.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.controller.dao.BusinessDao;
import com.example.controller.entity.Business;


@Repository
public class PgBusinessDao implements BusinessDao {

	private static final String SELECT_BY_BUSINESS_ALL = "SELECT * FROM business_card ORDER BY id";
    private static final String SELECT_BY_BUSINESS_ID = "SELECT * FROM business_card WHERE id = :id ORDER BY id";
    private static final String SELECT_BY_BUSINESS_NAME = "SELECT * FROM business_card WHERE name = :name ORDER BY id";
    private static final String SELECT_BY_BUSINESS_COMPANY = "SELECT * FROM business_card WHERE company = :company ORDER BY id";
    private static final String INSERT = "INSERT INTO business_card (name, read_name, company, department, position, mail, tell, image, memo) VALUES (:name, :read_name, :company, :department, :position, :mail, :tell, :image, :memo)";
    private static final String DELETE = "DELETE FROM business_card WHERE login_id = :id";
    private static final String UPDATE = "UPDATE business_card SET login_name = :id, password = :pass, name = :name WHERE id = :id";
    
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public List<Business> findAll() {
        String sql = SELECT_BY_BUSINESS_ALL;

        MapSqlParameterSource param = new MapSqlParameterSource();

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList.isEmpty() ? null : resultList;
    }

    public Business findById(Integer id) {
        String sql = SELECT_BY_BUSINESS_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public List<Business> findByName(String name) {
        String sql = SELECT_BY_BUSINESS_NAME;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList.isEmpty() ? null : resultList;
    }
    
    public List<Business> findByCompany(String company) {
        String sql = SELECT_BY_BUSINESS_COMPANY;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("company", company);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList.isEmpty() ? null : resultList;
    }
    
    public void insert(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo) {
    	String sql = INSERT;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);
        param.addValue("read_name", readName);
        param.addValue("company", company);
        param.addValue("department", department);
        param.addValue("position", position);
        param.addValue("mail", mail);
        param.addValue("tell", tell);
        param.addValue("image", image);
        param.addValue("memo", memo);
        
        jdbcTemplate.update(sql, param);
        
    }
    
    public void delete(Integer id) {
    	String sql = DELETE;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        
        jdbcTemplate.update(sql, param);  
    	
    }
    
    public void update(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo) {
    	String sql = UPDATE;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
    	param.addValue("name", name);
        param.addValue("read_name", readName);
        param.addValue("company", company);
        param.addValue("department", department);
        param.addValue("position", position);
        param.addValue("mail", mail);
        param.addValue("tell", tell);
        param.addValue("image", image);
        param.addValue("memo", memo);
        
        jdbcTemplate.update(sql, param);  
    	
    }

}