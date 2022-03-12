package step02.test;

import org.springframework.aop.framework.ProxyFactoryBean;

import step02.MemberService;
import step02.ProductService;
import step02.ServiceAdvice;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * Advice 객체를 다루기 위해서는
 * target, advice, Proxy 개념을 잘 알아야 한다.
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
 * 
 * Target 객체에 혼제되어 있던 부수적인 관심사들만 별도로 모아놓은 어드바이스
 * 어드바이스 객체를 작성하는 방법 
 * ::
 * 1. api를 상속받아서 작성
 * 2. POJO 기반으로 작성
 * --> POJO : (Plain Old Java Object) : 어떤곳으로(EX)클래스)부터 제약받지않았다.(상속받지않았다))
 * 일단 어드바이스로부터 상속받아서 하나 작성 어드바이스는 인터셉터 개념이다.
 * lib를 추가해야 한다.
 * 1 ) aop / aspect / (*)dependency > org.aopalliance
 *  
 * ServiceAdvice :
 * api를 상속 + xml 빈 설정문서 사용안함.
 * --> 가장 원시적으로 작성..
 */
public class AopAdviceAppTest {
	public static void main(String[] args) {
		//target, advice, proxy(대리자)를 생성
		MemberService memberService = new MemberService();
		ProductService productService = new ProductService();
		
		ServiceAdvice advice = new ServiceAdvice();
		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		pfBean.setTarget(memberService);
		pfBean.addAdvice(advice);
		
		MemberService mpf= (MemberService)pfBean.getObject();
		
		mpf.register();
		mpf.findMember("aop1");
		
		System.out.println("===============================");
		
		mpf.register();
		mpf.findMember("aop2");
	}
}
