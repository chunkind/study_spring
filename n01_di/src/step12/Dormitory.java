package step12;

import java.util.List;

public class Dormitory implements Residence {
	private String schoolName;
	private List<Book> library;

	@Override
	public void reside() {
		
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Book> getLibrary() {
		return library;
	}

	public void setLibrary(List<Book> library) {
		this.library = library;
	}
}