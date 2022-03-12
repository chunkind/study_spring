package step03;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberService {
	private Log log = LogFactory.getLog(getClass());
	
	public void register(){
//		System.out.println("회원으로 등록되었습니다.");
		log.info("register member..");
	}
	
	public void findMember(String id){
//		System.out.println(id + " 로 회원을 찾습니다.");
		log.info("id Check..find member..");
	}
}