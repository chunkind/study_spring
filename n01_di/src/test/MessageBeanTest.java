package test;
/*
 * 클래스 연관성 MessageBeanTest | MessageBean::
 * Hasing 관계.
 * MessageBeanTest가 MessageBean을 사용하는 관계.. 의존되어 있다. (의존성)
 * 
 * 의존할때는 반드시 나와야 하는 코드가 있다.. --> new
 * 1) new라는 키워드를 통해서 직접 객체를 생성.
 * 2) 생성된 객체 이름으로 (bean) 메소드 호출.. sayHello()
 * 
 * ::
 * 결합도가 강화된 코드
 * --> 재사용성 떨어지고 / 유지보수성 떨어진다.
 */
import step1.src.MessageBean;

public class MessageBeanTest {

	public static void main(String[] args) {
		//MessageBean의 sayHello를 사용하고 싶다..어떻게 해야 하나요?
		
		MessageBean bean = new MessageBean();
		bean.sayHello("Spring1");
	}
}
