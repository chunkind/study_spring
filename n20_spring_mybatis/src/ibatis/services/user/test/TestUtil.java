package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory를 리턴받는 기능을 작성..
public class TestUtil {
	public static void printList(List<User> list){
		for(int i=0; i<list.size(); i++){
			System.out.println("<"+(i+1)+"> 번째 회원.." + list.get(i));
		}
		System.out.println("\n");
	}//printList
	
	public static SqlSessionFactory getSqlSessionFactory() throws Exception{
		Reader reader = Resources.getResourceAsReader("sql/SqlMapConfig01.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		return factory;
	}
}
