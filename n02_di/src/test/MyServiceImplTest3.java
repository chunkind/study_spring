package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import step3.src.MyService;




public class MyServiceImplTest3 {

	public static void main(String[] args) {
		//pre Loading이 되도록 로직을 다시 작성 
		System.out.println("1.공장을 생성합니다... ");
		ApplicationContext factory = new FileSystemXmlApplicationContext("src/step3/src/msg3.xml");
	
		MyService service1 =factory.getBean("msg3",MyService.class);
		System.out.println(service1.msg());
		
		/*Resource r = new FileSystemResource("src/step1/src/msg1.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		
		MyServiceImpl ms = factory.getBean("msg1",MyServiceImpl.class);
		System.out.println(ms.printMsg());*/
	}

}
