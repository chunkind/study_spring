package step02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 비지니스 로직이 있는 MemberService
 */
public class MemberService {
	private Log log = LogFactory.getLog(getClass());
	
	public String register(){
//		System.out.println("회원으로 등록되었습니다.");
		log.info("회원으로 등록되었습니다.");
		return "register()..";
	}
	
	public void findMember(String id){
//		System.out.println(id + " 로 회원을 찾습니다.");
		log.info(id + " 로 회원을 찾습니다.");
	}
}