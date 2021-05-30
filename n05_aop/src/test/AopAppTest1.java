package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prob.MemberService;
import prob.ProductService;

public class AopAppTest1 {

	public static void main(String[] args) {
		ApplicationContext factory = new
				ClassPathXmlApplicationContext("prob.xml");
		
		MemberService m = (MemberService)factory.getBean("member");
		ProductService p = (ProductService)factory.getBean("product");
		
		m.register();
		m.findMember("Spring");
		
		System.out.println("////////////////////////////////////////////////");
		p.deleteProduct();
		p.searchProduct("Ajax");
		p.updateProduct("json");
	}

}
