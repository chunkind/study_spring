package step04;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

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