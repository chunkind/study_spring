package step07.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step07.MessageBean;
import step07.Outputter;

public class MessageBeanTest {
	public static void main(String[] args) throws IOException{
		ApplicationContext factory = new ClassPathXmlApplicationContext("step7/xml/message.xml");
		MessageBean bean = factory.getBean("message", MessageBean.class);
		bean.sayMessage();
		
		//추가
		Outputter bean2 = factory.getBean("output", Outputter.class);
		bean2.output("잘생김 .. 준성\n");
	}
}