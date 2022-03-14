package step11.dao;

import java.util.List;

import step11.User;

public interface UserDAO {
	public int addUser(User user)throws Exception;
	public int updateUser(User user)throws Exception;
	public int removeUser(String userId)throws Exception;
	public User getUser(String userId)throws Exception;
	public List<User> getUserList(User user)throws Exception;
}
