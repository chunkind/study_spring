package self.collection4;

public class Hotel implements Residence{
	private String hotelName;
	private int cost;
	
	public Hotel() {
		super();
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public void reside() {
		// TODO Auto-generated method stub
		
	}
}
