package pojo4_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class BeforeAdvice {
	@Before("execution(* pojo4_anno..update*(..))")
	public void beforeMethod(JoinPoint jp) {
		String tcmName = jp.getSignature().getName();
		String tcName = jp.getTarget().getClass().getName();
		
		System.out.println("TargetMethod Name :: " + tcmName);
		System.out.println("TargetClass Name :: " + tcName);
	}
}
