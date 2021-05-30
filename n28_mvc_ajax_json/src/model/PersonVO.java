package model;
/*
 * Ajax-Json에서 응답하는 내용이 Text 기반이 아니라 객체 기반이므로 작성...
 */
public class PersonVO {
	private String name;
	private String address;
	public PersonVO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public PersonVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", address=" + address + "]";
	}
	
}
