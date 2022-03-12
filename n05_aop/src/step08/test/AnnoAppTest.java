package step08.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step08.MessageBean;


public class AnnoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step08/anno.xml");
		MessageBean bean = (MessageBean)factory.getBean("target");
		bean.sayHello();
	}
}
