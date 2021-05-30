package api3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/*
 * 1. api 상속.. arround 방식의 어드바이스
 * 2. xml 사용.. aop 스키마는 사용 안함.. 직접 빈을 설정하겠다.
 * 3. pointcut의 표현식으로 JDK 정규식을 사용함.
 * 	  pointcut의 표현식 :: 
 * 		1) JDK 정규식
 * 		2) Aspect-J 표현식
 */
public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG]Method : " + methodName + "is Calling");
		Object rtnObj = invocation.proceed();
		
		//
		sw.stop();
		System.out.println("[LOG]Method : " + methodName + "was Called");
		System.out.println("[LOG 처리시간] : " + sw.getTotalTimeMillis()/1000 + "초");
		return rtnObj;
	}
}
