package PaqueteContadores;

import PaqueteJuego.Juego;

public class ContadorTDisparo extends Contador {

	public ContadorTDisparo(Juego j) {
		super(j);
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(11);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.moverDisparosYDrops();
		}
	}
}