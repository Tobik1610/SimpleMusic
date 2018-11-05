package logic;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import ui.Controller;

public class MusicLoop {

	private int bpm, tacts, bPtact = 4, beat;
	private boolean loop;
	private long bLength;

	private Controller controller;

	private MultiValuedMap<Integer, Sound> playlist;

	public MusicLoop(int bpm, int tacts, boolean loop, Controller controller) {
		this.controller = controller;
		this.bpm = bpm;
		this.tacts = tacts;
		this.loop = loop;
		this.bLength = TimeUnit.SECONDS.toMillis(1) / (bpm / 60);

		this.playlist = new ArrayListValuedHashMap<>();
	}

	public int getBpm() {
		return bpm;
	}

	public void addSound(int beat, Sound sound) {
		playlist.put(beat, sound);
	}

	public int getBeat() {
		return beat;
	}

	public MultiValuedMap<Integer, Sound> getPlaylist() {
		return playlist;
	}

	public void start() {
		beat = 1;
		while (beat <= tacts * bPtact) {
			for (Sound sound : playlist.get(beat)) {
				sound.play();
			}
			try {
				TimeUnit.MILLISECONDS.sleep((bLength / 2));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(beat++);
			controller.setBeat(beat);
		}
		if (loop)
			start();
	}

	public int getTacts() {
		return tacts;
	}

	public int getbPtact() {
		return bPtact;
	}

}
