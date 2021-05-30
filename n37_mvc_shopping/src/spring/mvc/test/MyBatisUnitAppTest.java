package spring.mvc.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.mvc.shopping.model.Item;
import spring.mvc.shopping.model.impl.ItemDaoImpl;

public class MyBatisUnitAppTest {
	public static void main(String[] args) throws Exception {
		Reader reader = Resources.getResourceAsReader("conf/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		ItemDaoImpl idao = new ItemDaoImpl();
		idao.setSqlSession(session);
		List<Item> list = idao.findAll();
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
