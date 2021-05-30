package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pojo3.Dao;

public class PojoAppTest3 {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("pojo3.xml");
		Dao dao = (Dao)factory.getBean("target");
		dao.register();
		System.out.println("**********************************");
		System.out.println(dao.re());
		
		System.out.println("**********************************");
		System.out.println(dao.findId());
		
	}
}
