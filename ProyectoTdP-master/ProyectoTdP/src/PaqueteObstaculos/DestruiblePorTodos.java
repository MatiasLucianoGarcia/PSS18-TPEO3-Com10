package PaqueteObstaculos;

import javax.swing.ImageIcon;
import PaqueteDisparos.DisparoEnemigo;

public class DestruiblePorTodos extends Obstaculo {

	public DestruiblePorTodos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 40;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/DESTRUIBLE.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}
	
	public int recibirDisparo(DisparoEnemigo dispEnem) {
		vida -= dispEnem.getDa�o();
		dispEnem.morir();
		if (vida <= 0)
			morir(); //Si un enemigo destruye al Obst�culo, no se suman puntos.
		return 0;
	}
	
}
