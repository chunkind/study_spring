package spring.service.user.impl;

import java.util.Map;

import spring.service.user.SqlService;

/*
 * sqlCode만 관리하는 컴포넌트빈..!DaoImpl06으로 주입
 */
public class SqlServiceImpl06 implements SqlService{
	
	private Map<String, String> sqlMap;
	
	public void setSqlMap(Map<String, String> sqlMap) {
		System.out.println("::" + getClass().getName() + ".setSqlMap() call..");
		this.sqlMap = sqlMap;
	}

	@Override
	public String getSql(String key) throws Exception {
		String sql = sqlMap.get(key);
		if(sql==null) throw new Exception();
		else return sql;
	}
}