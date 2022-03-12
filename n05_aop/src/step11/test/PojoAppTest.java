package step11.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import step11.Dao;

public class PojoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("step11/pojo.xml");
		Dao dao = (Dao)factory.getBean("target");
		dao.register();
		System.out.println("**********************************");
		System.out.println(dao.re());
		
		System.out.println("**********************************");
		System.out.println(dao.findId());
		
	}
}
