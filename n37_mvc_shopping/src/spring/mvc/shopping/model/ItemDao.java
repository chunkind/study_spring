package spring.mvc.shopping.model;

import java.util.List;

// 추상화된 비지니스 로직..
public interface ItemDao {
	List<Item> findAll();
	
// 추가..
	
	Item findByPrimaryKey(Integer itemId);
}
