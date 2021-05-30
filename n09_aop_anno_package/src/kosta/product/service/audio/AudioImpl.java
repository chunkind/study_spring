package kosta.product.service.audio;

import kosta.product.service.Player;

public class AudioImpl implements Player{

	@Override
	public void start(int volumn) {
		System.out.println("AudioImple start()");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println("AudioImple stop()");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int pause() {
		System.out.println("AudioImple pause()");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
