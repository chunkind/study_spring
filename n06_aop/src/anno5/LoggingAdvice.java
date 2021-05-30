package anno5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAdvice{
	
	@Around("execution(void say*(..))")
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
