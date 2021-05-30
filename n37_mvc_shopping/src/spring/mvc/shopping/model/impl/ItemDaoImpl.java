package spring.mvc.shopping.model.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import spring.mvc.shopping.model.Item;
import spring.mvc.shopping.model.ItemDao;

public class ItemDaoImpl implements ItemDao{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Item> findAll() {
		return sqlSession.selectList("Item.findAll");
	}

	@Override
	public Item findByPrimaryKey(Integer itemId) {
		return sqlSession.selectOne("Item.findByPrimaryKey", itemId);
	}
}
