package step3;

public class MessageBeanEn implements MessageBean{
	public MessageBeanEn() {
		System.out.println("create MessageBeanEn..");
	}
	@Override
	public void intro(String str) {
		System.out.println("Hello " + str);
	}
}