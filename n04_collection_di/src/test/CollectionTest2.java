package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import collection2.Company;
import collection2.Employee;


public class CollectionTest2 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("collection2/collection2.xml");
		
		Company com = factory.getBean("company", Company.class);
		
		List<Employee> list = com.getAllEmployee();
		
		for(Employee e : list)
			System.out.println(e);
	}
}
















