package spring.service.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import spring.service.domain.User;
import spring.service.user.UserDao;

public class SpringJdbcUserDaoImpl02 implements UserDao {
	/*
	 * 01 에서는 DataSource를 직접 필드에 선언했었다. 02 에서는 JdbcTemplate를 필드에 선언하는 것으로 수정.
	 * 이렇게 되면 DataSource는 JdbcTemplate이 hasing하는 관계로 수정되어야 한다. 이때 JdbcTemplate이
	 * DataSource를 setter/생성자로 주입하는지 잘 살펴보면 된다. 거의다 setter 주입이 대부분이다.
	 */
	// 추가..
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// 추가.. setter()
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public SpringJdbcUserDaoImpl02() {
		System.out.println("::" + getClass().getName()
				+ "() Default Constructor call...");
	}

	// /Method
	// ==> 회원정보 :: INSERT ( 회원가입 )
	public int addUser(User user) throws Exception {
		StringBuffer userInsert = new StringBuffer();
		userInsert.append("INSERT ");
		userInsert
				.append("INTO users(user_id, user_name, password, age, reg_date)");
		userInsert.append(" VALUES(?,?,?,?,?)");

		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { user.getUserId(), user.getUserName(),
				user.getPassword(), user.getAge(), user.getRegDate() };
		return jdbcTemplate.update(userInsert.toString(), args);
	}

	// ==> 회원정보 :: SELECT ( 회원정보 검색 )
	public User getUser(String userId) throws Exception {
		StringBuffer userSelect = new StringBuffer();
		userSelect.append("SELECT ");
		userSelect.append("user_id, user_name, password, age, reg_date ");
		userSelect.append("FROM users WHERE user_id=?");

		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { userId };

		return (User) jdbcTemplate.queryForObject(userSelect.toString(), args,
				new RowMapper() {

					@Override
					public Object mapRow(ResultSet rs, int arg1)
							throws SQLException {
						User user = new User();
						user.setUserId(rs.getString("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setPassword(rs.getString("password"));
						user.setAge(rs.getInt("age"));
						user.setRegDate(rs.getTimestamp("reg_date"));
						return user;
					}
				});

	}// end of method

	// ==> 회원정보 :: UPDATE ( 회원정보 변경 )
	public int updateUser(User user) throws Exception {
		StringBuffer userUpdate = new StringBuffer();
		userUpdate.append("UPDATE users ");
		// userUpdate.append("SET user_name = ?,password=?,age=? ");
		userUpdate.append("SET user_name =:name,password=:password,age=:age ");
		// userUpdate.append( "WHERE user_id=?");
		userUpdate.append("WHERE user_id=:id");

		// NamedParameterJdbcTemplate 은 파라미터의 바인딩되는 순서는 중요하지 않다(이유 :: Map방식)
		// NamedParameterJdbcTemplate jdbcTemplate =new
		// NamedParameterJdbcTemplate(dataSource);

		Map paramMap = new HashMap();
		paramMap.put("name", user.getUserName());
		paramMap.put("password", user.getPassword());
		paramMap.put("age", user.getAge());
		paramMap.put("id", user.getUserId());

		return namedParameterJdbcTemplate.update(userUpdate.toString(),
				paramMap);

	}

	// ==> 회원정보 :: DELETE ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception {
		StringBuffer userDelete = new StringBuffer();
		userDelete.append("DELETE ");
		userDelete.append("FROM USERS ");
		userDelete.append("WHERE user_id=:id");

		// NamedParameterJdbcTemplate jdbcTemplate =new
		// NamedParameterJdbcTemplate(dataSource);
		Map paramMap = new HashMap();
		paramMap.put("id", userId);

		return namedParameterJdbcTemplate.update(userDelete.toString(),
				paramMap);

	}// end of class

	// ==> 회원정보 :: SELECT ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
		String userSelectAll = new String("SELECT * FROM users");
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		RowMapper rowMapper = new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setRegDate(rs.getTimestamp("reg_date"));
				return user;
			}
		};
		return jdbcTemplate.query(userSelectAll.toString(), rowMapper); // 쿼리문에 왜 안에 인자값이 userSelectAll.toString(), rowMapper 이게 들어와?
	}// end of Method
}// end of class

/*
 * 문제점 :: 1. DataSource를 주입받고 있는 객체 JdbcTemplate를 생성하는 부분이 비지니스 로직마다마다 반복되고 있다..
 * 이 부분은 고정적인 부분. 2. Framework부분에서 코드에서 절대로 노출되면 안되는 부분이 있다. 구상객체명. ...new 라는
 * 키워드가 노출되면 안된다. 재사용성이 떨어지고 / 유지보수성이 낮아지기 때문이다. 해결책 :: DataSource를 주입받고 있는 객체,
 * JdbcTemplate, NamedParameterJdbcTemplate 얘네들을 필드로 선언하자. 이렇게 하면 new
 * JdbcTemplate(), new NamedParameterJdbcTemplate() 이 부분이 사라지게 된다.
 * 
 * 2) 문제점 ::
 * 1. 프로젝트에는 ~DaoImple 들이 많이 존재한다.
 * 예를 들어서 BoardDaoImpl, SalesDaoImpl, ProductDaoImpl..등등이 있다.
 * 이 객체들 마다 jdbcTemplate 같은 필드주입, setter() 선언이 반복적으로 작성
 * 되어야 한다는 뜻이다..
 * 프레임워크가 나온 시발점이 copy/paste를 지양하기 위해서 나온 기술임을 봤을때 이는 상당한
 * 문제점으로 가져올수 있는 소스코딩 기법이다.
 * ::
 * 
 * 해결책
 * setJdbcTemplate()를 이미 가지고 있는 클래스를 상속받으면 된다.
 * setJdbcTemplate()를 가지고 있다는 의미는
 * JdbcTemplate 필드를 이미 가지고 있다는 뜻이기도 하다.
 * JdbcDaoSupport 라는 클래스를 상속받도록 하자.
 */