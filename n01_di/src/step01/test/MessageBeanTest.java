package step01.test;

import step01.MessageBeanEn;
import step01.MessageBeanKr;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * step 1
 * 영어로 "Hello Spring!" 출력.
 * 한글로 "안녕 스프링!" 출력.
 * 
 * step 2
 * Spring, 스프링을 => Java, 자바 로 바꾸러면?
 * intro() 메서드는 실객체를 바꿔야 한다.
 * 하지만 intro2 처럼 구현하면 실객체를 바꿔야 하는 수고는 줄어든다.
 */
public class MessageBeanTest {
	public static void main(String[] args) {
		
		//객체 생성
		MessageBeanEn enBean = new MessageBeanEn();
		MessageBeanKr krBean = new MessageBeanKr();
		
		//step 1
		enBean.intro();
		krBean.intro();
		
		//step 2
		enBean.intro2("Spring!");
		krBean.intro2("스프링!");
		
		enBean.intro2("Java!");
		krBean.intro2("자바!");
	}
}