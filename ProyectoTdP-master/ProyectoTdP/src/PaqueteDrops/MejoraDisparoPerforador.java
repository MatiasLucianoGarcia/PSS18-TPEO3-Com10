package PaqueteDrops;

import PaqueteArmas.ArmaDisparoPerforador;
import PaqueteJuego.GUI;
import PaquetePersonajes.Personaje;

public class MejoraDisparoPerforador extends Drop {

	protected MejoraDisparoPerforador(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtlePerforador.gif"));
		setGrafico();
	}

	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaDisparoPerforador(gui));
	}
	
	public Drop clone() {
		return new MejoraDisparoPerforador(pos.x, pos.y, gui);
	}
	
}
