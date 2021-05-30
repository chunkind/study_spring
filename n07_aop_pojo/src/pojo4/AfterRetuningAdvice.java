package pojo4;

import org.aspectj.lang.JoinPoint;

/*
 * Advice 유형 ::
 * 1) POJO
 * 2) AfterReturning 방식
 * 3) 인자값으로 JoinPoint..얘는 aspectJ 에서 제공한다.
 * ::
 * MethodInvocation > Invocation > JoinPoint..proceed()가 있었다..aopalliance
 */
public class AfterRetuningAdvice {
	//ret: target의 BL()이 수행된 후 리턴된 결과값.
	public void afterMethod(JoinPoint jp, Object ret) throws Throwable{
		String tcname = jp.getSignature().getName();
		System.out.println("target의 메소드명 :: " + tcname + ", ret :: " + ret);
	}
}

/*
 * String methodName = invocation.getMethod().getName();
 * String methodName = pjp.getSignature().getName()
 */