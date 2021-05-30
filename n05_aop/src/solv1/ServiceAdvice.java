package solv1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/*
 * Target 객체에 혼제되어 있던 부수적인 관심사들만 별도로 모아놓은 어드바이스
 * 어드바이스 객체를 작성하는 방법 
 * ::
 * 1. api를 상속받아서 작성
 * 2. POJO 기반으로 작성
      --> POJO : (Plain Old Java Object) : 어떤곳으로(EX)클래스)부터 제약받지않았다.(상속받지않았다))
   ::
   일단 어드바이스로부터 상속받아서 하나 작성
   어드바이스는 인터셉터 개념이다.
   
   ::
   
   lib를 추가해야 한다.
   1 ) aop / aspect / (*)dependency > org.aopalliance
   
   ::
   ServiceAdvice :
   api를 상속 + xml 빈 설정문서 사용안함.
   --> 가장 원시적으로 작성..
 */
public class ServiceAdvice implements MethodInterceptor{
	private Log log = LogFactory.getLog(getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("check before info()");
		Object obj = invocation.proceed(); // proceed() 전후로
		System.out.println(obj);
		
		System.out.println("check after info()");
		return obj;
	}
	
}
