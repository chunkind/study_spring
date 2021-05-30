package log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/*
 * 우리는 이제까지 작성한 어플리케이션의 로직이 잘 실행되는지를 확인하기 위해서 
 * 콘솔로 일일히 출력하는 코드를 빠짐없이 작성해서 넣었다.
 * 일종의 테스트용 출력 코드였고 이것은 매번 메소드마다 빠지지 않고 들어갔다.
 * 
 * 현업에서는 System.out.println()이란 코드 대신에 Log 파일로 출력
 * ::
 * Log 파일로 출력을 하려면 
 * 1.LogFactory를 하나 생성해야한다.
 * 		--> Library 가 하나 더 추가되어져야 한다.
 * 2.Log 파일을 사용하는 방법에는 여러가지가 있다
 *   	--> 그 중에서 현업에서 가장 많이 사용하는 log4 파일을 이용 
 * 3.log4 파일을 사용하면 Log에 대한 정보를 레벨별로 구분해서 볼 수 있다..
 * trace>debug>info>warn>error>fatal
 *  
 * 4. log4j 파일릐 저장위치 
 * 	--> server 상 : WEB - INF > classes  바로 아래. 
 *  --> eclipse 상 : src 바로 밑  
 */
public class LogService {
	private Log log = LogFactory.getLog(getClass());
	
	public void testLogging(){
		//레벨별로 메세지를 출력...
		log.trace("trace...message....");
		log.debug("debug...message....");
		log.fatal("fatal...message....");
		log.error("error...message....");
		log.info("info...message....");
		log.warn("warn...message....");
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
