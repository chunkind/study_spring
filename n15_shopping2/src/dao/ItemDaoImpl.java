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
	private static final String SELECT_ALL = "SELECT * FROM item";
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM item WHERE item_id = ?";
	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return template.query(SELECT_ALL, mapper);
	}

	@Override
	public Item findByPrimaryKey(Integer itemId) {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return template.queryForObject(SELECT_BY_PRIMARY_KEY, mapper, itemId);
	}
}
