package step07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice{
	public void timeLog(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG]Method : " + methodName + " is Calling");
		joinPoint.proceed();
		sw.stop();
		System.out.println("[LOG]Method : " + methodName + " was Called");
		System.out.println("[LOG 처리시간] : " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
