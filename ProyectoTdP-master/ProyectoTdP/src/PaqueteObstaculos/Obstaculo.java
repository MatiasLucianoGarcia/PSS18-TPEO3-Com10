package PaqueteObstaculos;

import javax.swing.ImageIcon;
import BuscadoresDeArchivos.ImageFinder;
import BuscadoresDeArchivos.SoundPlayer;
import PaqueteColisionadores.Colisionador;
import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoEnemigo;
import PaqueteObjetosGenericos.Objeto;

public abstract class Obstaculo extends Objeto {
	protected int puntosKill;
	protected ImageFinder buscadorDeImagenes;
	
	protected Obstaculo(int x, int y) {
		super(x, y);
		grafico.setSize((int)(Xmax*0.09),(int)(Ymax*0.07));
		grafico.setLocation(pos);
		vida = 50;
		buscadorDeImagenes = new ImageFinder();
	}
	
	public int recibirDisparo(Disparo dispPer) {
		vida -= dispPer.getDaño();
		dispPer.morir();
		if (vida <= 0)
			return morir();
		return 0;
	}
	public abstract int recibirDisparo(DisparoEnemigo dispEnem); //Método sobrecargado para diferenciar si debe hacerle daño el DisparoEnemigo o no.
	
	public int serChocado(Colisionador c) {
		return c.chocarObstaculo(this);
	}
	
	protected int morir() {
		SoundPlayer sp = new SoundPlayer();
		sp.playSound("/SoundEffects/Small Explosion (Obstáculo) - Sound Effect - WAV.wav");
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/obstaculoDestruido.gif");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		return puntosKill;
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
}
