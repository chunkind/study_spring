package spring.mvc.shopping.model.impl;

import java.util.List;

import spring.mvc.shopping.model.Item;
import spring.mvc.shopping.model.ItemCatalog;
import spring.mvc.shopping.model.Shop;

public class ShopImpl implements Shop{
	private ItemCatalog itemCatalog;
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	@Override
	public List<Item> getItemList() {
	
		return itemCatalog.getItemList();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		
		return itemCatalog.getItemByItemId(itemId);
	}
}
