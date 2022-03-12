package step01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.MemberService;
import step01.ProductService;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * MemberService, ProductService 는 비지니스 로직(Core Concern)이 들어가 있는
 * Target 객체이다. 하지만 핵심적인 로직 사이에 부수적인 관심사(Cross Cutting Concern)
 * 가 산발적으로 들어있다. 그렇기에 OOP의 본질을 흐리고 있다.
 */
public class AopAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step01/prob.xml");
		
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