package logic;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound implements Runnable {

	private File soundFile;
	private Thread thread;

	public Sound(Sounds sound) {
		soundFile = new File(sound.getFilePath());
	}

	public void play() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(500);
			audioInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}