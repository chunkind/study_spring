package step3.src;

public class MessageBeanEn implements MessageBean{

	public MessageBeanEn() {
		System.out.println("MessageBeanEn..생성됨.");
	}
	@Override
	public void sayHello(String str) {
		System.out.println("Hello.." + str);
	}
}
