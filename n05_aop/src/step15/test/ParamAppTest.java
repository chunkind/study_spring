package step15.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step15.model.Customer;
import step15.model.Member;

public class ParamAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step15/param.xml");
		Customer custom = factory.getBean("customer",Customer.class);
		Member mem = factory.getBean("member", Member.class);
		
		custom.findCustomer("", "부천");
		custom.insertCustomer(null);
		System.out.println("==========================================================");
		mem.deleteMember(null,"");
	}
}