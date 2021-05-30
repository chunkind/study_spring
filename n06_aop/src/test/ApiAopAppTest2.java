package test;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import api2.Message;
import api2.MessageAdvice;
import api2.MessageImpl;
/*
 * target의 위빙되는 PointCut을 ProxyFactoryBean에서 지정해서 사용할 수 있다.
 */
public class ApiAopAppTest2 {
	public static void main(String[] args) {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new MessageImpl());
		
		// 1. 위빙될 타겟의 포인트컷을 지정.
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		
		// target의 sear~로 시작하는 메소드에 위빙되도록 한다..
		pointcut.setMappedName("search*");
		
		// 2. advisor :: advice + pointcut
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new MessageAdvice()));
		
		// 3. pfBean에서 target을 얻어온다
		Message pfMessage = (Message)pfBean.getObject();
		System.out.println(pfMessage.print());
		System.out.println(pfMessage.message());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		pfMessage.searchAddress("판교");
		pfMessage.searchIdMember();
	}
}