package step03.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.User;

/*
 * FileName : UserTestApp03.java
 */
public class UserTestApp03 {
	
	///Main Method
	public static void main(String[] args){
	
		//1. ApplicatiContext 이용 xml 에 선언적,서술적 기술된 instance 생성 및 의존성주입
		ApplicationContext factory = new ClassPathXmlApplicationContext("step03/userservice03.xml");

		//2. Container 로 부터 각각의 id 를 갖는 instance Look Up 
		//	- Dependency Lookup / Dependency Injection 확인...
		System.out.println("\n======================================================");
		User user08 = (User)factory.getBean("user08");
		System.out.println(user08);
		
		System.out.println("\n======================================================"); 
		User user09 = (User)factory.getBean("user09");
		System.out.println(user09);
		
		System.out.println("\n======================================================");
		User user10 = (User)factory.getBean("user10");
		System.out.println(user10);
		
		System.out.println("\n======================================================");
		User user12 = (User)factory.getBean("user12");
		System.out.println(user12);

	}
}