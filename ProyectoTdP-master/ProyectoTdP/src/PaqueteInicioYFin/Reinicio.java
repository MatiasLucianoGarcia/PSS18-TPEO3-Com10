package PaqueteInicioYFin;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import BuscadoresDeArchivos.SoundPlayer;
import PaqueteJuego.GUI;

public class Reinicio extends KeyAdapter {
	private GUI gui;
	private SoundPlayer soundPlayer;
	
	public Reinicio(GUI g, SoundPlayer sp) {
		super();
		gui = g;
		soundPlayer = sp;
	}
	
	public void keyReleased(KeyEvent arg0) {
		int comando = arg0.getKeyCode();
		if (comando == KeyEvent.VK_ENTER) {
			gui.reiniciar();
			soundPlayer.stopSound();
			
			Color color = new Color(255, 255, 255);
			gui.getVida().setForeground(color);
			gui.getVida().setBackground(color);
			gui.getNombrePersonaje().setForeground(color);
			gui.getNombrePersonaje().setBackground(color);
			gui.getLvl().setForeground(color);
			gui.getLvl().setBackground(color);
			gui.getPuntuacion().setForeground(color);
			gui.getPuntuacion().setBackground(color);
			
			gui.subirNivel();
			gui.getFrame().removeKeyListener(this);
		}
	}
	
}
