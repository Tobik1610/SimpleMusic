package ui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Sounds;

public class MainFrame extends JFrame {

	private Controller controller;
	private JLabel bpmLabel, beatLabel;
	private SoundButton crash, kick, snare, open_hihat, closed_hihat, low_tom, medium_tom, high_tom;

	public MainFrame(Controller controller) {
		
		this.controller = controller;

		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 600));
		setVisible(true);
		pack();

		JPanel pan = new JPanel();
		add(pan);
		pan.setPreferredSize(new Dimension(400, 300));
		pan.setLayout(new GridLayout(9, 1));

		pan.add(bpmLabel = new JLabel());
		pan.add(beatLabel = new JLabel());
		pan.add(crash = new SoundButton(Sounds.CRASH));
		pan.add(kick = new SoundButton(Sounds.KICK));
		pan.add(snare = new SoundButton(Sounds.SNARE));
		pan.add(open_hihat = new SoundButton(Sounds.OPEN_HIHAT));
		pan.add(closed_hihat = new SoundButton(Sounds.CLOSED_HIHAT));
		pan.add(low_tom = new SoundButton(Sounds.LOW_TOM));
		pan.add(medium_tom = new SoundButton(Sounds.MEDIUM_TOM));
		pan.add(high_tom = new SoundButton(Sounds.HIGH_TOM));
		
		setBtnListener(controller);

	}
	
	public void setBtnListener(ActionListener listener) {
		crash.addActionListener(listener);
		kick.addActionListener(listener);
		snare.addActionListener(listener);
		open_hihat.addActionListener(listener);
		closed_hihat.addActionListener(listener);
		low_tom.addActionListener(listener);
		medium_tom.addActionListener(listener);
		high_tom.addActionListener(listener);
	}

	public JLabel getBpmLabel() {
		return bpmLabel;
	}
	
	public JLabel getBeatLabel() {
		return beatLabel;
	}
}
