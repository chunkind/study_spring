package step06.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import step06.MyService;

public class MyServiceImplTest {
	public static void main(String[] args) {
		//1.Pre Loading 되도록 로직을 다시 작성 
		System.out.println("1.공장을 생성합니다... ");
		ApplicationContext factory = new FileSystemXmlApplicationContext("src/step06/msg.xml");
	
		MyService service1 = factory.getBean("msg", MyService.class);
		System.out.println(service1.msg());
		
		System.out.println("================================================");
		
		//2.Lazy Loading
		Resource r = new FileSystemResource("src/step04/msg.xml");
		BeanFactory factory2 = new XmlBeanFactory(r);
		
		step04.MyServiceImpl ms = factory2.getBean("msg", step04.MyServiceImpl.class);
		System.out.println(ms.printMsg());
	}
}