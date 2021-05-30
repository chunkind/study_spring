package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pojo1.Dao;

public class PojoAppTest1 {
	public static void main(String[] args) {
/*		ApplicationContext factory = new ClassPathXmlApplicationContext("pojo1.xml");*/
		ApplicationContext factory = new GenericXmlApplicationContext("pojo1.xml");
		
		Dao dao = (Dao)factory.getBean("target");
		dao.register();
				
	}
}
