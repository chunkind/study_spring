package pojo4;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeMethod(JoinPoint jp) {
		String tcmName = jp.getSignature().getName();
		String tcName = jp.getTarget().getClass().getName();
		
		System.out.println("TargetMethod Name :: " + tcmName);
		System.out.println("TargetClass Name :: " + tcName);
	}
}
