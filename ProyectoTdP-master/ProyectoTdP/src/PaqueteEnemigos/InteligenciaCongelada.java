package PaqueteEnemigos;

import java.awt.Point;
import PaqueteDisparos.Disparo;
import PaquetePersonajes.Personaje;

public class InteligenciaCongelada extends Inteligencia {
	int cantTurnos;
	protected Enemigo enemigo;
	protected InteligenciaCongelada(Personaje p, Enemigo e) {
		super(p);
		enemigo = e;
		cantTurnos = 30;
	}

	public void mover(Point pos) {
		cantTurnos--;
		if(cantTurnos == 0) {
			enemigo.recuperarIntel();
		}
	}

	public boolean iniciaConMovimiento() {
		return false;
	}

	public Disparo disparar(Point pos) {
		return null;
	}
}
