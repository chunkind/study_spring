package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pojo2_anno.Dao;


public class PojoAppTest2_anno {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("pojo2_anno.xml");
		Dao dao = (Dao)factory.getBean("target");
		dao.register();

		// 추가
		System.out.println(dao.getDataSource());
	}
}
