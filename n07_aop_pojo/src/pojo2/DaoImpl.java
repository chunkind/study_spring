package pojo2;

import org.springframework.beans.factory.annotation.Autowired;

public class DaoImpl implements Dao{
	@Autowired
	private String dataSource;	// 주입의 통로
	
	/*public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}*/

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
	public String getDataSource() {
		// TODO Auto-generated method stub
		return dataSource;
	}
}
