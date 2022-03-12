package step10;

public class Employee {
	private String name;
	private int age;
	private String addr;
	
	public Employee(String name, int age, String addr) {
		super();
		System.out.println("string, int, stirng");
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
