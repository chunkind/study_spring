package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anno.service.BizService;

public class BizAOPanonoTest1 {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("anno1.xml");
		
		BizService target = factory.getBean("target",BizService.class);
		target.register();
		System.out.println("*************************");
		target.findId();
	}
}
