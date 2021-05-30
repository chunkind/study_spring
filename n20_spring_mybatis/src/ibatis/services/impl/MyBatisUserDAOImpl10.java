package ibatis.services.impl;

import java.util.List;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

import org.apache.ibatis.session.SqlSession;

public class MyBatisUserDAOImpl10 implements UserDAO{
	//주입받는 객체..
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" + getClass().getName()+ ".setSqlSession() call..");
		this.sqlSession = sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert("User10.addUser", user);
		sqlSession.commit();	// commit 반드시!
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("User10.updateUser", user);
		sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete("User10.removeUser", userId);
		sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {

		return sqlSession.selectOne("User10.getUser", userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		
		return sqlSession.selectList("User10.getUserList", user);
	}
}
