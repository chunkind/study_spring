package step12anno.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import step12anno.Dao;

public class PojoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("step12anno/pojo.xml");
		Dao dao = (Dao)factory.getBean("target");
		
		dao.updateMember();
		System.out.println("===Around Advice Test=====");
		System.out.println(dao.re());
		
		System.out.println("===Around Advice Test=====");
		dao.findId();
	} 
}
