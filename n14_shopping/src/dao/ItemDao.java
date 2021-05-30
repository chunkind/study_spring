package dao;

import java.util.List;

import logic.Item;

// 추상화된 비지니스 로직..
public interface ItemDao {
	List<Item> findAll();
}
