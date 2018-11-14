package PaqueteArmas;

import PaqueteDisparos.Disparo;

public class ArmaEstandar extends Arma {
	
	public ArmaEstandar() {
		super();
	}
	
	public Disparo disparar(int x,int y) {
		return new Disparo(x, y, daño);
	}

	public void cambiarImagenGUI() { }
}
