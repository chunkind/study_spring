package collection1;

import java.util.List;

public class Owner {
	private String name;
	List<Car> cars;
	
	public Owner(String name) {
		super();
		this.name = name;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
	
	
}
