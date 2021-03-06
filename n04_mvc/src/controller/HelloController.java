package controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("greeting", getGreet());
		return mv;
	}
	private String getGreet() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour >=7 && hour <=11) {
			return "좋은 아침~";
		}else if (hour >=12 && hour <3) {
			return "식사 하셨나요?";
		}else {
			return "우리는 무르는 사이";
		}
	}
}
