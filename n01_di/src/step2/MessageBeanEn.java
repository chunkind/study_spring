package step2;

public class MessageBeanEn implements MessageBean{
	@Override
	public void intro(String str) {
		System.out.println("Hello " + str);
	}
}