package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import solv2.MemberService;
import solv2.ProductService;

public class AopPojoAppTest3 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("solv2.xml");
		
		MemberService mem = (MemberService)factory.getBean("member");
		ProductService pro = (ProductService)factory.getBean("product");
		
		mem.register();
		mem.findMember("pojo");
		System.out.println("=================================");
		pro.deleteProduct();
		pro.updateProduct("aop");
	}
}
