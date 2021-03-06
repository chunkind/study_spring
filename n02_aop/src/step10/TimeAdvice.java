package step10;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 1) pojo
 * 2) xml 사용..aop 스키마 적용
 * 3) around 방식
 */
public class TimeAdvice {
	public void time(ProceedingJoinPoint pjp) throws Throwable{
		//target 메소드 호출 전.. 수행
		long start = System.currentTimeMillis();
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName + "method start 시각 :: " + start);
		
		Object retobj = pjp.proceed();
		
		//target 메소드 호출 후.. 수행
		long end = System.currentTimeMillis();
		System.out.println(methodName + "method start 시각 :: " + end);
		
		// 소요시각
		System.out.println(methodName + " 메소드가 총 소요된 시각 :: " + (end-start)/1000 + "초");
	}
}
