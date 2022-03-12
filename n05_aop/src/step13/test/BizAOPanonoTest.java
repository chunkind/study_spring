package step13.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step13.BizService;

public class BizAOPanonoTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step13/anno.xml");
		BizService target = factory.getBean("target", BizService.class);
		target.register();
		System.out.println("*************************");
		target.findId();
	}
}
