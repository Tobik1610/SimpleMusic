package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Collection;
import java.util.Map.Entry;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.commons.collections4.MultiValuedMap;

import logic.MusicLoop;
import logic.Sound;

public class Controller implements ActionListener {

	private MainFrame view;
	private MusicLoop ml;

	public Controller() {
		ml = new MusicLoop(120, 4, true, this);
		this.view = new MainFrame(this);

		view.getBpmLabel().setText("Bpm: " + ml.getBpm());

		ml.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "SOUND":
			SoundButton btn = (SoundButton) e.getSource();
			ml.addSound(ml.getBeat(), btn.getSound());

			btn.getSound().play();

			view.setTableData('X', btn.getTableRow(), ml.getBeat());
			break;
		case "EXPORT":
			exportSoundFile("D:\\Download/wav.wav");
			break;
		}

	}

	public void setBeat(int beat) {
		view.getBeatLabel().setText("Beat: " + beat);
	}

	public int getBeatCount() {
		return ml.getTacts() * ml.getbPtact();
	}

	public void exportSoundFile(String target) {
		AudioInputStream ais1 = null, ais2, blankAis = null, finalAis = null;

		try {
			blankAis = AudioSystem.getAudioInputStream(new File("resources/sounds/blank.wav"));
			blankAis = new AudioInputStream(blankAis, blankAis.getFormat(), 88200);
		} catch (UnsupportedAudioFileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		finalAis = blankAis;
		 for (int i = 1; i < ml.getTacts() * ml.getbPtact(); i++) {
			 finalAis = concatAuInStr(finalAis, blankAis);
		// Collection<Sound> sounds = ml.getPlaylist().get(i);
		// if (sounds.isEmpty()) {
		// if (ais1 != null)
		// ais1 = new AudioInputStream(new SequenceInputStream(ais1, blankAis),
		// ais1.getFormat(),
		// ais1.getFrameLength() + blankAis.getFrameLength());
		// else
		// ais1 = new AudioInputStream(new SequenceInputStream(blankAis, blankAis),
		// blankAis.getFormat(),
		// blankAis.getFrameLength() + blankAis.getFrameLength());
		// } else {
		// for (Sound sound : sounds) {
		//
		// }
		// }
		 }

//		if (ais1 == null)
//			ais1 = blankAis;
//
//		for (Entry<Integer, Sound> entry : ml.getPlaylist().entries()) {
//			ais2 = entry.getValue().generateInputStream();
//			ais1 = concatAuInStr(ais1, ais2);
//		}

		try {
			AudioSystem.write(finalAis, AudioFileFormat.Type.WAVE, new File(target));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private AudioInputStream concatAuInStr(AudioInputStream stream1, AudioInputStream stream2) {
		return new AudioInputStream(new SequenceInputStream(stream1, stream2), stream1.getFormat(),
				stream1.getFrameLength() + stream2.getFrameLength());
	}
}
