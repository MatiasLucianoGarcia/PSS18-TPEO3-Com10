package PaqueteJuego;

import java.awt.*;
import java.awt.event.KeyAdapter;
import javax.swing.*;
import BuscadoresDeArchivos.ImageFinder;
import BuscadoresDeArchivos.SoundPlayer;
import PaqueteContadores.Contador;
import PaqueteContadores.ContadorTDisparo;
import PaqueteContadores.ContadorTiempo;
import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteInicioYFin.Inicializador;
import PaqueteObjetosGenericos.Objeto;
import PaquetePersonajes.Personaje;

public class GUI {
	private ContadorTiempo tiempo;
	private ContadorTDisparo tiempoDisparo;
	private static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private JFrame frame;
	private Container panel;
	private JLabel[] drops, highScores;
	private PositionList<Enemigo> listaEnemigos;
	private Personaje jugador;
	private int puntaje, nivelActual, cant = 0, frameWidth, frameHeight;
	private String nombre;
	private Inicializador inicializador;
	private JLabel fondo, instruccion, lvl, puntuacion, nombrePersonaje, vida, iconoVida, iconoEscudo;
	private Juego juego;
	private KeyAdapter botonera;
	private SoundPlayer soundplayer;
	private ImageFinder buscadorDeImagenes;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI() throws InterruptedException {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.setResizable(false);
		
		frameWidth = (int) (Xmax*0.6);
		frameHeight = (int) (Ymax*0.9);
		
		frame.setBounds((int) (Xmax * 0.21), (int) (Ymax * 0.015), frameWidth, frameHeight);
		
		inicializador = new Inicializador(frameWidth, frameHeight);
		lvl = inicializador.setearLvl();
		vida = inicializador.setearVida();
		puntuacion = inicializador.setearPuntuacion();
		instruccion = inicializador.setearInstruccion();
		nombrePersonaje = inicializador.setearNombrePersonaje();
		fondo = inicializador.setearFondo();
		drops = inicializador.setearDrops();
		highScores = inicializador.setearHighScores();
		iconoVida = inicializador.setearIconoVida();
		iconoEscudo = inicializador.setearIconoEscudo();
		
		buscadorDeImagenes = new ImageFinder();
		soundplayer = new SoundPlayer();
		nivelActual = 1;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setearFondoYPanel(fondo);
		iniciarSoundPlayer();
		
		puntaje = 0;
		nombre = "";
		
		nombrePersonaje.setText(nombre);
		new Nivel(nivelActual, this, 100);
	}
		
	public JLabel grafico(Objeto o) { return o.getGrafico(); }
	
	void setTiempo(ContadorTiempo t) { tiempo = t; }
	public Contador getTiempo() { return tiempo; }
	void setTiempoDisparo(ContadorTDisparo t) { tiempoDisparo = t; }
	public Contador getTDisparo() { return tiempoDisparo; }
	
	void setPersonaje(Personaje p) { jugador = p; }
	public Personaje getPersonaje() { return jugador; }
	
	void setListaEnemigos(PositionList<Enemigo> lE) { listaEnemigos = lE; }
	public PositionList<Enemigo> getListaEnemigos() { return listaEnemigos;	}
	
	public int getFrameWidth() { return frameWidth;	}
	public int getFrameHeight() { return frameHeight; }
	
	public JFrame getFrame() { return frame; }
	public Container getPanel() { return panel; }
	
	public JLabel[] getDrops() { return drops; }
	public JLabel[] getHighScores() { return highScores; }
	
	public JLabel getPuntuacion() { return puntuacion; }
	public JLabel getVida() { return vida; }
	public JLabel getNombrePersonaje() { return nombrePersonaje; }
	public JLabel getLvl() { return lvl; }
	public JLabel getInstruccion() { return instruccion; }
	
	public int getPuntaje() { return puntaje; }
	public void setPuntaje(int p) {	puntaje = p; }
	
	void setNombre(String n) { nombre = n; }
	public String getNombre() { return nombre; }
	
	public Inicializador getInicializador() { return inicializador; }
	
	void setJuego(Juego j) { juego = j; }
	public Juego getJuego() { return juego; }
	
	public void reiniciar() {
		nivelActual = 0;
		jugador.modificarVida(-jugador.getVida());
		jugador.modificarVida(100);
		puntaje = 0;
		nombre = "";
		nombrePersonaje.setText(nombre);
	}
	
	void setBotonera(KeyAdapter b) { botonera = b; }
	
	public void mostrarIconoDrop(int tipo, ImageIcon image) { drops[tipo].setIcon(image); }
	public void mostrarIconoVida() { panel.add(iconoVida); }
	public void sacarIconoVida() { panel.remove(iconoVida); }
	public void mostrarIconoEscudo(String esc) {
		iconoEscudo.setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/escudo_"+esc+".png"));
		panel.add(iconoEscudo);
	}
	
	private void iniciarSoundPlayer() {soundplayer.playSound("/SoundEffects/Soundtrack - Nivel " + nivelActual + " - WAV.wav");}
	public void pararSoundPlayer() { soundplayer.stopSound(); }
	
	public ImageFinder getBuscadorDeImagenes() { return buscadorDeImagenes; }
	
	public void actualizarIconos() {
		if (jugador.getEscudo().getEscudo() == false) {
			mostrarIconoDrop(0, buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropEscudo_Deshabilitado.png"));
			panel.remove(iconoEscudo);
		}
		if(jugador.getEscudo().getEscudo() && jugador.getEscudo().getCantEsc() == 3)
			mostrarIconoEscudo("3");
		if(jugador.getEscudo().getEscudo() && jugador.getEscudo().getCantEsc() == 2)
			mostrarIconoEscudo("2");
		if(jugador.getEscudo().getEscudo() && jugador.getEscudo().getCantEsc() == 1)
			mostrarIconoEscudo("1");
		if(jugador.getCongelarPoder())
			cant++;
		if(cant == 30) {
			mostrarIconoDrop(3, buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropCongelar_Deshabilitado.png"));
			cant=0;
			jugador.setCongelarPoder(false);
		}	
	}
	
	public void setearFondoYPanel(JLabel nuevoFondo) {
		frame.setContentPane(nuevoFondo);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setVisible(true);
		panel = frame.getContentPane();
		panel.setBounds(0, 0, frameWidth, frameHeight);
		panel.setLayout(null);
	}
	
	
	public void subirNivel() {
		panel.removeAll();
		frame.removeKeyListener(botonera);
		pararSoundPlayer();
		nivelActual++;
		if (nivelActual == 1)
			highScores = inicializador.setearHighScores();
		iniciarSoundPlayer();
		setearFondoYPanel(fondo);
		drops = inicializador.setearDrops();
		new Nivel(nivelActual, this, jugador.getVida());
	}
}
