package kosta.test.main;

import kosta.product.service.Player;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerAppTest1 {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("package.xml");
		
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
