package step01.test;

import java.util.List;

import step01.User;
import step01.dao.UserDao;
import step01.dao.impl.JdbcUserDaoImpl;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 14.
 * @Memo -
 * FileName : JdbcUserDaoImpl.java  ( Data Access Object ) 
 * :: Persistence(?) Layer 인터페이스 구현 한 RDBMS(관계형 데이터베이스 관리 시스템) 와의  CRUD 구현 클래스
 *    
 *  [[ 아래의 사항을 고려하여 살펴보면...]]  
 * * 각 Method 의 반복적( 고정적(?) ) 인 부분은 ?...공통 기능으로 뽑아낸다..
 * * 각 Method 의  가변적인 부분은 ? ...>conn, preparesStatement,바인딩, rs.next(), 
 * * SQLException이 발생한다면, 대응방법은 ?
 * - Connection 인스턴스 생성시 SQLException이 발생 한다면 이후 진행가능한가
 * - SQLException 발생은 Checked Exception 으로 반드시 try-catch 
 * ::  복구 불가능한 SQLException 으로 인해 try-catch 를 반드시 기술해야한다.
 */
public class JdbcUserDaoTestApp {
	public static void  main(String[] args) throws Exception {
		UserDao userDao = new JdbcUserDaoImpl();		
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