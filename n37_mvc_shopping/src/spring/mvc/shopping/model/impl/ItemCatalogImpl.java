package spring.mvc.shopping.model.impl;

import java.util.List;

import spring.mvc.shopping.model.Item;
import spring.mvc.shopping.model.ItemCatalog;
import spring.mvc.shopping.model.ItemDao;

public class ItemCatalogImpl implements ItemCatalog{
	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getItemList() {
		
		return itemDao.findAll();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		return itemDao.findByPrimaryKey(itemId);
	}
}
