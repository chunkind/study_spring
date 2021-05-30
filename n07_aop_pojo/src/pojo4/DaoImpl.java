package pojo4;

import org.springframework.beans.factory.annotation.Autowired;

public class DaoImpl implements Dao{
	
	@Override
	public void register() {
		// 시간을 5초 동안 지연시키자..
		for(int i =1; i<5; i++) {
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//for
		//비지니스 로직..
		System.out.println("Connection연결 및 회원가입 ok.");
	}

	@Override
	public String re() {
		System.out.println("re() call..");
		return "re Value Returning";
	}

	@Override
	public String findId() {
		System.out.println("findId() call..");
		return "member id return";
	}

	@Override
	public void findMember() {
		System.out.println("findMember() call..");
	}

	@Override
	public void updateMember() {
		System.out.println("updateMember() call..");
	}
}
