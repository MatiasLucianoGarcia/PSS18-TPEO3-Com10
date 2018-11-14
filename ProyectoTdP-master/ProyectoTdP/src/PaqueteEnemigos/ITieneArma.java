package PaqueteEnemigos;

import java.awt.Point;
import java.util.Random;
import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoEnemigo;
import PaquetePersonajes.Personaje;

public class ITieneArma extends Inteligencia {
	public ITieneArma(Personaje p) {
		super(p);
		icono = buscadorDeImagenes.buscarImagen("/ImageIcons/ITieneArma.png");
		puntosKill = 15;
		velocidad = 3;
	}
	
	public void mover(Point pos) {
		Random r = new Random();
		int dir = r.nextInt(90);
		
		if (dir > 10) {
			pos.setLocation(pos.x - velocidad, pos.y);
			if (pos.x < 0)
				pos.x = (int) (Xmax * 0.6);
		}
		else {
			pos.setLocation(pos.x + velocidad, pos.y);
			if (pos.x > Xmax * 0.585)
				pos.x = (int) (Xmax * 0.01);
		}
	}
	
	public boolean iniciaConMovimiento() {
		return true;
	}
	
	public Disparo disparar(Point pos) {
		return new DisparoEnemigo(pos.x, pos.y,10);
	}
}
