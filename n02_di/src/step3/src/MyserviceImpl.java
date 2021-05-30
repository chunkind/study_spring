package step3.src;
/*
 * 빈 설정문서에서 빈을 등록
 * 생성자, setter() 를 통한 값의 주입을 다뤄보겠다.
 */
public class MyserviceImpl implements MyService{
	private int num;
	private Integer data;
	private String name;
	
	public MyserviceImpl(String name){
		this.name = name;
	}
	
	//나머지 필드는 setter()를 통한 값의 주입.
	
	
	@Override
	public String msg() {
		return "num : " + num + ", data : " + data + ", name : " + name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}
