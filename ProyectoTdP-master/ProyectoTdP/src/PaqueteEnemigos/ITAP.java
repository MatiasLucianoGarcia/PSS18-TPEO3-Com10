package PaqueteEnemigos;

import java.awt.Point;
import PaqueteDisparos.Disparo;
import PaquetePersonajes.Personaje;

public class ITAP extends Inteligencia {
	private Inteligencia intelActual;
	private boolean cambio;
	
	public ITAP(Personaje p) {
		super(p);
		icono = buscadorDeImagenes.buscarImagen("/ImageIcons/ITAP - Armado.png");
		puntosKill = 20;
		velocidad = 1;
		intelActual = new ITieneArma(p);
		cambio = false;
	}
	
	public void mover(Point pos) {
		intelActual.mover(pos);
	}
	
	public void cambiarInteligencia(int vida, Enemigo enem) {
		if (!cambio && vida <= 20) {
			intelActual = new IKB(personajeJuego);
			icono = buscadorDeImagenes.buscarImagen("/ImageIcons/ITAP - Desarmado.png");
			enem.setGrafico();
			cambio = true;
		}
	}
	
	public boolean iniciaConMovimiento() {
		return true;
	}
	
	public Disparo disparar(Point pos) {
		return intelActual.disparar(pos);
	}
}
