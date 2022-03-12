package step05;

public class MyServiceImpl implements MyService{
	private String str;
	
	public MyServiceImpl(String str) {
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