package spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import spring.mvc.model.CarVO;
import spring.mvc.model.MockService;

public class CarTestController extends MultiActionController{
	private MockService mockService;

	public CarTestController(MockService mockService) {
		this.mockService = mockService;
	}

	public ModelAndView registerCar(HttpServletRequest request,
			HttpServletResponse response, CarVO vo){

	/*String model = request.getParameter("model");
	int price = Integer.parseInt(request.getParameter("price"));
	
	String carInfo1 = mockService.register(new CarVO(model, price));*/
	
	return new ModelAndView("car_result", "infoCar1", vo);
	}
}
