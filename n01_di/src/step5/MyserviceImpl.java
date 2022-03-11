package step5;

/*
 * 빈 설정문서에서 빈을 등록
 * 생성자를 통한 값의 주입을 다뤄보겠다.
 */
public class MyserviceImpl implements MyService{

	private String str;
	
	public MyserviceImpl(String str) {
		System.out.println("Bean..Creating..");
		this.str = str;
	}
	
	public String printMsg() {
		return str;
	}

	@Override
	public void register() {
	}

	@Override
	public void update() {
	}
}