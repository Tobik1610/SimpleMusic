import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public MainFrame() {
		MusicLoop ml = new MusicLoop(120, 4, true);

		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 600));
		setVisible(true);
		pack();

		JPanel pan = new JPanel();
		add(pan);
		pan.setPreferredSize(new Dimension(400, 500));
		pan.setLayout(new GridLayout(9, 1));

		pan.add(new JLabel("Bpm: " + ml.getBpm()));
		pan.add(new SoundButton(Sounds.CRASH, ml));
		pan.add(new SoundButton(Sounds.KICK, ml));
		pan.add(new SoundButton(Sounds.SNARE, ml));
		pan.add(new SoundButton(Sounds.OPEN_HIHAT, ml));
		pan.add(new SoundButton(Sounds.CLOSED_HIHAT, ml));
		pan.add(new SoundButton(Sounds.LOW_TOM, ml));
		pan.add(new SoundButton(Sounds.MEDIUM_TOM, ml));
		pan.add(new SoundButton(Sounds.HIGH_TOM, ml));

		ml.start();
	}
}
