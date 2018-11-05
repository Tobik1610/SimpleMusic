package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import logic.MusicLoop;

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
		SoundButton btn = (SoundButton) e.getSource(); 
		ml.addSound(ml.getBeat(), btn.getSound());
		
		btn.getSound().play();
		
		view.setTableData('X', btn.getTableRow(), ml.getBeat());
	}
	
	public void setBeat(int beat) {
		view.getBeatLabel().setText("Beat: " + beat);
	}
	
	public int getBeatCount() {
		return ml.getTacts()*ml.getbPtact();
	}
	
	public void exportSoundFile(String target) {
		
	}
}
