package spring.service.user;
//sql Code를 관리하는 인터페이스..
public interface SqlService {
	public String getSql(String key)throws Exception;
}
