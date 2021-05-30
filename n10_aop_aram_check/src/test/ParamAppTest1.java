package test;


import kosta.model.Customer;
import kosta.model.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParamAppTest1 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("param.xml");
		Customer custom = factory.getBean("customer",Customer.class);
		Member mem = factory.getBean("member", Member.class);
		
		custom.findCustomer("", "판교");
		custom.insertCustomer(null);
		System.out.println("==========================================================");
		mem.deleteMember(null,"");
	}
}
