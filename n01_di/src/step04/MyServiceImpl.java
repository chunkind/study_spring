package step04;

public class MyServiceImpl implements MyService{
	private String msg;
	
	public MyServiceImpl() {
		System.out.println("Bean..Creating..");
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String printMsg() {
		return msg;
	}
}