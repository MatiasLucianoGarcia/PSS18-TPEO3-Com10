package PaqueteColisionadores;

import PaqueteDisparos.Disparo;
import PaqueteDrops.Drop;
import PaqueteEnemigos.Enemigo;
import PaqueteObstaculos.Obstaculo;
import PaquetePersonajes.Personaje;

public class ColisionadorDisparoPersonaje extends Colisionador {
	private Disparo miDisparo;
	
	public ColisionadorDisparoPersonaje(Disparo disp) {
		super();
		miDisparo = disp;
	}
	
	public int chocarEnemigo(Enemigo enemigo) {
		if (!miDisparo.soyBorrable()) {
			miDisparo.morir();
			enemigo.setMurioChocando(false);
			return enemigo.recibirDaño(miDisparo.getDaño());
		}
		return 0;
	}
	
	public int chocarPersonaje(Personaje personaje) {
		return 0;
	}
	
	public int chocarObstaculo(Obstaculo obstaculo) {
		if (!miDisparo.soyBorrable())
			return miDisparo.dañarObstaculo(obstaculo);
		return 0;
	}

	
	public int chocarDrop(Drop drop) {
		return 0;
	}
}
