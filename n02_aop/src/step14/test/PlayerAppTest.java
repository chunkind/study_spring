package step14.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step14.product.Player;

public class PlayerAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("step14/package.xml");
		
		Player audio = factory.getBean("audio",Player.class);
		Player video = factory.getBean("video", Player.class);
		Player tv = factory.getBean("tv", Player.class);

		System.out.println("\n-----------------Audio-------------------\n");
		audio.start(10);
		System.out.println(audio.pause());
		audio.stop();

		
		System.out.println("\n-----------------Video-------------------\n");
		video.start(10);
		System.out.println(video.pause());
		video.stop();
		
		
		System.out.println("\n-----------------Tv-------------------\n");
		tv.start(10);
		System.out.println(tv.pause());
		tv.stop();
	}
}
