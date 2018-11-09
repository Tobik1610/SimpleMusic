package logic;

import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicExporter {

	public MusicExporter() {

	}

	public void startExport(String target) {
		File exportFile = new File(target);
		AudioInputStream ais1 = null, ais2, blankAis = null, finalAis = null;

		try {
			blankAis = AudioSystem.getAudioInputStream(new File("resources/sounds/blank.wav"));
			finalAis = AudioSystem.getAudioInputStream(new File("resources/sounds/blank.wav"));
//			blankAis = new AudioInputStream(blankAis, blankAis.getFormat(), 88200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 16; i++) {
			finalAis = concatAuInStr(finalAis, blankAis);
		}

//		finalAis = blankAis;
//		for (int i = 1; i < ml.getTacts() * ml.getbPtact(); i++) {
//			finalAis = concatAuInStr(finalAis, blankAis);
			// Collection<Sound> sounds = ml.getPlaylist().get(i);
			// if (sounds.isEmpty()) {
			// if (ais1 != null)
			// ais1 = new AudioInputStream(new SequenceInputStream(ais1, blankAis),
			// ais1.getFormat(),
			// ais1.getFrameLength() + blankAis.getFrameLength());
			// else
			// ais1 = new AudioInputStream(new SequenceInputStream(blankAis, blankAis),
			// blankAis.getFormat(),
			// blankAis.getFrameLength() + blankAis.getFrameLength());
			// } else {
			// for (Sound sound : sounds) {
			//
			// }
			// }
//		}

		// if (ais1 == null)
		// ais1 = blankAis;
		//
		// for (Entry<Integer, Sound> entry : ml.getPlaylist().entries()) {
		// ais2 = entry.getValue().generateInputStream();
		// ais1 = concatAuInStr(ais1, ais2);
		// }

		try {
			AudioSystem.write(finalAis, AudioFileFormat.Type.WAVE, new File(target));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private AudioInputStream concatAuInStr(AudioInputStream stream1, AudioInputStream stream2) {
		return new AudioInputStream(new SequenceInputStream(stream1, stream2), stream1.getFormat(),
				stream1.getFrameLength() + stream2.getFrameLength());
	}

}
