package collection1;

import java.util.List;

public class Student {
	private String stuId;
	private List<Book> books;
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", books=" + books + "]";
	}	
}