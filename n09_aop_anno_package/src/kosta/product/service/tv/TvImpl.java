package kosta.product.service.tv;

import kosta.product.service.Player;

public class TvImpl implements Player{

	@Override
	public void start(int volumn) {
		System.out.println("TVImple start()");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println("TVImple stop()");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int pause() {
		System.out.println("TVImple pause()");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
