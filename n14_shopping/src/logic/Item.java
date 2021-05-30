package logic;

import java.io.Serializable;

// dto 클래스.
public class Item implements Serializable{
	private Integer itemId; //item_id
	private String itemName; //item_name
	private Integer price;
	private String description;
	private String pictureUrl; //picture_url
	
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPictureUrl() {
		return pictureUrl;
	}
	
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	@Override
	public String toString() {
		return "Item [itemid=" + itemId + ", itemName=" + itemName + ", price="
				+ price + ", description=" + description + ", pictureUrl="
				+ pictureUrl + "]";
	}
}
