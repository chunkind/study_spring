package anno5;

public class MessageBeanImpl implements MessageBean{
	private String name;
	
	
	public void setName(String name) {
		this.name = name;
	}

	//비지니스 로직에 해당.. 구현
	@Override
	public void sayHello() {
		try{
			Thread.sleep(5000);
			System.out.println("During 5 sec .. Sleeping..");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Hello~ " + name);
	}
}
