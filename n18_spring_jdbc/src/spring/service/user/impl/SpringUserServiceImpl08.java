package spring.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.service.domain.User;
import spring.service.user.UserDao;
import spring.service.user.UserService;

@Component
public class SpringUserServiceImpl08 implements UserService{
	@Resource
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
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
