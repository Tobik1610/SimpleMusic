package logic;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements Runnable {

	private File soundFile;
	private Thread thread;
	private AudioInputStream audioInputStream;

	public Sound(Sounds sound) {
		soundFile = new File(sound.getFilePath());
		
		audioInputStream = null;
	}

	public void play() {
		thread = new Thread(this);
		thread.start();
	}
	
	public AudioInputStream generateInputStream() {
		try {
			return AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run() {
		try {
			audioInputStream = generateInputStream();
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