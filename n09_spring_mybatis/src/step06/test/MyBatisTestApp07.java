package step06.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import step06.TestUtil;
import step06.User;
/*
 * FileName : MyBatisTestApp07.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping07.xml
  * ㅇ MyBATIS Framework 이용 Dynamic query ( SELECT ) TEST
  * ㅇ TestUtil.java 을 이용 Test . 
  */
public class MyBatisTestApp07 {
	///Main method
		public static void main(String[] args) throws Exception{
			SqlSession session = null;
			
			//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
			SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
			session=factory.openSession();
			
			//==> Test 용 UserVO instance 생성  
			User user = new User("user01","홍길동","user01",new Integer(30),1);
		
			//1. User07.getUserList01 Test 
			System.out.println(":: 1. getUserList01(SELECT)  ? ");
			TestUtil.printList((List)session.selectList("User07.getUserList01",user));
			
			//2. User07.getUserList01 Test 
			System.out.println(":: 2. getUserList01(SELECT)  ? ");
			user.setUserName(null);
			TestUtil.printList((List)session.selectList("User07.getUserList01",user) );
			
			//3. User07.getUserList01 Test 
			System.out.println(":: 3. getUserList01(SELECT)  ? ");
			user.setUserName("홍길동");
			user.setAge(null);
			TestUtil.printList((List)session.selectList("User07.getUserList01",user) );
			
			//4. User07.getUserList01 Test ..이경우는 조건을 안준거와 동일한 결과가 나온다..
			System.out.println(":: 4. getUserList01(SELECT)  ? ");
			user.setUserName(null);
			user.setAge(null);
			TestUtil.printList((List)session.selectList("User07.getUserList01",user) );
		
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("\n==================================\n");
			/*//==> Test 용 UserVO instance 생성 및 age / regData null setting
			user = new User("user04","주몽","user04",null,1);
			user.setRegDate(null);
			
			//0. User05.addUser Test  :: users table age/grade/redDate 입력값 확인할것 : OK 
			System.out.println(":: 0. addUser(INSERT)  ? "
										+ session.insert("User05.addUser",user));//1.
										  session.commit();
		*/
		}//end of main
	}//end of class