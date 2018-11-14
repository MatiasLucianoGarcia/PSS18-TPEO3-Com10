package PaqueteObstaculos;

import javax.swing.ImageIcon;
import PaqueteDisparos.DisparoEnemigo;

public class BarricadaEnemigos extends Obstaculo {
	
	public BarricadaEnemigos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 60;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/BARRICADA.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}
	
	public int recibirDisparo(DisparoEnemigo dispEnem) { //El disparo del Enemigo no le hace daño a este tipo de obstáculos.
		return 0;
	}

}
