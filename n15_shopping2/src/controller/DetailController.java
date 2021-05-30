package controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Item;
import logic.Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * Controller를 상속받지 않고
 * Annotation 기반으로 작성..
 */
@Controller("detailController")
public class DetailController{
	
	@Inject //javax.inject.Inject
	@Named("shopService")
	private Shop shopService;
	
//	public void setShopService(Shop shopService) {
//		this.shopService = shopService;
//	}
	@RequestMapping
	public ModelAndView detailitem(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//biz logic call...
		Integer itemId = Integer.parseInt(request.getParameter("itemId"));
		Item item = shopService.getItemByItemId(itemId);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);
		return new ModelAndView("detail", model);
	}

}
