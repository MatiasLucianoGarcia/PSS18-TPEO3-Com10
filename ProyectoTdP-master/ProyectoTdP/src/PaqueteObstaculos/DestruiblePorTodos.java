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
		vida -= dispEnem.getDaño();
		dispEnem.morir();
		if (vida <= 0)
			morir(); //Si un enemigo destruye al Obstáculo, no se suman puntos.
		return 0;
	}
	
}
