package spring.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.User;

public class UserTestApp02 {
	public static void main(String[] args) {
	/*
	 * 우리는 지금 여러개의 설정문서를 컨테이너에게 전달해야 한다.
	 * 하지만 컨테이너는 하나의 인자값만을 받을수 있는 구조이다.
	 * ::
	 * 설정문서를 통으로 전달 --> String [ ]
	 * 이것도 어떤 의미에서 wiring이다.
	 * 	
	 */
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext(
					new String[ ] {
					"config/userservice01.xml", 
					"config/userservice02.xml"
					}
					);
		
		System.out.println("\n=================================================");
		User user01 = (User)factory.getBean("user05");
		System.out.println(user01);
		
		System.out.println("\n=================================================");
		User user02 = (User)factory.getBean("user06");
		System.out.println(user02);
		
		System.out.println("\n=================================================");
		User user03 = (User)factory.getBean("user07");
		System.out.println(user03);
		
		System.out.println("\n=================================================");
		User user04 = (User)factory.getBean("user08");
		System.out.println(user04);
		

	}

}
