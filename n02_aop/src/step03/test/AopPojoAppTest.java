package step03.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.MemberService;
import step03.ProductService;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * xml로 생성..
 * 
 * MemberService, ProductService 는 비지니스 로직(Core Concern)이 들어가 있는
 * Target 객체이다. 하지만 핵심적인 로직 사이에 부수적인 관심사(Cross Cutting Concern)
 * 가 산발적으로 들어있다. 그렇기에 OOP의 본질을 흐리고 있다.
 * 
 * ::
 * 
 * 헤결책
 * Target은 OOP에 알맞게 핵심로직만 남기고
 * 부수적인 로직은 별도의 클래스로 가져가도록 한다.
 * Advice 클래스..ServiceAdvice로 작성
 */
public class AopPojoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step03/aop.xml");
		
		MemberService mem = (MemberService)factory.getBean("member");
		ProductService pro = (ProductService)factory.getBean("product");
		
		mem.register();
		mem.findMember("pojo");
		System.out.println("=================================");
		pro.deleteProduct();
		pro.updateProduct("aop");
	}
}