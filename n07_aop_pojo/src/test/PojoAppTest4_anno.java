package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pojo4_anno.Dao;

public class PojoAppTest4_anno {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("pojo4_anno.xml");
		Dao dao = (Dao)factory.getBean("target");
		
		dao.updateMember();
		System.out.println("===Around Advice Test=====");
		System.out.println(dao.re());
		
		System.out.println("===Around Advice Test=====");
		dao.findId();
	} 
}
