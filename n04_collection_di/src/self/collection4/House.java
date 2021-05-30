package self.collection4;

import java.util.Map;

public class House implements Residence{
	private String address;
	private Map<String, HomeAppliance> hp;
	
	public House(String address, Map<String, HomeAppliance> hp) {
		super();
		this.address = address;
		this.hp = hp;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<String, HomeAppliance> getHp() {
		return hp;
	}
	public void setHp(Map<String, HomeAppliance> hp) {
		this.hp = hp;
	}
	
	@Override
	public void reside() {
		// TODO Auto-generated method stub
		
	}

}
