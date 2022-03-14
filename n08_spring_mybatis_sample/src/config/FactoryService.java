package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory를 하나 리턴받아온다..
public class FactoryService {
	private static SqlSessionFactory factory;
	static{
		try{
			Reader r = Resources.getResourceAsReader("config/sqlConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			}catch(Exception e){
				e.printStackTrace();
			}
		}//static
	public static SqlSessionFactory getFactory(){
		return factory;
	}
}
