package test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample2.MessageBean;
import sample2.Outputter;

public class MessageBeanTest2 {
	public static void main(String[] args) throws IOException{
		ApplicationContext factory = new ClassPathXmlApplicationContext("message2.xml");
		
		MessageBean bean = factory.getBean("message2", MessageBean.class);
		
		bean.sayMessage();
		
		//추가
		Outputter bean2 = factory.getBean("output", Outputter.class);
		bean2.output("잘생김 .. 우성");
	}
}
