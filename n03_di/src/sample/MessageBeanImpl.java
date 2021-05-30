package sample;

public class MessageBeanImpl implements MessageBean{

	private String name;	// 생성자 주입
	private String greeting;	// setter() 주입
	
	//추가..
	private Outputter outputter;

	public MessageBeanImpl(String name) {
		this.name = name;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void sayMessage() {
		String message = greeting + " " + name + "~~~~";
		System.out.println("MESSAGE :: " + message);
	}
}
