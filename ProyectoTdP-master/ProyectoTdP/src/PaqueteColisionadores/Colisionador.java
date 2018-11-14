package PaqueteColisionadores;

import PaqueteDrops.Drop;
import PaqueteEnemigos.Enemigo;
import PaqueteObstaculos.Obstaculo;
import PaquetePersonajes.Personaje;

public abstract class Colisionador {
	protected Colisionador() {}
	
	public abstract int chocarEnemigo(Enemigo enemigo);
	public abstract int chocarPersonaje(Personaje personaje);
	public abstract int chocarObstaculo(Obstaculo obstaculo);
	public abstract int chocarDrop(Drop drop);
}
