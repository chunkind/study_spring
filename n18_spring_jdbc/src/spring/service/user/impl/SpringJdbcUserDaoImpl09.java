package spring.service.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import spring.service.domain.User;
import spring.service.user.SqlService;
import spring.service.user.UserDao;
/*
	Annotation....
	@Component :: 는 레이어별로 세분화 되어진다.
	
	 @Component < @Service .....Service Layer Component
	 @Component < @Repository....Persistence Layer Component
	 @Component < @Controller ....Presentation Layer Component
 * 
 */
public class SpringJdbcUserDaoImpl09 extends JdbcDaoSupport implements UserDao{
	/*
	 * field위에 Annotation
	 * @Autowired : Spring 에서 지원하는 기술
	 * @Inject>@Named (javax.inject)
	 * @Resource : JDK1.6 에서 지원하는 기술.
	 * :: DataType을 기반으로 컨테이너가 생성하는 객체가 존재한다면 Injection 하란 의미
	 * 
	 * @Autowired : 객체가 존재하지 않아도 Exception 이 미발생..
	 * @Resource : 객체가 존재하지 않으면  Exception 이 발생..
	 */
	@Inject
	@Named("sqlService")
	SqlService sqlService;
	
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}
	
	//수정
	public SpringJdbcUserDaoImpl09(){
		System.out.println("::"+getClass().getName()+"() Default Constructor call...");
	}
	///Method
	//==> 회원정보 ::  INSERT ( 회원가입 )
	public int addUser(User user)  throws Exception{
		
		Object[ ] args = new Object[]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
				user.getRegDate()
		};
		return getJdbcTemplate().update(sqlService.getSql("user.sql.insert"), args);
	}	
			
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
	public User getUser(String userId) throws Exception {
	
		Object[ ] args = new Object[]{userId};
		
		return (User) getJdbcTemplate().queryForObject(sqlService.getSql("user.sql.select"), args,
				new RowMapper(){

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

	}//end of method


	//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
	public int updateUser(User user) throws Exception {
	
		Object[ ] args = new Object[ ]{
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
				user.getUserId()
				
		};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.update"), args);
		
	}	
	
	//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception{
		return getJdbcTemplate().update(sqlService.getSql("user.sql.delete"),userId);
		
	}//end of class
	
	
	//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
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
		return getJdbcTemplate().query(sqlService.getSql("user.sql.selectAll"), rowMapper);
	}//end of Method	
}//end of class

/*
 * 1) 문제점 :: 1. DataSource를 주입받고 있는 객체 JdbcTemplate를 생성하는 부분이 비지니스 로직마다마다 반복되고 있다..
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
 * 프레임워크가 나온 시발점이 copt/paste를 지양하기 위해서 나온 기술임을 봤을때 이는 상당한
 * 문제점으로 가져올수 있는 소스코딩 기법이다.
 * ::
 * 
 * 해결책
 * setJdbcTemplate()를 이미 가지고 있는 클래스를 상속받으면 된다.
 * setJdbcTemplate()를 가지고 있다는 의미는
 * JdbcTemplate 필드를 이미 가지고 있다는 뜻이기도 하다.
 * JdbcDaoSupport 라는 클래스를 상속받도록 하자.
 * 
 * 3) 문제점 ::
 * 비지로직 마다마다 sql 코드가 노출되어 있다.
 * 이렇게 되면.. 로직마다마다 sql코드를 직접 작성해줘야 하는데..
 * 기본적인 코드는 그렇다 치더라도 복잡하거나 난해한 쿼리문은 dba가 따로 작성한다.
 * 일의 분리를 위해서라도 sql 코드는 외부로 뽑아야 한다.
 * ::
 * 
 * 해결책
 * sql Resource Code의 Template화..메타데이타화
 * 이때 가장 단순한 방법의 메타데이타가 sqlCode를 properties 파일로 뽑아내는 것이다.
 * 뽑아낸 sqlCode의 properties 파일 내용을 Impl04에서 가지고 올때
 * 스프링 라이브러리 클래스를 이용할 것이다.
 * :
 * MessageSourceAccessor <-- ResourceBundleMessageSource <-- ~.properties
 * 
 * 
 * 04코드에서는 외부로 모듈화된 Properties 파일에 접근하는 클래스를 
 * 스프링 라이브러리를 사용했다.
 * 가만히 뜯어봤더니.. 이것도 결국은 Map방식이었다.
 * 굳이 라이브러리를 사용하지 않더라도 Map Collection을 이용하면 가능하리라..
 * 
 * 굳이 문제점을 찾자면.. XML 설정문서에서 Map에 와이어링된 값을 어떤 방법으로 
 * 끌어당길 것인가가 문제이다.
 * 즉, 메타데이타에 저장된 리소스를 받아오는 방식으로
 * <contextL placeholder location="config/~~~.properties" />
 * <bean id = "id" class = "fqcn">
 * 	<property name = "..." value = ${nn} />
 * 
 * 지금은 객체에 저장된 값을 접근해야 한다.
 * <util:properties location = "" id = ""/>
 * <bean id = "id" class = "fqcn">
 * 	<property name = "..." value = ${[nn]} />
 */