package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop4.MessageBean;

public class AopAppTest4 {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("aop4.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("target");
		
		bean.sayHello();
	}
}
