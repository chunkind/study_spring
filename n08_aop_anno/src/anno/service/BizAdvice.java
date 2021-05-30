package anno.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * Advice 유형 :
 * POJO
 * xml사용.. (aop스키마..<aop:config>)
 * Annotation..
 * Aspect-J	/ execution()
 * Aspect-J :: pointCut의 조건
 * anno 패키지 이하의 모든 패키지에 있는 ..
 * BizService로 시작하는 클래스..에 있는 메소드..
 * 메소드의 인자값은 0개 이상.
 * anno1.xml
 */
@Aspect
public class BizAdvice {
	@Before("execution(void anno..BizService.*(..))")
	public void beforeMethod(JoinPoint jp) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Target Method Name :: [" + jp.getSignature().getName() + "]");
		System.out.println("Target Class Name :: [" + jp.getTarget().getClass() + "]");
		System.out.println("Today is : " + f.format(new Date()));
		
	}
}
