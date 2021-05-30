package kosta.product.service.video;

import kosta.product.service.Player;

public class VideoImpl implements Player{

	@Override
	public void start(int volumn) {
		System.out.println("VideoImple start()");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println("VideoImple stop()");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int pause() {
		System.out.println("VideoImple pause()");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
