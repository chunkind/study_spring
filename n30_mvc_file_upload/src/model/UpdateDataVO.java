package model;

import org.springframework.web.multipart.MultipartFile;

public class UpdateDataVO {
	private String userName; //?
	//설정문서에서 MultipartFile를 등록한다..CommonsMultipartResolver
	private MultipartFile uploadFile; //필드명 폼의 name과 일치시켜야함.
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
}
