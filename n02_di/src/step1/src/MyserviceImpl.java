package step1.src;
/*
 * 빈 설정문서에서 빈을 등록
 * 
 */
public class MyserviceImpl implements MyService{

	private String msg;
	
	public MyserviceImpl() {
		System.out.println("Bean..Creating..");
	}
	
	//빈에 값이 주입되는 통로를 setter()로 하나 추가..
	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String printMsg() {
		
		return msg;
	}
}
