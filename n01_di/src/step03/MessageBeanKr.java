package step03;

public class MessageBeanKr implements MessageBean{
	public MessageBeanKr() {
		System.out.println("create MessageBeanKr..");
	}
	@Override
	public void intro(String str) {
		System.out.println("안녕 " + str);
	}
}