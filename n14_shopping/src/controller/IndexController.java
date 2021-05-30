package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Item;
import logic.Shop;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
		
		return new ModelAndView("WEB-INF/jsp/index.jsp", model);
	}
}
