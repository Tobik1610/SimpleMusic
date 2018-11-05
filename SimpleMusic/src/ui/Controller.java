package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import logic.MusicLoop;

public class Controller implements ActionListener {
	
	private MainFrame view;
	private MusicLoop ml;
	
	public Controller() {
		this.view = new MainFrame(this);
		ml = new MusicLoop(120, 4, true, this);
		
		view.getBpmLabel().setText("Bpm: " + ml.getBpm());
		
		ml.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SoundButton btn = (SoundButton) e.getSource(); 
		ml.addSound(ml.getBeat(), btn.getSound());
		
		btn.getSound().play();
	}
	
	public void setBeat(int beat) {
		view.getBeatLabel().setText("Beat: " + beat);
	}
	
	public void exportSoundFile(String target) {
		
	}
}
