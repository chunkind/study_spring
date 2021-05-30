package logic;

import java.util.List;

//Service Layer의 Component.. 데이타 가공과 관련있는 레이어.
public interface ItemCatalog {
	List<Item> getItemList();
}
