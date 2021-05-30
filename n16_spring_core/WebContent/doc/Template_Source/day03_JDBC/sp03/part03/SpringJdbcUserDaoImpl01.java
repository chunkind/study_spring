package spring.service.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import spring.service.domain.User;
import spring.service.user.UserDao;

public class SpringJdbcUserDaoImpl01 implements UserDao{

	
	
	///Method
	//==> 회원정보 ::  INSERT ( 회원가입 )
	public int addUser(User user)  throws Exception{
		

	}	
			
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
	public User getUser(String userId) throws Exception {
		


	}//end of method

	
	//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
	public int updateUser(User user) throws Exception {
		StringBuffer userUpdate = new StringBuffer();
		userUpdate.append("UPDATE users ");
		//userUpdate.append("SET user_name = ?,password=?,age=? ");
		userUpdate.append("SET user_name =:name,password=:password,age=:age ");
		//userUpdate.append("WHERE user_id=?");
		userUpdate.append("WHERE user_id=:id");
		
	//	NamedParameterJdbcTemplate 은 파라미터의 바인딩되는 순서는 중요하지 않다(이유 :: Map방식)
		NamedParameterJdbcTemplate jdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
		
		
		Map paramMap = new HashMap();
		paramMap.put("name", user.getUserName());
		paramMap.put("password", user.getPassword());
		paramMap.put("age", user.getAge());
		paramMap.put("id", user.getUserId());
		
		return jdbcTemplate.update(userUpdate.toString(), paramMap);
		
	}	
	
	//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception{
		StringBuffer  userDelete = new StringBuffer();
		userDelete.append("DELETE ");
		userDelete.append("FROM USERS ");
		userDelete.append("WHERE user_id=:id");
		
		NamedParameterJdbcTemplate jdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
		Map paramMap = new HashMap();
		paramMap.put("id", userId);
		
		return jdbcTemplate.update(userDelete.toString(),paramMap);
		
	}//end of class
	
	
	//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
		


		return jdbcTemplate.query(usersSelectAll.toString(), rowMapper);
	}//end of Method
	
}//end of class

/*
 * 문제점 ::

 */




















