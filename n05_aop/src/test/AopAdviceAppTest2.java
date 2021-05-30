package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import solv1.MemberService;
import solv1.ProductService;
import solv1.ServiceAdvice;

/*
 * Advice 객체를 다루기 위해서는
 * target, advice, Proxy 개념을 잘 알아야 한다.
 */
public class AopAdviceAppTest2 {
	public static void main(String[] args) {
		//target, advice, proxy(대리자)를 생성
		MemberService mem = new MemberService();
		ProductService pro = new ProductService();
		
		ServiceAdvice advice = new ServiceAdvice();
		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		pfBean.setTarget(mem);
		pfBean.addAdvice(advice);
		
		MemberService mpf= (MemberService)pfBean.getObject();
		
		mpf.register();
		mpf.findMember("aop1");
		
		System.out.println("===============================");
		
		mpf.register();
		mpf.findMember("aop2");
	}
}
