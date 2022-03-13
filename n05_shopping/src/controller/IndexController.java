package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public class IndexController implements Controller{
	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		List<Item> itemList = shopService.getItemList();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);
		
		return new ModelAndView("index", model);
	}
}
