package PaqueteInicioYFin;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import BuscadoresDeArchivos.SoundPlayer;
import PaqueteDisparos.Disparo;
import PaqueteDrops.Drop;
import PaqueteJuego.GUI;
import PaqueteObjetosGenericos.Objeto;
import PaquetePersonajes.Personaje;
import TDAListaDE.EmptyListException;
import TDAListaDE.InvalidPositionException;
import TDAListaDE.Position;
import TDAListaDE.PositionList;

public class FinDelJuego {
	private GUI gui;
	private Personaje personaje;
	private final int nivelMaximo = 2;
	private int nivelActual;
	private SoundPlayer sp;
	
	public FinDelJuego(GUI g, Personaje per, int numeroNivel) {
		gui = g;
		personaje = per;
		nivelActual = numeroNivel;
		sp = new SoundPlayer();
	}
	
	public void chequearVictoria(PositionList<Objeto> listaObjetos) {
		if (listaObjetos.size() == 1) { //La lista de Objetos sólo contiene al Personaje.
			if (nivelActual == nivelMaximo) {
				cambiarFondo("/ImageIcons/You Win - Agradecimientos.jpeg");
				new Ganador(gui);
				sp.playSound("/SoundEffects/Goodbye Moonmen - Rick and Morty - WAV.wav");
				pararThreads();
			}
			else {
				try {
					listaObjetos.remove(listaObjetos.first()); //Evita que en el próximo control la lista de este juego tenga tamaño 1.
				}
				catch (InvalidPositionException | EmptyListException e) {
					System.out.println("Problema con la lista de objetos.");
					e.printStackTrace();
				}
				
				for (Position<Disparo> disparo : gui.getJuego().getListaDisp().positions())
					disparo.element().morir();
				for (Position<Drop> drop : gui.getJuego().getListaDrops().positions())
					drop.element().morir();
				
				gui.subirNivel();
			}
		}
		else
			actualizarVida();
	}
		
		private void actualizarVida() {
			gui.getVida().setText("Vida: " + personaje.getVida());
			if (personaje.getVida() <= 30) {
				if (personaje.getVida() <= 0) { //Perder el Juego.
					cambiarFondo("/ImageIcons/Diablo III - You Have Died.jpg");
					sp.playSound("/SoundEffects/For the Damaged Coda - Blonde Redhead - WAV.wav");
					pararThreads();
				}
				else {
					gui.getVida().setForeground(new Color(255,0,0));
					gui.getVida().setBackground(new Color(255,0,0));
				}
			}
			else { //Contempla que se agarre un drop que sume vida.
				gui.getVida().setForeground(new Color(255,255,255));
				gui.getVida().setBackground(new Color(255,255,255));
			}
		}
		
		
		private void cambiarFondo(String ruta) {
			JLabel nuevoFondo = new JLabel();
			ImageIcon iconoOriginal = gui.getBuscadorDeImagenes().buscarImagen(ruta);
			ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(gui.getFrameWidth(), gui.getFrameHeight(), java.awt.Image.SCALE_DEFAULT));
			nuevoFondo.setSize(gui.getFrameWidth(), gui.getFrameHeight());
			nuevoFondo.setIcon(iconoEscala);
			
			gui.getPersonaje().getEscudo().setEscudo(false);
			gui.getInicializador().setearDrops();
			
			gui.pararSoundPlayer();
			gui.getPanel().removeAll();
			gui.setearFondoYPanel(nuevoFondo);
			gui.getPanel().add(personaje.getGrafico());
			gui.getPanel().add(gui.getPuntuacion());
			gui.getPanel().add(gui.getLvl());
			gui.getPanel().add(gui.getNombrePersonaje());
			gui.getPanel().add(gui.getVida());
			
			Reinicio reinicio = new Reinicio(gui, sp);
			gui.getFrame().addKeyListener(reinicio);
		}
		
		@SuppressWarnings("deprecation")
		private void pararThreads() {
			gui.getTDisparo().stop();
			gui.getTiempo().stop();
		}
}
