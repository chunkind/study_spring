package collection2;

import java.util.List;

public class CompanyImpl implements Company{
	private List<Employee> employees;
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return employees;
	}

}
