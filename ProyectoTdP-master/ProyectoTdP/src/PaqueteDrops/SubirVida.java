package PaqueteDrops;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class SubirVida extends Drop{

	public SubirVida(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleVida.gif"));
	}
	
	public void mejorar(Personaje personaje) {
		personaje.modificarVida(20);
		gui.mostrarIconoVida();

		Timer time= new Timer(1000, (ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.sacarIconoVida();		
			}
		});
		time.start();
	}
	
	public Drop clone() {
		return new SubirVida(pos.x, pos.y, gui);
	}

}
