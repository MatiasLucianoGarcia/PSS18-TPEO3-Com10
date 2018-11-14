package PaqueteEnemigos;

import java.awt.Point;
import PaqueteDisparos.Disparo;
import PaquetePersonajes.Personaje;

public class IKB extends Inteligencia {
	public IKB(Personaje p) {
		super(p);
		icono = buscadorDeImagenes.buscarImagen("/ImageIcons/IKB.png");
		puntosKill = 30;
		velocidad = 5;
	}

	public void mover(Point pos) {
		if (personajeJuego.getPos().x > pos.x)
			pos.setLocation(pos.x + velocidad, pos.y);
		else {
			if (personajeJuego.getPos().x < pos.x)
				pos.setLocation(pos.x - velocidad, pos.y);
		}
		pos.setLocation(pos.x, pos.y + velocidad);
		if (pos.y > Ymax * 0.9)
			pos.y = 0;
	}
	
	public boolean iniciaConMovimiento() {
		return false;
	}
	
	public Disparo disparar(Point pos) {
		return null;
	}
}
