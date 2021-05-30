package spring.service.user;

import java.util.List;

import spring.service.domain.User;

/*
 * Service Layer로 넘어온다.. 이제
 * Service Layer가 필요한 이유 ::
 * 디비로 부터 데이타를 얻어오고 (Model) 나서도 그 Model을 가지고 데이타를 변경, 혹은
 * 조작해야할 필요성이 있다.. Controller로 바로 넘어가는 것이 아니라 조작한 데이타를 
 * 넘겨야 할 경우가 있다는 것이다..
 * 대표적으로 페이징처리가 대표적이다..
 * 즉 가공된 데이타가 Controller를 거쳐서 ResultView 페이지로 넘겨진다.
 * ::
 * CRUD중 Service Layer와 가장 밀접한 연관이 있는 쿼리문은? R(Select)
 * CRUD중 Service Layer와 가장 연관이 없는 쿼리문은? D(Delete)
 */
//removeUser()는 제외하고 작성한다.
public interface UserService {
	public void addUser(User user) throws Exception;
	public User getUser(String userId) throws Exception;
	public void updateUser(User user) throws Exception;
	public List<User> getUserList(User user) throws Exception;
}
