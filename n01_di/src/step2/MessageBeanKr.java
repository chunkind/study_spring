package step2;

public class MessageBeanKr implements MessageBean{

	@Override
	public void sayHello(String str) {
		System.out.println("안녕하세요.." + str);
	}
}
