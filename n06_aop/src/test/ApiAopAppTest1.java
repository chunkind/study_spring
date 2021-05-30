package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import api1.Message;
import api1.MessageAdvice;
import api1.MessageImpl;

public class ApiAopAppTest1 {
	public static void main(String[] args) {
		// 1. target, advice, pfBean을 각각 생성
		Message target = new MessageImpl();
		MessageAdvice advice = new MessageAdvice();
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		// 2. target, advice를 pfBean에 주입
		pfBean.setTarget(target);
		pfBean.addAdvice(advice);
		// 3. pfBean에서 target을 하나 꺼내 온다.. 이름을 pfTarget으로 할당
		Message pfTarget = (Message)pfBean.getObject();
		// 4. pfTarget을 BL()을 호출해서 advice가 적용되었는지를 확인..
		pfTarget.print();	//aop가 적용됨..
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		target.print();	//aop가 적용되지 않는 것을 확인.
		/*
		 * AOP 프레임워크는 Proxy에서 철저하게 들어간다는 것을 반드시 기억하자!
		 */
	}
}