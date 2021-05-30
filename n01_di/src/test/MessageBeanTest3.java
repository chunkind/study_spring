package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.cglib.proxy.Factory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step3.src.MessageBean;


/*
 * bean.xml 빈 설정문서를 읽어서 
컨테이너가 직접 빈 객체를 생성하도록 할 것이다 

우리는 컨테이너가 빈을 생성하면 
빈의 타입인 인터페이스를 통해서 메소드를 호출할 것이다 

결과적으로 인터페이스 기반의 구상 객체가 실행되는 것을 볼수 있다
 */
public class MessageBeanTest3 {

	public static void main(String[] args) {
		System.out.println("1.빈 설정문서를 읽어들인다..");
		Resource resource = new FileSystemResource("src/step3/src/bean.xml");
		
		System.out.println("2.설정문서에 등록된 빈을 생성할 공장을 먼저 생성 ");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		System.out.println("3.공장에 생성된 빈을 가져옴..");
		
		MessageBean messageBean1 = beanFactory.getBean("message1", MessageBean.class );
		MessageBean messageBean2 = (MessageBean)beanFactory.getBean("message2");
		
		System.out.println(messageBean1);
		System.out.println(messageBean2);
	}

}
/*
 * BeanFactory ::
 * Bean Factory, IOC Container, DI Container
 * BeanFactory를 이용하면 Bean의 생성 시점 Factory가 생성될때 만들어 지는것이 아닌 
 * 클라이언트가 빈을 요청하면(getBean() 사용) 그떄 부랴부랴 빈을 생성한다. 
 * 
 * Lazy Loaing 이라고 한다 
 * 
 * Pre Loading을 하는 것이 좋다.
 * BeanFactory을 하는것이 좋다 
 * 
 * Application : 얘는 나중에 바로 사용할 것이다..  알아두자.. 
 */





