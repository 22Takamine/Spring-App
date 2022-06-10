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
    private static final String SELECT_BY_BUSINESS_NAME = "SELECT * FROM business_card WHERE name like '%' || :name || '%' ORDER BY id";
    private static final String SELECT_BY_BUSINESS_COMPANY = "SELECT * FROM business_card WHERE company  like '%' || :company || '%' ORDER BY id";
    private static final String SELECT_BY_BUSINESS_NAME_OR_COMPANY = "SELECT * FROM business_card WHERE name like '%' || :keyword || '%' OR company  like '%' || :keyword || '%' ORDER BY id";
    private static final String INSERT = "INSERT INTO business_card (name, read_name, company, department, position, mail, tell, image, memo) VALUES (:name, :read_name, :company, :department, :position, :mail, :tell, :image, :memo)";
    private static final String DELETE = "DELETE FROM business_card WHERE id = :id";
    private static final String UPDATE = "UPDATE business_card SET name = :name, read_name = :read_name, company = :company, department = :department, position = :position, mail = :mail, tell = :tell, image = :image, memo = :memo  WHERE id = :id";
    
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public List<Business> findAll() {
        String sql = SELECT_BY_BUSINESS_ALL;

        MapSqlParameterSource param = new MapSqlParameterSource();

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList;
    }

    public Business findById(Integer id) {
        String sql = SELECT_BY_BUSINESS_ID;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public Business findByName(String name) {
        String sql = SELECT_BY_BUSINESS_NAME;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public List<Business> findByCompany(String company) {
        String sql = SELECT_BY_BUSINESS_COMPANY;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("company", company);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList;
    }
    
    public List<Business> findByNameOrCompany(String keyword) {
        String sql = SELECT_BY_BUSINESS_NAME_OR_COMPANY;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("keyword", keyword);

        List<Business> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Business>(Business.class));

        return resultList;
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
    
    public void update(String name, String readName, String company, String department, String position, String mail, String tell, String image, String memo, Integer id) {
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
        param.addValue("id", id);
        
        jdbcTemplate.update(sql, param);  
    	
    }

}