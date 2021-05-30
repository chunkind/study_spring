package jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sun.rowset.internal.Row;
/*
 * JdbcTemplate ::
 * Spring jdbc Framework에서 가장 핵심적인 클래스
 * org.springframework.jdbc.core> 에서 제공된다.
 * 생성자로 DataSource를 주입받고 있다.
 * 쿼리문을 실행하는 로직을 자체적으로 가지고 있고
 * JdbcTemplate를 이용하면 jdbc workflow 4단계로 줄여서 간단한 작업을 할수 있다.
 * 
 * 쿼리문 수행 기능 :
 * update(spl) : insert, delete, update 같은 쿼리문을 수행한다.
 * query(spl), queryForList(sql) : select
 * queryForObject(sql)
 */
/*
 * JdbcTemplate ::
 * Spring jdbc Framework에서 가장 핵심적인 클래스
 * org.springframework.jdbc.core> 에서 제공된다.
 * 생성자로 DataSource를 주입받고 있다.
 * 쿼리문을 실행하는 로직을 자체적으로 가지고 있고
 * JdbcTemplate를 이용하면 jdbc workflow 4단계로 줄여서 간단한 작업을 할수 있다.
 * 
 * 쿼리문 수행 기능 :
 * update(spl) : insert, delete, update 같은 쿼리문을 수행한다.
 * query(spl), queryForList(sql) : select
 * queryForObject(sql)
 */
/*
 * JdbcTemplate ::
 * Spring jdbc Framework에서 가장 핵심적인 클래스
 * org.springframework.jdbc.core> 에서 제공된다.
 * 생성자로 DataSource를 주입받고 있다.
 * 쿼리문을 실행하는 로직을 자체적으로 가지고 있고
 * JdbcTemplate를 이용하면 jdbc workflow 4단계로 줄여서 간단한 작업을 할수 있다.
 * 
 * 쿼리문 수행 기능 :
 * update(spl) : insert, delete, update 같은 쿼리문을 수행한다.
 * query(spl), queryForList(sql) : select
 * queryForObject(sql)
 */
/*
 * JdbcTemplate ::
 * Spring jdbc Framework에서 가장 핵심적인 클래스
 * org.springframework.jdbc.core> 에서 제공된다.
 * 생성자로 DataSource를 주입받고 있다.
 * 쿼리문을 실행하는 로직을 자체적으로 가지고 있고
 * JdbcTemplate를 이용하면 jdbc workflow 4단계로 줄여서 간단한 작업을 할수 있다.
 * 
 * 쿼리문 수행 기능 :
 * update(spl) : insert, delete, update 같은 쿼리문을 수행한다.
 * query(spl), queryForList(sql) : select
 * queryForObject(sql)
 */
public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao{
	
	/*private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	///// 비지니스 로직 /////
	@Override
	public void register(MemberVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO member VALUES(");
		sql.append("?, ?, ?, ?)");
		
		Object[ ] param = {vo.getId(), vo.getName(), vo.getPassword(), vo.getAddress() };
		getJdbcTemplate().update(sql.toString(), param);
	}

	@Override
	public List<MemberVO> getList() {
		String sql = "SELECT * FROM member";
		
		RowMapper<MemberVO> mapper = 
				new BeanPropertyRowMapper<MemberVO>(MemberVO.class);
		return getJdbcTemplate().query(sql, mapper);
	}

	@Override
	public MemberVO getSearch(String id) {
		String sql = "SELECT * FROM member WHERE id = ?";
		Object[ ] param = {id};
		
		RowMapper<MemberVO> mapper = 
				new BeanPropertyRowMapper<MemberVO>(MemberVO.class);
		
		return getJdbcTemplate().queryForObject(sql, mapper,param);
	}
}
