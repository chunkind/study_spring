package collection3;

public class Bus {
	
	private String company;
	private int number;
	
	public Bus(String company) {
		this.company = company;
		
	}	
	public Bus(String company,int number) {
		this.company = company;
		this.number = number;		
	}
	
	public String getCompany() {
		return company;
	}
	public int getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return "Bus [company=" + company + ", number=" + number + "]";
	}	
	
}
