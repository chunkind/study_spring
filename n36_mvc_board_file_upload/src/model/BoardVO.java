package model;

import org.springframework.web.multipart.MultipartFile;

//password가 여기는 없다..
//member 라는 테이블에서 인증을 거치고 들어오기 때문이다..
/*
 * 해당 게시글에 대한 정보를 담고 있는 클래스
 * 해당 게시글 작성은 로그인한 사람만이 사용할 권한을 가진다.
 */
public class BoardVO {
	private int no;
	private String title;
	private String content;
	private int count;
	private  String writeDate;
	//
	private MemberVO memberVO; //중요
	
	//////////FileUpload부분 추가///////////////
	private String orgfilename;
	private String newfilename;
	private MultipartFile uploadFile;
	
	
	
	public String getOrgfilename() {
		return orgfilename;
	}
	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	////////////////////////////////////////////////////////////
	
	public BoardVO(int no, String title, String content, int count,
			String writeDate, MemberVO memberVO) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
		this.memberVO = memberVO;
	}
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int no, String title, String content, int count,
			String writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content="
				+ content + ", count=" + count + ", writeDate=" + writeDate
				+ ", memberVO=" + memberVO + "]";
	}	
}















