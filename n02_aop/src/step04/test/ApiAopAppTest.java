package step04.test;

import org.springframework.aop.framework.ProxyFactoryBean;

import step04.Message;
import step04.MessageAdvice;
import step04.MessageImpl;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * Advice 유형 ::
 * 1) api 상속..MethodInterceptor를 상속
 * 2) xml을 사용하지 않겠다.
 * ::
 * MethodInterceptor를 상속받으면 invoke()를 오버라이딩 해야 한다.
 * <<invoke() 의 작동원리>>
 * 1. invoke()의 인자값으로 MethodInvocation이 들어가 있다.
 * 	  MethodInvocation의 부모가 Invocation > JoinPoint
 * 	  JoinPoint에 proceed()가 있다.
 * 	  proceed()의 동작 원리가 가장 중요한 원리가 된다.
 * 2. proceed()의 호출 시점
 * 	  :
 * 	  target의 B.L()이 호출될때 이를 인터셉터인 어드바이스가 가로채어서
 * 	  proceed()를 호출한다	-->	target의 B.L()이 동작됨	--> 결과값이 proceed()의
 * 	   리턴값으로 다시 반환된다.
 * 	  --> 이 모든 과정을 ProxyFactoryBean에서 이뤄진다.
 */
public class ApiAopAppTest {
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