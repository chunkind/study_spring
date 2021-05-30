package api1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
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
public class MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("1. 비지니스 로직 호출 전 수행됨..");
		
		Object obj = invocation.proceed();	// target의 메소드가 이부분에서 작동됨..
		if(obj != null){
			System.out.println("리턴된 obj값 ::" + obj);
		}
		
		System.out.println("2. 비지니스 로직 수행 후..");
		
		return obj;
	}
}