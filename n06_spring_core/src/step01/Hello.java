package step01;

public class Hello{
	private String message = "Container 란 ?????";
	
	public Hello() {}
	public Hello(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
}