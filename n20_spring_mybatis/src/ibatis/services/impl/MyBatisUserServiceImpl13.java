package ibatis.services.impl;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;
import ibatis.services.user.UserService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl13 implements UserService{
	
	@Resource
	private UserDAO userDAO;
	
	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
	}

	@Override
	public User getUser(String userId) throws Exception {

		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {

		return userDAO.getUserList(user);
	}
}
