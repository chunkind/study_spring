package kosta.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/*
 * POJO기반의 어드바이스.. Before 유형의 어드바이스
 * target의 비지니스 로직이 호출될때 target 메소드의 인자값을 체킹하는 어드바이스를 작성
 * parameter를 체킹했는데 문제가 있다.. --> null이 리턴된다.
 * log4 파일의 warn에 걸리도록..
 */
public class ParamAdvice {
	private Log log = LogFactory.getLog(getClass());
	
	public void checkParam(JoinPoint jp) {
		// jp를 사용해서 target의 메소드 인자값을 받아온다.
		Object[ ] obj = jp.getArgs();
		// 인자값이 안들어갔거나 잘못들어갔을때..를 로직으로 작성.
		for(int i = 0; i < obj.length; i ++) {
			if(obj[i] == null || obj[i].equals("")) {
				String tcName = jp.getTarget().getClass().getName();
				String tmName = jp.getSignature().getName();
				
				log.warn(tcName + "클래스의" + tmName + "()의 인자값이 부적절합니다.."); 
			}
		}
	}
}
