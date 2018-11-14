package PaquetePersonajes;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import PaqueteDisparos.Disparo;
import PaqueteJuego.GUI;
import PaqueteJuego.Juego;
import PaqueteObjetosGenericos.Objeto;

public class AccionTeclado extends KeyAdapter {
	private GUI gui;
	private Juego juego;
	private Personaje personaje;
	
	public AccionTeclado(GUI g, Juego j) {
		super();
		gui = g;
		personaje = gui.getPersonaje();
		juego = j;
	}
	
	public void keyPressed(KeyEvent arg0) {
		int direccion = arg0.getKeyCode();
		if (personaje.getVida() > 0)
			personaje.mover(direccion);
	}
	
	public void keyReleased(KeyEvent arg0) {
		int comando = arg0.getKeyCode();
		if (personaje.getVida() > 0) {
			if (comando == KeyEvent.VK_LEFT || comando == KeyEvent.VK_RIGHT || comando == KeyEvent.VK_A || comando == KeyEvent.VK_D)
					acomodarJugador();
			if (comando == KeyEvent.VK_SPACE)
				personajeDispara();
		}
	}
	
	
	private Image escalarImagen(ImageIcon original, Objeto o) {
		return original.getImage().getScaledInstance(gui.grafico(o).getWidth(), gui.grafico(o).getHeight(), java.awt.Image.SCALE_DEFAULT);
	}
	
	private void acomodarJugador() {
		ImageIcon iconoOriginal = gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/Jugador - Estándar.png");
		ImageIcon iconoEscala = new ImageIcon(escalarImagen(iconoOriginal, personaje));
		gui.grafico(personaje).setIcon(iconoEscala);
	}
		
	private void personajeDispara() {
		Disparo dis = personaje.disparar();
		if (dis != null) {
			juego.getListaDisp().addLast(dis);
			gui.getPanel().add(dis.getGrafico());
		}
	}
	
}
