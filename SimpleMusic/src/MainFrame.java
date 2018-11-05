import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private Sound kick, snare, closed_hh;

	public MainFrame() {
		MusicLoop ml = new MusicLoop(120, 4, true);

		initSounds();

		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		setVisible(true);
		pack();

		JPanel pan = new JPanel();
		add(pan);

		pan.add(new JLabel("Bpm: " + ml.getBpm()));

		pan.add(new SoundButton(Sounds.KICK, ml));
		pan.add(new SoundButton(Sounds.SNARE, ml));
		pan.add(new SoundButton(Sounds.CLOSED_HIHAT, ml));

		ml.start();
	}

	public void initSounds() {
		kick = new Sound(Sounds.KICK);
		snare = new Sound(Sounds.SNARE);
		closed_hh = new Sound(Sounds.CLOSED_HIHAT);
	}
}
