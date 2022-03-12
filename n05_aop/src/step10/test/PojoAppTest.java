package step10.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import step10.Dao;

public class PojoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("step10/pojo.xml");
		Dao dao = (Dao)factory.getBean("target");
		dao.register();
		System.out.println(dao.getDataSource());
	}
}