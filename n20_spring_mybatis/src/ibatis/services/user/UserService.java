package ibatis.services.user;

import ibatis.services.domain.User;

import java.util.List;

// getUser() / getUserList()
// removeUser()
public interface UserService {
	public void addUser(User user) throws Exception;
	public void updateUser(User user) throws Exception;
	public User getUser(String userId) throws Exception;
	public List<User> getUserList(User user) throws Exception;
}
