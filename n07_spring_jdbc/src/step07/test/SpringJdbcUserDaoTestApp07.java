package step07.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step07.User;
import step07.dao.UserDao;

/*
 * FileName : SpringJdbcUserDaoTestApp01.java
 */
public class SpringJdbcUserDaoTestApp07 {
	///Main Method
	public static void main(String[] args) throws Exception{
		//우리는 설정문서를 모듈화
		//빈 컨테이너는 한 덩어리로 읽어들여야 하는 입장.
		ApplicationContext factory = new ClassPathXmlApplicationContext(
			new String[]{
				//auto wiring
				"step07/config/datasourceservice.xml",
				"step07/config/userservice.xml"
			}
		);
		
		UserDao userDao = (UserDao)factory.getBean("springJdbcUserDaoImpl");
		User user = new User("user04","주몽","user04",40);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//1.UserDao.addUser(user) Test
		System.out.println(":: 1. add(INSERT)  ? "+userDao.addUser(user));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//2.UserDao.getUser(userId) Test
		user = userDao.getUser("user04");
		System.out.println(":: 2. get(SELECT)  ? "+user);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//3.UserDao.uadateUser(user) Test
		user.setUserName("장보고");
		System.out.println(":: 3. update(UPDATE)  ? "+userDao.updateUser(user));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//4.UserDao.getUser(userId) Test
		user = userDao.getUser("user04");
		System.out.println(":: 4. get(SELECT)  ? "+user);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//5.UserDao.removeUser(userId) Test
		System.out.println(":: 5. remove(DELETE)  ? "+userDao.removeUser("user04"));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//6.UserDao.getUserList() Test
		System.out.println(":: 6. all User(SELECT)  ? ");
		List<User> list = userDao.getUserList();
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
	}
}