package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step2.src.MyService;

/*
 * 1. 설정문서를 읽어서 Resource를 반환받는다 
 * 2. Resource를 인자값으로 BeanFactory를 생성
 * 3. 빈을 하나 얻어옴
 * 4. 빈의 비지니스 로직을 호출함
 *     Hello MyServiceImpl!을 호출함 
 *     
 *     BeanFactory의 자식 컨테이너인 ApplicationContext :
 *     pre Loading
 *     빈 설정문서를 읽어 들임과 동시에 빈을 생성한다 
 *     즉 생성하고나서 요펑이 들어올 때까지 빈을 보관하는 역할까지 한다는 뜻
 *     서블릿에서 Ready On 과정의 기능이 먼저 작동되기 위해서 
 *     load-startup 태그를 기술했던 것과 거의 동일한 원리이다. 
 *     
 *     두 컨테이너의 공통점은 빈을 싱글톤으로 만들고 관리한다는 점. 
 */
public class MyServiceImplTest2 {

	public static void main(String[] args) {
		//pre Loading이 되도록 로직을 다시 작성 
		System.out.println("1.공장을 생성합니다...");
		ApplicationContext factory = new FileSystemXmlApplicationContext("src/step2/src/msg2.xml");
		
		System.out.println("2.getBean() call...");
		MyService service1 =factory.getBean("msg2",MyService.class);
		MyService service2 =factory.getBean("msg2",MyService.class);
		System.out.println(service1==service2);  //true 
		
		System.out.println("3.Biz Logic call...");
		System.out.println(service1.printMsg());
		
		/*Resource r = new FileSystemResource("src/step1/src/msg1.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		
		MyServiceImpl ms = factory.getBean("msg1",MyServiceImpl.class);
		System.out.println(ms.printMsg());*/
	}

}
