package PaqueteContadores;

import PaqueteJuego.Juego;

public abstract class Contador extends Thread {
	protected Juego elJuego;
	
	protected Contador(Juego j) {
		elJuego = j;
	}
	
	public abstract void run();
}
