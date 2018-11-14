package PaquetePersonajes;

import BuscadoresDeArchivos.ImageFinder;
import PaqueteArmas.Arma;
import PaqueteArmas.ArmaEstandar;
import PaqueteArmas.MementoArma;
import PaqueteColisionadores.Colisionador;
import PaqueteDisparos.Disparo;
import PaqueteDrops.Drop;
import PaqueteObjetosGenericos.Animado;
import PaqueteObjetosGenericos.Objeto;

public abstract class Personaje extends Animado {
	protected Arma arma;
	protected EscudoPersonaje escudo;
	protected boolean congeladoPoder;
	protected MementoArma meme;
	private int cantTemporales;
	protected ImageFinder buscadorDeImagenes;

	protected Personaje(int v, int x, int y) {
		super(v, x, y);
		cantTemporales = 0;
		meme = null;
		arma = new ArmaEstandar();
		congeladoPoder = false;
		escudo = new EscudoPersonaje();
		buscadorDeImagenes = new ImageFinder();
	}

	public int getVel() {
		return velocidad;
	}
	
	public abstract void mover(int dir);
	
	public int recibirDaño(int d) {
		vida -= d;
		if(vida <= 0)
			return morir();
		return -5;
	}
	public void modificarVida(int v) {
		vida += v;
	}
	
	public void mejorar(Drop drop) {
		drop.mejorar(this);
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
	
	public int serChocado(Colisionador c) {
		return c.chocarPersonaje(this);
	}
	
	public Disparo disparar() {
		return arma.disparar((int) (pos.x + grafico.getWidth() * 0.6), pos.y);
	}

	public void setArma(Arma ar) {
		if(meme != null) {
			meme = new MementoArma(ar);
		}
		arma = ar;
		arma.cambiarImagenGUI();
	}
	public EscudoPersonaje getEscudo() {
		return escudo;
	}
	public void setCongelarPoder(boolean cong) {
		congeladoPoder = cong;
	}
	public boolean getCongelarPoder() {
		return congeladoPoder;
	}
	public void cambiarAarmaTemporal(Arma a) {			
		if(meme == null)
			 meme = new MementoArma(arma);
		arma = a;
		arma.cambiarImagenGUI();
		cantTemporales++;
	}

	public void recuperarArma() {
		if(cantTemporales == 1) {
			setArma(meme.getArma());
			meme = null;
		}
		cantTemporales--;
	}
}
