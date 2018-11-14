package PaqueteJuego;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import PaqueteContadores.ContadorTDisparo;
import PaqueteContadores.ContadorTiempo;
import PaqueteEnemigos.Enemigo;
import PaqueteInicioYFin.Inicializador;
import PaquetePersonajes.AccionTeclado;
import PaquetePersonajes.Personaje;
import TDAListaDE.Position;
import TDAListaDE.PositionList;

class Nivel {
	private GUI gui;
	private JLabel[] drops, highScores;
	private JLabel lvl, puntuacion, vida, nombrePersonaje, instruccion;
	private String nombre;
	private int puntaje, vidaActual;
	private PositionList<Enemigo> listaEnemigos;
	private Juego juego;
	private ContadorTiempo tiempo;
	private ContadorTDisparo tiempoDisparo;
	private Container panel;
	private Personaje jugador;
	private Inicializador inicializador;
	private KeyAdapter comienzoConEspacio, botonera;
	
	
	public Nivel(int dificultad, GUI g, int vidaAct) {
		gui = g;
		drops = gui.getDrops();
		highScores = gui.getHighScores();
		lvl = gui.getLvl();
		puntuacion = gui.getPuntuacion();
		vida = gui.getVida();
		nombrePersonaje = gui.getNombrePersonaje();
		instruccion = gui.getInstruccion(); instruccion.setVisible(true);
		nombre = gui.getNombre();
		puntaje = gui.getPuntaje();
		panel = gui.getPanel();
		inicializador = gui.getInicializador();
		vidaActual = vidaAct;
		crearNivel(dificultad);
	}
	
	private void crearNivel(int dificultad) {
		if (dificultad == 1) {
			for(int i = 0; i < highScores.length; i++) {
				highScores[i].setVisible(true);
				panel.add(highScores[i]);
			}
		}
		
		lvl.setText("Nivel: " + dificultad);
		panel.add(lvl);
		
		panel.add(nombrePersonaje);
		
		puntuacion.setText("Puntaje: " + puntaje);
		panel.add(puntuacion);
		
		for(int i = 0; i < drops.length; i++)
			panel.add(drops[i]);
		
		juego = new Juego(dificultad, gui, vidaActual);
		gui.setJuego(juego);

		tiempo = new ContadorTiempo(juego);
		gui.setTiempo(tiempo);
		tiempoDisparo= new ContadorTDisparo(juego);
		gui.setTiempoDisparo(tiempoDisparo);
		
		listaEnemigos = juego.getListaEnems();
		for (Position<Enemigo> pos : listaEnemigos.positions())
			panel.add(gui.grafico(pos.element()));
		gui.setListaEnemigos(listaEnemigos);
		
		panel.add(gui.grafico(juego.getObstaculo(0)));
		panel.add(gui.grafico(juego.getObstaculo(1)));
		panel.add(gui.grafico(juego.getObstaculo(2)));

		jugador = juego.getPersonaje();
		gui.setPersonaje(jugador);
		panel.add(gui.grafico(jugador));
		
		vida.setText("Vida: " + jugador.getVida());
		panel.add(vida);
		
		panel.add(instruccion);
		
		comienzoConEspacio = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				int barraEspaciadora = arg0.getKeyCode();
				
				if (barraEspaciadora == KeyEvent.VK_SPACE) {
					try {
						if (nombre.equals("")) {
							nombre = inicializador.obtenerNombre(nombrePersonaje);
							gui.setNombre(nombre);
						}
						comenzarJuego();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					tiempo.start();
					tiempoDisparo.start();
				}
			}
		};
		
		gui.getFrame().addKeyListener(comienzoConEspacio);
	}
		
		private void comenzarJuego() throws InterruptedException {
			for(int i = 0; i < highScores.length; i++)
				highScores[i].setVisible(false);
			gui.getFrame().removeKeyListener(comienzoConEspacio);
			instruccion.setVisible(false);
			
			botonera = new AccionTeclado(gui, juego);
			
			gui.getFrame().addKeyListener(botonera);
			gui.setBotonera(botonera);
		}
	
}
