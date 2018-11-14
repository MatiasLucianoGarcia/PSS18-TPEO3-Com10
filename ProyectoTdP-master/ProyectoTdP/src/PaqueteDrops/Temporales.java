package PaqueteDrops;

import PaqueteJuego.GUI;

public abstract class Temporales extends Drop {
	
	
	protected Temporales(int x, int y, GUI gui) {
		super(x, y, gui);
	}

	abstract public void terminar() ;	
}
