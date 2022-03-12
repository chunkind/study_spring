package step8;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String greeting;
	private Outputter outputter;

	@Autowired
	public MessageBeanImpl(String name) {
		System.out.println("call MessageBeanImpl..");
		this.name = name;
	}
	
	public void setGreeting(String greeting) {
		System.out.println("call setGreeting..");
		this.greeting = greeting;
	}

	public void setOutputter(Outputter outputter) {
		System.out.println("call setOutputter..");
		this.outputter = outputter;
	}

	@Override
	public void sayMessage() {
		System.out.println("call sayMessage..");
		String message = greeting + " " + name + "~~~~";
		System.out.println("MESSAGE :: " + message);
	}
}
