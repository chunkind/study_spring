package step06.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import step06.MessageBean;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 13.
 */
public class ApiAopAppTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/step06/api.xml"));
		/*
		 * proxy라는 이름으로 획득된 빈은 우리가 알고 있는 target이 아닌
		 * 이미 ProxyFactoryBean에서 획득한 pfTarget이라는 사실을 잊으면 안된다.
		 * 어드바이스를 어떻게 작성했건 간에 aop 프레임워크는 무조건 ProxyFactory에서 돌아간다.
		 */
		MessageBean bean = (MessageBean)factory.getBean("proxy");
		
		bean.sayHello();
	}
}
