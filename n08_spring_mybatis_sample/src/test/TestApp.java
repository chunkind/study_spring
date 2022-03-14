package test;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import config.FactoryService;
import vo.MySawonVO;

public class TestApp {
	public static void main(String[] args) {
//		insertSawon();
		selectAllSawon();
	}

	private static void insertSawon() {
		Scanner sc = new Scanner(System.in);
		MySawonVO vo = new MySawonVO();
		
		//원래는 폼으로 값을 입력받아야 하는데.. 없는 관계로 키보드로 입력받도록..
		System.out.println("아이디 : ");
		vo.setId(sc.nextLine());

		System.out.println("비밀번호 : ");
		vo.setPwd(sc.nextLine());
		
		System.out.println("이름 : ");
		vo.setName(sc.nextLine());
		
		System.out.println("나이 : ");
		vo.setAge(sc.nextInt());
		
		try{
			//1. sqlConfig.xml을 읽어들인다..Reader를 반환받는다.
			Reader r = Resources.getResourceAsReader("config/sqlConfig.xml");
			
			//2. SqlSessionFactory를 리턴받는다.
			SqlSessionFactory factroy = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession을 리턴받는다.
			SqlSession session = factroy.openSession();
			
			//4. Query문 수행..
			int result = session.insert("ins", vo);
			
			//5. 반드시 추가..
			session.commit();
			session.close();
			System.out.println(result + "명이 추가되었습니다..");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void selectAllSawon() {
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();
		
		List<MySawonVO> list = session.selectList("sel");
		
		for(MySawonVO v : list){
			System.out.println("이름 : " +v.getName() + ", 번호 :" + v.getNum());
		}
	}
}
