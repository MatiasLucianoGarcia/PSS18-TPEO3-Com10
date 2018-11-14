package PaqueteArmas;

import PaqueteDisparos.Disparo;
import PaqueteJuego.GUI;

public abstract class Arma {
	protected int daño;
	protected GUI gui;
	
	public Arma () {
		daño = 10;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public abstract Disparo disparar(int x, int y);
	
	public abstract void cambiarImagenGUI();
}