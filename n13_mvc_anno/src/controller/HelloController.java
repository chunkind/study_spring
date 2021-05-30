package controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
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
