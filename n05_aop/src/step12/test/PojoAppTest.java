package step12.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import step12.Dao;

public class PojoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("step12/pojo.xml");
		Dao dao = (Dao)factory.getBean("target");
		
		dao.updateMember();
	}
}
