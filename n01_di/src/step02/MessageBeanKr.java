package step02;

public class MessageBeanKr implements MessageBean{
	@Override
	public void intro(String str) {
		System.out.println("안녕 " + str);
	}
}