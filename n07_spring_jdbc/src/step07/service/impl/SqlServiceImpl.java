package step07.service.impl;

import java.util.Map;

import step07.service.SqlService;

public class SqlServiceImpl implements SqlService{
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
