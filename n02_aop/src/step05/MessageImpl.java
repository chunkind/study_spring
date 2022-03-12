package step05;
// 주요관심사가 들어있다. 대상객체, Target
public class MessageImpl implements Message{
	
	private String message;	//주입의 통로..생성자로 하겠다.

	public MessageImpl() {
		message = "Nice Day~~";
	}
	
	@Override
	public String print() {
		System.out.println("Test Print.." + message);
		return "Spring Print";
	}

	@Override
	public String message() {
		
		return message;
	}

	@Override
	public void searchMember() {
		System.out.println("serarch Member");
	}

	@Override
	public void searchIdMember() {
		System.out.println("serarch ID Member");
	}

	@Override
	public void searchAddress(String addr) {
		System.out.println("serarch Member Address");
	}
}
