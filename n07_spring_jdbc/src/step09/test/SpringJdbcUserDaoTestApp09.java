package step09.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step09.User;
import step09.dao.UserDao;
import step09.service.UserService;

/*
 * FileName : SpringJdbcUserDaoTestApp07.java
 */
public class SpringJdbcUserDaoTestApp09 {
	///Main Method
	public static void main(String[] args) throws Exception{

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {	"step09/config/datasourceservice.xml",
								"step09/config/userservice.xml"	 } 
							  );
		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		UserService userService = (UserService)context.getBean("springUserServiceImpl");
		
		User user = new User("user04","주몽","user04",40);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//1.UserService.addUser(user) Test
		System.out.println(":: 1. add(INSERT)  ? ");
		userService.addUser(user);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//2.UserService.getUser(userId) Test
		user = userService.getUser("user04");
		System.out.println(":: 2. get(SELECT)  ? "+user);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//3.UserService.uadateUser(user) Test
		user.setUserName("장보고");
		System.out.println(":: 3. update(UPDATE)  ? ");
		userService.updateUser(user);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//4.UserService.getUser(userId) Test
		user = userService.getUser("user04");
		System.out.println(":: 4. get(SELECT)  ? "+user);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//5.UserDAO.removeUser(userId) Test
		//==> UserService 에는 removeUser가 없으므로, DAO에서 직접 호출 Test
		UserDao userDAO = (UserDao)context.getBean("springJdbcUserDaoImpl");
		System.out.println(":: 5. remove(DELETE)  ? "+userDAO.removeUser("user04"));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//6.UserService.getUserList() Test
		System.out.println(":: 6. all User(SELECT)  ? ");
		List<User> list = userService.getUserList(new User());
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	}
}//end of class