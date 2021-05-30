package test;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step1.src.MyService;

/*
 * 1. 설정문서를 읽어서 Resource를 반환받는다.
 * 2. Resource를 인자값으로 BeanFactory를 생성
 * 3. 빈을 하나 얻어옴.
 * 4. 빈의 비지니스 로직을 호출함..
 * 	  Hello MyserviceImpl!!를 출력
 *	-----------------------------------------------
 *	빈을 생성하는 컨테이너로 BeanFactory :
 *	"Lazy Loading"
 *	빈 설정문서를 읽어들인 컨테이너가 즉각적으로 빈을 생성하지 않고
 *	요청이 들어왔을때 그때 빈을 생성하는 과정을 거친다.
 * 
 *	BeanFactory의 자식 컨테이너인 ApplicationContext :
 *	"Pre Loading"
 *	빈 설정문서를 읽어 들임과 동시에 빈을 생성한다.
 *	즉 생성하고나서 요청이 들어올 때까지 빈을 보관하는 역할까지 한다는 뜻이다.
 *	서블릿에서 Ready On 과정의 기능이 먼저 작동되기 위해서
 *	load-startup 태그를 기술했던 것과 거의 동일한 원리이다.
 * 
 *	두 컨테이너의 공통점은 빈을 싱글톤으로 만들고 관리한다는 점이다.
 */
public class MyServiceImplTest1 {
	private static String xmlPath = "src/step1/src/msg1.xml";
	
	public static void main(String[] args) {
		//example01();
		example02();
	}
	
	public static void example01(){
		//1.BeanFactory의 Lazy Loading
		System.out.println("1.빈 설정문서를 읽어 드린다.");
		Resource resource = new FileSystemResource(xmlPath);
		
		System.out.println("2.설정문서에 등록된 빈을 생성할 공장을 생성 한다.");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		System.out.println("3.공장에서 생성된 빈을 가져온다.");
		MyService myServiceBean1 = beanFactory.getBean("msg1", MyService.class);
		
		System.out.println("4.생성된 빈을 사용한다.");
		System.out.println(myServiceBean1.printMsg());
	}
	
	public static void example02(){
		//2.ApplicationContext의 Pre Loading
		System.out.println("1.빈 설정문서를 읽어 들이고 설정문서에 등록된 빈을 생성할 공장을 생성 한다.");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		
		System.out.println("2.공장에서 생성된 빈을 가져온다.");
		MyService myServiceBean1 = applicationContext.getBean("msg1", MyService.class);
		MyService myServiceBean2 = applicationContext.getBean("msg1", MyService.class);
		
		System.out.println("3.생성된 빈을 사용한다.");
		System.out.println(myServiceBean1.printMsg());
		
		System.out.println("얻어온 2개의 빈은 같은 빈일까?");
		System.out.println(myServiceBean1 == myServiceBean2);
	}
	
}
