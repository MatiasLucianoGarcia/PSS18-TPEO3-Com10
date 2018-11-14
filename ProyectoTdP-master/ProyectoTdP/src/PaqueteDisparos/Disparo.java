package PaqueteDisparos;

import BuscadoresDeArchivos.ImageFinder;
import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparoPersonaje;
import PaqueteObjetosGenericos.Objeto;
import PaqueteObstaculos.Obstaculo;

public class Disparo extends Objeto {
	protected boolean borrable;
	protected int daño;
	protected int velocidad;
	protected ImageFinder buscadorDeImagenes;
	
	public Disparo(int x, int y,int d) {
		super(x, y);
		borrable = false;
		daño = d;
		buscadorDeImagenes = new ImageFinder();
		setGrafico();
		grafico.setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/dispPersonaje.gif"));
	}
	
	public int getDaño() {
		return daño;
	}
	public boolean soyBorrable() {
		return borrable;
	}
	public int dañarObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparoPersonaje(this));
	}
	
	protected void setGrafico() {
		grafico.setVisible(true);
		grafico.setSize((int)(Xmax*0.01),(int) (Ymax*0.03));
		grafico.setLocation(pos);
	}
	
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mover() {
		pos.setLocation(pos.x, pos.y - 6);
		if(pos.y <= 0)
			morir();
		grafico.setLocation(pos);
	}

}
