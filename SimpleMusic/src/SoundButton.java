import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SoundButton extends JButton {

	private Sound sound;

	public SoundButton(Sounds sounds, MusicLoop ml) {
		setPreferredSize(new Dimension(200, 100));
		setText(sounds.name());

		sound = new Sound(sounds);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ml.addSound(ml.getBeat(), sound);
				
				sound.play();
			}
		});
	}

}
