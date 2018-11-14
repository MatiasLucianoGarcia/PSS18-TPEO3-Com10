package PaqueteDrops;

import PaqueteArmas.ArmaMejoraDa�o;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDa�o extends Drop {
	public MejoraDa�o(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleMejoraDa�o.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejoraDa�o(gui));
	}
	
	public Drop clone() {
		return new MejoraDa�o(pos.x, pos.y, gui);
	}
	
}
