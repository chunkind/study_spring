package solv2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * Advice 유형 ::
 * 1) POJO(상속받거나 제약 받는게 없는것), lib를 하나 더 추가!!
 * 2) xml 설정문서 사용 한다.
 */
public class ServiceAdvice {
	private Log log = LogFactory.getLog(getClass());
	
	//POJO기반의 어드바이스 유형은 인자값이 결정한다.
	//ProceedingJoinPoint : ARROUND 방식.
	//JoinPoint :: ARROUND 이외 방식.
	public void logPush(ProceedingJoinPoint pjp) throws Throwable {
		log.info("check..aop..before");
		pjp.proceed();	//target의 메소드가 호출되면 이쪽에서 target의 메소드를 가로챈다.
		log.info("check..aop..after");
	}
}
