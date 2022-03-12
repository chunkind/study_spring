package step04;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 주요관심사가 들어있다. 대상객체, Target
 * 주입의 통로..생성자로 하겠다.
 */
public class MessageImpl implements Message{
	private String message;

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
}