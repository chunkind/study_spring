package step10anno.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import step10anno.Dao;

public class PojoAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("step10anno/pojo.xml");
		Dao dao = (Dao)factory.getBean("dao");
		dao.register();
		System.out.println(dao.getDataSource());
	}
}