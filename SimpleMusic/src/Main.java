
public class Main {

	public static void main(String[] args) {
		MusicLoop ml = new MusicLoop(120, 4, true);
		
		Sound kick = new Sound(Sounds.KICK);
		Sound snare = new Sound(Sounds.SNARE);
		Sound closed_hh = new Sound(Sounds.CLOSED_HIHAT);
		
		ml.addSound(2, kick);
		ml.addSound(4, kick);
		ml.addSound(6, kick);
		ml.addSound(8, kick);
		ml.addSound(10, kick);
		ml.addSound(12, kick);
		ml.addSound(14, kick);
		ml.addSound(16, kick);
		
		ml.addSound(8, snare);
		ml.addSound(16, snare);

		ml.addSound(6, closed_hh);
		ml.addSound(7, closed_hh);
		ml.addSound(14, closed_hh);
		ml.addSound(15, closed_hh);
		
		ml.start();
	}

}
