package PaqueteColisionadores;

import PaqueteDisparos.DisparoEnemigo;
import PaqueteDrops.Drop;
import PaqueteEnemigos.Enemigo;
import PaqueteObstaculos.Obstaculo;
import PaquetePersonajes.Personaje;

public class ColisionadorDisparoEnemigo extends Colisionador {
private DisparoEnemigo miDisparo;
	
	public ColisionadorDisparoEnemigo(DisparoEnemigo disp) {
		super();
		miDisparo = disp;
	}
	
	public int chocarEnemigo(Enemigo enemigo) {
		return 0;
	}
	
	public int chocarPersonaje(Personaje personaje) {
		if (!miDisparo.soyBorrable()) {
			miDisparo.morir();
			if(!personaje.getEscudo().getEscudo())
				return personaje.recibirDaño(miDisparo.getDaño());
			else
				personaje.getEscudo().chocoEscudo();
		}
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
