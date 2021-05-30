package spring.mvc.shopping.model;

import java.util.List;

public interface Shop {
	List<Item> getItemList();
	Item getItemByItemId(Integer itemId);
}
