package spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import spring.mvc.model.CarVO;
import spring.mvc.model.MockService;

public class CarController extends AbstractCommandController{
   private MockService mockService;
   
   public CarController(MockService mockService) {
      this.mockService = mockService;
      
      //폼에 입력된 값이 자동으로 CarVO로 바인딩되고
      //CarVO가 CarController에 다시 바인딩 왼다.
      this.setCommandClass(CarVO.class);
   }

   @Override
   protected ModelAndView handle(HttpServletRequest request,
         HttpServletResponse response, Object command, BindException e)
         throws Exception {
      //바인딩 부분이 생략 될 수 있다.
//      String model = request.getParameter("model");
//      int price = Integer.parseInt(request.getParameter("price"));
//      CarVO v = new CarVO(Model,price);
      CarVO cvo = (CarVO)command;
      System.out.println("Command Value :: "+cvo);
      String carInfo = mockService.register(cvo);
      return new ModelAndView("car_result","info",carInfo);
   }
   

}