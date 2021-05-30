package step3.src;

public class MessageBeanKr implements MessageBean{
	
	public MessageBeanKr() {
		System.out.println("MessageBeanKr..생성됨.");
	}
	@Override
	public void sayHello(String str) {
		System.out.println("안녕하세요.." + str);
	}
}
