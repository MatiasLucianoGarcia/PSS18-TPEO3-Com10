package PaquetePersonajes;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import BuscadoresDeArchivos.SoundPlayer;

public class Jugador extends Personaje {
	
	public Jugador(int vel, int x, int y, int vid) {
		super(vel, x, y);
		velocidad = vel;
		vida = vid;
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/Jugador - Estándar.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		grafico.setLocation(pos);
	}
	
	public int morir() {
		SoundPlayer sp = new SoundPlayer();
		sp.playSound("/SoundEffects/Death Sound Effect - Bloodborne - WAV.wav");
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/Jugador - Muerto.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		vida = 0;
		return -30;
	}
	
	public void mover(int dir) {
		if (dir == KeyEvent.VK_LEFT || dir == KeyEvent.VK_A) {
			ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/Jugador - Izquierda.png");
			ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
			grafico.setIcon(iconoEscala);
			if (pos.x - 5 > 0)
				pos.x -= velocidad;
		}
		if (dir == KeyEvent.VK_RIGHT || dir == KeyEvent.VK_D) {
			ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/Jugador - Derecha.png");
			ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
			grafico.setIcon(iconoEscala);
			if (pos.x < (int) (Xmax*0.6) * 0.9)
				pos.x += velocidad;
		}
		grafico.setLocation(pos);
	}
}
