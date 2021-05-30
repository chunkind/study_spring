package spring.mvc.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import spring.mvc.shopping.model.Item;
import spring.mvc.shopping.model.Shop;

public class ShoppingMultiController extends MultiActionController{
	
	private Shop shop;
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Item> list = shop.getItemList();
		
		return new ModelAndView("index", "list", list);
	}
	
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		
		Item item = shop.getItemByItemId(itemId);
		
		return new ModelAndView("detail", "item", item);
	}
}
