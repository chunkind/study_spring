package client;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.MySawonVO;
import config.FactoryService;

public class AllSawonListTest {
	public static void main(String[] args) {
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();
		
		List<MySawonVO> list = session.selectList("sel");
		
		for(MySawonVO v : list){
			System.out.println("이름 : " +v.getName() + ", 번호 :" + v.getNum());
		}
	}
}
