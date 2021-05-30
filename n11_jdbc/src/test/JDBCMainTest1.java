package test;
/*
 * 기존의 JDBC ::
 * 1) Connection, PreparedStatement, 바인딩, ResultSet의 next()호출
 * 	  이 모든 것들이 자동적으로 진행된다.
 * 2) 자원을(Connection) 열어서 썼으면 반드시 닫아주는 기능을 모든 비지니스 로직 마다
 * 	  일일이 해줘야 했었다..close()가 내장 되어져 있다.
 * 3) DriverManager / DataSource 방식이건 동일한 방법으로 빈 설정이 가능하다.
 */
import java.util.List;

import jdbc.MemberDao;
import jdbc.MemberVO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCMainTest1 {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("jdbc/jdbc.xml");
		MemberDao dao = factory.getBean("memberDaoImpl", MemberDao.class);
		
		// 현재는 html 폼이 없기 때문에 값을 받아올 수 없다.
		// 그냥 받아왔다 치고 vo에 직접 세팅하자.
//		MemberVO vo = new MemberVO("CMJ", "최잼", "222", "부천");
//		dao.register(vo);
//		System.out.println("register..vo.. OK!");
		System.out.println("=========getList()=========");
		List<MemberVO> retList = dao.getList();
		for(MemberVO v : retList) {
			System.out.println(v);
			
		}
		System.out.println("=========getList()=========");
		System.out.println(dao.getSearch("CMJ"));
	}
}
