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

import logic.MusicExporter;
import logic.MusicLoop;
import logic.Sound;

public class Controller implements ActionListener {

	private MainFrame view;
	private MusicLoop ml;
	private MusicExporter mex;

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
			exportSoundFile("C:\\Users\\014365\\Downloads/wav.wav");
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
		mex = new MusicExporter();
		mex.startExport(target);

	}

}
