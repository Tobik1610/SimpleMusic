package logic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicExporter {
	
	public MusicExporter() {
		
	}

	public void startExport(String target) {
		
		AudioFormat newFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
		
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, newFormat);
		try {
			TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);
			targetLine.open(newFormat);
			targetLine.start();
			
			Thread thread = new Thread() {
				@Override
				public void run() {
					AudioInputStream ais = new AudioInputStream(targetLine);
					try {
						AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(target));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			thread.start();
			Thread.sleep(5000);	
			targetLine.stop();
			targetLine.close();
			
			
			
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
