package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anno5.MessageBean;


public class AnnoAppTest5 {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("anno5.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("target");
		
		bean.sayHello();
	}
}
