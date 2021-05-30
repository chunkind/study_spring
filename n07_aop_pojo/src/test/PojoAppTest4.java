package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pojo4.Dao;

public class PojoAppTest4 {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("pojo4.xml");
		Dao dao = (Dao)factory.getBean("target");
		
		dao.updateMember();
	}
}
