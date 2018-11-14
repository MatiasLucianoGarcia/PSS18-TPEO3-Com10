package PaqueteDrops;

import PaqueteJuego.GUI;
import PaquetePersonajes.Personaje;

public class Escudo extends Drop {
	
	public Escudo(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleEscudo.gif"));
	}
	
	public void mejorar(Personaje personaje) {
		personaje.getEscudo().setEscudo(true);
		gui.mostrarIconoDrop(0, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropEscudo_Habilitado.png"));
	}
	
	public Drop clone() {
		return new Escudo(pos.x, pos.y, gui);
	}

}
