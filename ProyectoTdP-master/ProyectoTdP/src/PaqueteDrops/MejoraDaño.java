package PaqueteDrops;

import PaqueteArmas.ArmaMejoraDaño;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDaño extends Drop {
	public MejoraDaño(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleMejoraDaño.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejoraDaño(gui));
	}
	
	public Drop clone() {
		return new MejoraDaño(pos.x, pos.y, gui);
	}
	
}
