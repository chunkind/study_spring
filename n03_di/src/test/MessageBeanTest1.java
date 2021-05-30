package test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.MessageBean;
import sample.Outputter;

public class MessageBeanTest1 {
	public static void main(String[] args) throws IOException{
		ApplicationContext factory = new ClassPathXmlApplicationContext("message1.xml");
		
		MessageBean bean = factory.getBean("message1", MessageBean.class);
		
		bean.sayMessage();
		
		//추가
		Outputter bean2 = factory.getBean("output",Outputter.class);
		bean2.output("잘생김 .. 우성");
	}
}
