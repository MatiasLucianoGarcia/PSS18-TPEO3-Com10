package PaqueteJuego;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import PaqueteDisparos.Disparo;
import PaqueteDrops.Drop;
import PaqueteDrops.GeneradorDrops;
import PaqueteEnemigos.Enemigo;
import PaqueteInicioYFin.FinDelJuego;
import PaqueteObjetosGenericos.Objeto;
import PaquetePersonajes.Personaje;
import TDAListaDE.InvalidPositionException;
import TDAListaDE.Position;
import TDAListaDE.PositionList;

class MovimientosAutomaticos {
	private PositionList<Objeto> listaObjetos;
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Disparo> listaDisparos;
	private PositionList<Drop> listaDrops;
	private Personaje personaje;
	private GUI gui;
	private int frecuencia; //Determina cada cuánto dispara un enemigo.
	private GeneradorDrops gd;
	private FinDelJuego controladorFin;
	
	public MovimientosAutomaticos(PositionList<Objeto> lo, PositionList<Enemigo> le, PositionList<Disparo> ldisp, PositionList<Drop> ldrops, GUI g, Personaje p, int numeroNivel) {
		listaObjetos = lo;
		listaEnemigos = le;
		listaDisparos = ldisp;
		listaDrops = ldrops;
		gui = g;
		personaje = p;
		frecuencia = 0;
		gd = new GeneradorDrops(gui);
		controladorFin = new FinDelJuego(gui, personaje, numeroNivel);
	}
	
	
	public void moverObjetos() {
		try {
			for (Position<Objeto> obj: listaObjetos.positions()) {
				if (obj.element().getVida() <= 0)
					listaObjetos.remove(obj);
				else {
					obj.element().mover();
					colisionesEntreObjetos(obj.element());
					controladorFin.chequearVictoria(listaObjetos);
				}    
			}
		}
		catch (InvalidPositionException exc) {
			System.out.println("Problema con la lista.");
			exc.printStackTrace();
		}
	}
	
	
	public void moverDisparosYDrops() {
		for (Position<Disparo> dis : listaDisparos.positions())
			movimientoDeDisparo(dis);
		for (Position<Drop> dro : listaDrops.positions())
			movimientoDeDrop(dro);
	}
	
		private void movimientoDeDisparo(Position<Disparo> dis) {
			dis.element().mover();
			colisionesEntreObjetos(dis.element());
			if(dis.element().soyBorrable()) {
				try {
					listaDisparos.remove(dis);
				}
				catch (InvalidPositionException e) {
					System.out.println("Problema con la lista.");
					e.printStackTrace();
				}
			}
		}
		private void movimientoDeDrop(Position<Drop> dro) {
			dro.element().mover();
			colisionesEntreObjetos(dro.element());
			if(dro.element().soyBorrable()) {
				try {
					listaDrops.remove(dro);
				}
				catch (InvalidPositionException e) {
					System.out.println("Problema con la lista.");
					e.printStackTrace();
				}
			}
		}
	
	
	public void disparosEnemigos() {
		for (Position<Enemigo> enem : listaEnemigos.positions()) {
			if (enem.element().getVida() <= 0)
				enemigoMuerto(enem);
			else {
				frecuencia++;
				if(frecuencia == 37) {
					Disparo dis = enem.element().disparar();
					if(dis != null) {
						listaDisparos.addLast(dis);
						gui.getPanel().add(dis.getGrafico());
					}
					frecuencia = 0;
				}
			}
		}
	}
	
		private void enemigoMuerto(Position<Enemigo> enem) {
			try {
				if (!enem.element().getMurioChocando()) { //Si el Enemigo muere al colisionar con el Personaje, no se crearán drops.
					Point pos = enem.element().getPos();
					Random r = new Random();
					if (r.nextInt(10) < 4) {
						Drop d = gd.generarDrop(pos.x, pos.y);
						listaDrops.addLast(d);
						gui.getPanel().add(d.getGrafico());
					}
				}
				listaEnemigos.remove(enem);
			}
			catch (InvalidPositionException e) {
				System.out.println("Problema con la lista.");
				e.printStackTrace();
			}
		}
	
	
	private void colisionesEntreObjetos(Objeto obj) {
		Rectangle rectanguloObj = obj.getGrafico().getBounds();
		setearBordes(rectanguloObj);
		for (Position<Objeto> pos : listaObjetos.positions()) {
			if (pos.element() != obj) {
				Rectangle rectanguloPos = pos.element().getGrafico().getBounds();
				setearBordes(rectanguloPos);
				if (rectanguloObj.intersects(rectanguloPos)) {
					int puntos = gui.getPuntaje() + obj.colisionar(pos.element());
					if (puntos < 0)
						puntos = 0;
					gui.setPuntaje(puntos);
					gui.getPuntuacion().setText("Puntaje: " + puntos);
				}
			}
		}
	}
		private void setearBordes(Rectangle re) {
			re.setBounds(re.x, (int) (re.y * 2), (int) (re.getWidth() * 0.8), (int) (re.getHeight() * 0.7));
		}
}
