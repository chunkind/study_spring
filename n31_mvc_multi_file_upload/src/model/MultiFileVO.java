package model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultiFileVO {
//필드 선언
	private String userName;
	private List<MultipartFile> file;//변수명 중요
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}	
}
