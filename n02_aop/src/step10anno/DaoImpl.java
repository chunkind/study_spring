package step10anno;

import org.springframework.beans.factory.annotation.Autowired;

public class DaoImpl implements Dao{
	@Autowired
	private String dataSource;	// 주입의 통로
	
	/*public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}*/

	@Override
	public void register() {
		for(int i =1; i<5; i++) {
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Connection연결 및 회원가입 ok.");
	}

	@Override
	public String getDataSource() {
		return dataSource;
	}
}
