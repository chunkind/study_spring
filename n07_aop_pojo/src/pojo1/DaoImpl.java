package pojo1;

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
}
