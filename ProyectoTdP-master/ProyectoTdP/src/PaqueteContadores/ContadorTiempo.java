package PaqueteContadores;

import PaqueteJuego.Juego;

public class ContadorTiempo extends Contador {
	
	public ContadorTiempo(Juego j) {
		super(j);
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.moverObjetos();
			elJuego.disparosEnemigos();
			elJuego.getGui().actualizarIconos();
		}
	}
	
	
}