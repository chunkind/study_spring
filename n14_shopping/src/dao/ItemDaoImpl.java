package dao;
/*
 * jdbc FrameWork : JdbcTemplate를 사용..
 */
import java.util.List;

import javax.sql.DataSource;

import logic.Item;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ItemDaoImpl implements ItemDao{
	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	
	private static final String SELECT_ALL = "SELECT * FROM item";
	
	@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return template.query(SELECT_ALL, mapper);
	}
}
