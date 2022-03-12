package step07.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step07.MessageBean;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 13.
 * @Memo -
 * 1. pojo.. arround 방식의 어드바이스.timeLog()
 * 2. xml 사용.. aop 스키마 사용
 * 3. pointcut의 표현식으로 JDK 정규식을 사용함.
 * 	  pointcut의 표현식 :: within 사용
 */
public class AopAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step07/aop.xml");
		MessageBean bean = (MessageBean)factory.getBean("target");
		bean.sayHello();
	}
}