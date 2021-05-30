package ibatis.services.impl;

import java.util.List;

import javax.annotation.Resource;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
/*
 * Annotation 기반으로 작성..
 * Component는 Layer 별로 세분화 되어진다.
 * @Component >
 * 				@Repository
 * 				@Service
 * 				@Controller
 */
@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{
	//주입받는 객체..
	
	@Resource
	private SqlSession sqlSession;

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert("User10.addUser", user);
		//sqlSession.commit();	// commit 반드시!
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("User10.updateUser", user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete("User10.removeUser", userId);
		//sqlSession.commit();
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
