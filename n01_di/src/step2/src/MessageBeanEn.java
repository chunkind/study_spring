package step2.src;

public class MessageBeanEn implements MessageBean{

	@Override
	public void sayHello(String str) {
		System.out.println("Hello.." + str);
	}
}
