package ui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logic.Sound;
import logic.Sounds;

public class SoundButton extends JButton {

	private Sound sound;

	public SoundButton(Sounds sounds) {
		setPreferredSize(new Dimension(200, 100));
		setText(sounds.name());
		sound = new Sound(sounds);
	}
	
	public Sound getSound() {
		return this.sound;
	}
	
	public void setActionListener(ActionListener listener) {
		setActionListener(listener);
	}

}
