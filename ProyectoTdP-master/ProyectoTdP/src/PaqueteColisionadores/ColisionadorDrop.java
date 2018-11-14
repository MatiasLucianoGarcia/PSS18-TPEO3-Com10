package PaqueteColisionadores;

import BuscadoresDeArchivos.SoundPlayer;
import PaqueteDrops.Drop;
import PaqueteEnemigos.Enemigo;
import PaqueteObstaculos.Obstaculo;
import PaquetePersonajes.Personaje;

public class ColisionadorDrop extends Colisionador {
	private Drop miDrop;
	
	public ColisionadorDrop(Drop drop) {
		super();
		miDrop = drop;
	}
	
	public int chocarEnemigo(Enemigo enemigo) { return 0; }
	public int chocarObstaculo(Obstaculo obstaculo) { return 0;	}
	
	public int chocarPersonaje(Personaje personaje) {
		if (!miDrop.soyBorrable()) {
			SoundPlayer sp = new SoundPlayer();
			sp.playSound("/SoundEffects/Super Mario Bros. - Mushroom Sound Effect - WAV.wav");
			miDrop.mejorar(personaje);
			miDrop.morir();
			return 15;
		}
		return 0;
	}

	
	public int chocarDrop(Drop drop) {
		return 0;
	}
	
}
