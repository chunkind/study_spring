package step09.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import step09.Dao;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 13.
 * @Memo -
 * 1) pojo
 * 2) xml 사용..aop 스키마 적용
 * 3) around 방식
 */
public class PojoAppTest {
	public static void main(String[] args) {
//		ApplicationContext factory = new ClassPathXmlApplicationContext("step09/pojo.xml");
		ApplicationContext factory = new GenericXmlApplicationContext("step09/pojo.xml");
		Dao dao = (Dao)factory.getBean("target");
		dao.register();
	}
}