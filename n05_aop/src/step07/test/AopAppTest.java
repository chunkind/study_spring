package step07.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step07.MessageBean;

public class AopAppTest {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("step07/aop.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("target");
		
		bean.sayHello();
	}
}
