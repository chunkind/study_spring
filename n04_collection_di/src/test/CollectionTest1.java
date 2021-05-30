package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import collection1.Book;
import collection1.Owner;
import collection1.Student;

public class CollectionTest1 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("collection1/collection1.xml");
		
		Student stu = factory.getBean("stu", Student.class);
		Owner owner = factory.getBean("owner", Owner.class);
		
		System.out.println("Student Id :: "+stu.getStuId());
		
		List<Book> books=stu.getBooks();
		for(Book book : books){
			System.out.println(book.getTitle()+"\n");
		}
	}
}









