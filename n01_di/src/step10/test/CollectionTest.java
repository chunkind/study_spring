package step10.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step10.Company;
import step10.Employee;


/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * collection list 예제
 */
public class CollectionTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step10/collection.xml");
		
		Company com = factory.getBean("company", Company.class);
		
		List<Employee> list = com.getAllEmployee();
		
		for(Employee e : list)
			System.out.println(e);
	}
}