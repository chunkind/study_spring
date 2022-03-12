package step02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceAdvice implements MethodInterceptor{
	private Log log = LogFactory.getLog(getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("check before info()");
		Object obj = invocation.proceed(); // proceed() 전후로
		if(null == obj) {
			System.out.println("리턴되는 값이 없습니다..");
		} else {
			System.out.println("리턴되는 값:" + obj);
		}
		
		System.out.println("check after info()");
		return obj;
	}
}