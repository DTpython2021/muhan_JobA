package muhan_test_02_01;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

// 음원 소스 https://www.wavsource.com/sfx/sfx2.htm

public class SlotMusic extends Applet implements Runnable {
	boolean onoff = false;
	
	public void run() 	{
		AudioClip sound;
		
//		System.out.println("Thread1" + Thread.interrupted());
//		while (true) {
			try {
//				URL url = new URL("file:///D:/abc/MySources/image/ImageSlot/projector.wav");
				URL url = new URL("file:///C:/Users/KIM HYUNJI/git/test01/src/music/projector.wav");
				sound = Applet.newAudioClip(url);
				sound.play();
//				System.out.println("Thread2" + Thread.interrupted());
				if(onoff == true) {
//					break;
					stop();
				}
			} catch  (Exception e) {
//			System.out.println("URL 주소 틀림 (예외처리)");
			}
//		}

			onoff= true;
	}
}

