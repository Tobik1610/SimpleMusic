package ui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import logic.Sound;
import logic.Sounds;

public class SoundButton extends JButton {

	private Sound sound;
	private int tableRow;

	public SoundButton(Sounds sounds, int tableRow) {
		setPreferredSize(new Dimension(200, 100));
		setText(sounds.name());
		setActionCommand("SOUND");
		sound = new Sound(sounds);
		this.tableRow = tableRow;
	}
	
	public Sound getSound() {
		return this.sound;
	}
	
	public int getTableRow() {
		return this.tableRow;
	}
	
	public void setActionListener(ActionListener listener) {
		setActionListener(listener);
	}

}
