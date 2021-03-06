package step11.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step11.Bus;
import step11.PrivateSchool;

public class CollectionTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step11/collection.xml");
		
		Bus bus1 = factory.getBean("bus1", Bus.class);
		System.out.println(bus1);
		
		PrivateSchool privateSchool = factory.getBean("school", PrivateSchool.class);
		ArrayList<String> stuNames = privateSchool.getStuNames();
		
		for(String names : stuNames){
			System.out.println("학생들 이름 :: " + names);
		}
		
		System.out.println("//////////////////////////////////////////");
		
		ArrayList<Bus> busList = privateSchool.getBusList();
		for(Bus b : busList){
			System.out.println(b);
		}
		
		System.out.println("/////////////////////////////////////////");
		Map<String, Bus> map = privateSchool.getBusMap();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			Bus bus = map.get(key);
			System.out.println("key : " + key + " :: value :: " + bus);
		}
	}
}