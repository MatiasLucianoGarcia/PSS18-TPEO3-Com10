package BuscadoresDeArchivos;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
	private Clip clip;
	
	public SoundPlayer() {}
	
	/* El siguiente método fue encontrado en Internet. Para respetar a su autor, lo dejaremos lo más similar posible al original.
	 * URL de donde se obtuvo el método original: https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
	 * */
	public void playSound(String sound){
		try {
			// Open an audio input stream.
			URL url = this.getClass().getResource(sound);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("Problema con el audio.");
			e.printStackTrace();
		}
	}
	
	public void stopSound() {
		clip.stop();
	}
}
