package step09.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step09.Book;
import step09.Owner;
import step09.Student;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 
 * Collection list 예제
 */
public class CollectionTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step09/collection.xml");
		
		Student stu = factory.getBean("stu", Student.class);
		Owner owner = factory.getBean("owner", Owner.class);
		
		System.out.println("Student Id :: "+stu.getStuId());
		
		List<Book> books=stu.getBooks();
		for(Book book : books){
			System.out.println(book.getTitle()+"\n");
		}
	}
}