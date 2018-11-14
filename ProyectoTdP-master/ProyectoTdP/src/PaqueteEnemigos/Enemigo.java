package PaqueteEnemigos;

import java.util.Random;
import javax.swing.ImageIcon;

import BuscadoresDeArchivos.ImageFinder;
import BuscadoresDeArchivos.SoundPlayer;
import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorEnemigo;
import PaqueteDisparos.Disparo;
import PaqueteObjetosGenericos.Animado;
import PaqueteObjetosGenericos.Objeto;

public class Enemigo extends Animado {
	private Inteligencia intel;
	private Inteligencia meme;
	private final int vidaInicial = 100;
	private boolean moviendo, murioPorChocar;
	private ImageFinder buscadorDeImagenes;
	
	public Enemigo (Inteligencia i, int x, int y) {
		super(i.getVelocidad(), x, y);
		vida = vidaInicial;
		intel = i;
		setGrafico();
		buscadorDeImagenes = new ImageFinder();
		moviendo = intel.iniciaConMovimiento();
	}
	
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		grafico.setIcon(new ImageIcon(escalarGrafico(intel.getIcono())));
		grafico.setLocation(pos);
	}
	
	protected int morir() {
		SoundPlayer sp = new SoundPlayer();
		sp.playSound("/SoundEffects/Small Explosion - Sound Effect - WAV.wav");
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/Animación - Muerte de Enemigo.gif");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		return intel.getPuntosKill();
	}
	
	public void mover() {
		if (moviendo)
			intel.mover(pos);
		else {
			Random r = new Random();
			int chance = r.nextInt(550);
			if (chance <= 6)
				moviendo = true;
		}
		grafico.setLocation(pos);
	}
	
	public int recibirDaño(int d) {
		moviendo = true;
		vida -= d;
		intel.cambiarInteligencia(vida, this);
		if(vida <= 0)
			return morir();
		return 0;
	}
	
	public int serChocado(Colisionador c) {
		return c.chocarEnemigo(this);
	}
	
	public Disparo disparar() {
		return intel.disparar(pos);
	}
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorEnemigo(this));
	}
	
	public void setMurioChocando(boolean muerte) {
		murioPorChocar = muerte;
	}
	public boolean getMurioChocando() {
		return murioPorChocar;
	}

	public void frenar() {			
		if(meme == null) {
			MementoInteligencia memento = intel.crearMemento();
			meme = memento.getIntel();
		}
		intel = new InteligenciaCongelada(null,this);
	}

	public void recuperarIntel() {
		intel = meme;
		meme = null;
	}
}
