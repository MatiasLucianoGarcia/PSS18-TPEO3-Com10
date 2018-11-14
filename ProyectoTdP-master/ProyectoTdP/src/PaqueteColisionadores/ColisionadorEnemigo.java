package PaqueteColisionadores;

import PaqueteDrops.Drop;
import PaqueteEnemigos.Enemigo;
import PaqueteObstaculos.Obstaculo;
import PaquetePersonajes.Personaje;

public class ColisionadorEnemigo extends Colisionador {
	private Enemigo miEnemigo;
	
	public ColisionadorEnemigo(Enemigo enem) {
		super();
		miEnemigo = enem;
	}
	
	public int chocarEnemigo(Enemigo enemigo) { return 0; }
	public int chocarObstaculo(Obstaculo obstaculo) { return 0;	}
	
	public int chocarPersonaje(Personaje personaje) {
		miEnemigo.setMurioChocando(true);
		miEnemigo.recibirDaño(100);
		if(!personaje.getEscudo().getEscudo())
			return personaje.recibirDaño(30);
		else {
			personaje.getEscudo().chocoEscudo();
			return 0;
		}
	}

	
	public int chocarDrop(Drop drop) {
		return 0;
	}
}
