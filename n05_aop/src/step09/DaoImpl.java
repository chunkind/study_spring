package step09;

public class DaoImpl implements Dao {
	@Override
	public void register() {
		for (int i=1; i<5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Connection연결 및 회원가입 ok.");
	}
}