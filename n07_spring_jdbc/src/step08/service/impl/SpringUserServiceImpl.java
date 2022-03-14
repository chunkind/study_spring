package step08.service.impl;

import java.util.List;

import step08.User;
import step08.dao.UserDao;
import step08.service.UserService;

public class SpringUserServiceImpl implements UserService{
//di
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		System.out.println("::" + getClass().getName()+ ".setUserDao() call..");
		this.userDao = userDao;
	}
	@Override
	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public User getUser(String userId) throws Exception {
		
		return userDao.getUser(userId);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		
		return userDao.getUserList();
	}
}
