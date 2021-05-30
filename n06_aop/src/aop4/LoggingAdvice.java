package aop4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/*
 * 1. pojo.. arround 방식의 어드바이스.timeLog()
 * 2. xml 사용.. aop 스키마 사용
 * 3. pointcut의 표현식으로 JDK 정규식을 사용함.
 * 	  pointcut의 표현식 :: within 사용
 */
public class LoggingAdvice{
	public void timeLog(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG]Method : " + methodName + " is Calling");
		pjp.proceed();
		//
		sw.stop();
		System.out.println("[LOG]Method : " + methodName + " was Called");
		System.out.println("[LOG 처리시간] : " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
