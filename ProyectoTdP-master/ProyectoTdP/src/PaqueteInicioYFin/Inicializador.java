package PaqueteInicioYFin;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BuscadoresDeArchivos.ImageFinder;

public class Inicializador {
	private int frameWidth, frameHeight;
	private ImageFinder buscadorDeImagenes;
	
	public Inicializador(int fW, int fH) {
		frameWidth = fW;
		frameHeight = fH;
		buscadorDeImagenes = new ImageFinder();
	}
	
	public JLabel setearLvl() {
		JLabel lvl = new JLabel();
		lvl.setForeground(new Color(255,255,255));
		lvl.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lvl.setBackground(new Color(255,255,255));
		lvl.setBounds((int) (frameWidth * 0.83), (int) (frameHeight * 0.02), 100, 23);
		return lvl;
	}
	
	public JLabel setearVida() {
		JLabel vida = new JLabel();
		vida.setForeground(new Color(255,255,255));
		vida.setFont(new Font("Sitka Text", Font.BOLD, 18));
		vida.setBackground(new Color(255,255,255));
		vida.setBounds((int) (frameWidth * 0.08) + 20, (int) (frameHeight * 0.05), (int) (frameWidth * 0.3), 23);
		return vida;
	}
	
	public JLabel setearPuntuacion() {
		JLabel puntuacion = new JLabel();
		puntuacion.setForeground(new Color(255,255,255));
		puntuacion.setFont(new Font("Sitka Text", Font.BOLD, 18));
		puntuacion.setBackground(new Color(255,255,255));
		puntuacion.setBounds((int) (frameWidth * 0.08) + 20, (int) (frameHeight * 0.02), (int) (frameWidth * 0.3), 23);
		return puntuacion;
	}
	
	public JLabel setearInstruccion() {
		JLabel instruccion = new JLabel();
		instruccion.setForeground(new Color(225,0,0));
		instruccion.setFont(new Font("Sitka Text", Font.BOLD, (int) (frameWidth * 0.026)));
		instruccion.setBackground(new Color(225,0,0));
		instruccion.setBounds((int) (frameWidth * 0.245), (int) (frameHeight * 0.46), (int) (frameWidth * 0.6), 23);
		instruccion.setText("PRESIONE ESPACIO PARA COMENZAR");
		return instruccion;
	}
	
	public JLabel setearNombrePersonaje() {
		JLabel nombrePersonaje = new JLabel();
		nombrePersonaje.setForeground(new Color(255,255,255));
		nombrePersonaje.setFont(new Font("Sitka Text", Font.BOLD, (int) (frameWidth * 0.026)));
		nombrePersonaje.setBackground(new Color(255,0,0));
		return nombrePersonaje;
	}
	
	public JLabel setearFondo() {
		JLabel fondo = new JLabel();
		fondo.setSize(frameWidth, frameHeight);
		ImageIcon iconoOriginal = buscadorDeImagenes.buscarImagen("/ImageIcons/GIF de Fondo.gif");
		ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(frameWidth, frameHeight, java.awt.Image.SCALE_DEFAULT));
		fondo.setIcon(iconoEscala);
		return fondo;
	}
	
	public JLabel[] setearDrops() {
		String d = "Deshabilitado";
		JLabel[] drops = new JLabel[5];
		
		for(int i = 0; i < drops.length; i++)
			drops[i] = new JLabel();
		drops[0].setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropEscudo_"+d+".png"));
		drops[1].setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropDaño_"+d+".png"));
		drops[2].setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropSupermisil_"+d+".png"));
		drops[3].setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropCongelar_"+d+".png"));
		drops[4].setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropPerforador_"+d+".png"));
		
		for(int i = 0;i<drops.length;i++)
			drops[i].setSize(drops[i].getIcon().getIconHeight(), drops[i].getIcon().getIconWidth());
		
		drops[0].setBounds((int) (frameWidth * 0.001) + 10, (int) (frameHeight * 0.01), 100, 50);
		drops[1].setBounds((int) (frameWidth * 0.001) + 10, (int) (frameHeight * 0.08), 100, 50);
		drops[2].setBounds((int) (frameWidth * 0.001) + 10, (int) (frameHeight * 0.15), 100, 50);
		drops[3].setBounds((int) (frameWidth * 0.001) + 10, (int) (frameHeight * 0.22), 100, 50);
		drops[4].setBounds((int) (frameWidth * 0.001) + 10, (int) (frameHeight * 0.29), 100, 50);
		
		return drops;
	}
	
	public JLabel setearIconoVida() {
		JLabel iconoVida=new JLabel();
		iconoVida.setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/iconoDropVida.png"));
		iconoVida.setSize(iconoVida.getIcon().getIconHeight(),iconoVida.getIcon().getIconWidth());
		iconoVida.setBounds((int) (frameWidth * 0.001) + 10, (int) (frameHeight * 0.79), 100, 100);
		return iconoVida;
	}

	public JLabel setearIconoEscudo() {
		JLabel iconoEscudo=new JLabel();	
		iconoEscudo.setSize(60,60);
		iconoEscudo.setBounds((int) (frameWidth * 0.001) + 15, (int) (frameHeight * 0.69), 100, 100);
		return iconoEscudo;
	}

	public String obtenerNombre(JLabel nombrePersonaje) {
		String nombre = "";
		boolean valido = false, contieneEspacio;
		while (!valido) {
			nombre = JOptionPane.showInputDialog(null, "Ingrese un Nombre para el Personaje:");
			contieneEspacio = nombre.contains(" ") ? true : false;
			if (nombre != null && !nombre.equals("") && nombre.length() <= 8 && !contieneEspacio)
				valido = true;
			else
				JOptionPane.showMessageDialog(null, "Debe ingresarse un nombre sin espacios y de longitud mayor que 0 y menor o igual que 8.", "Ingreso Inválido", JOptionPane.ERROR_MESSAGE);
		}
		nombrePersonaje.setBounds((int) (frameWidth * 0.5 - nombre.length() * 10), (int) (frameHeight * 0.02), (int) (frameWidth * 0.6), 25);
		nombre = nombre.toUpperCase();
		nombrePersonaje.setText(nombre);
		return nombre;
	}
	
	
	public JLabel[] setearHighScores() {
		JLabel[] highScores = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			highScores[i] = new JLabel();
			highScores[i].setForeground(new Color(0,0,0));
			highScores[i].setFont(new Font("Sitka Text", Font.BOLD, 16));
			highScores[i].setBackground(new Color(0,0,0));
			highScores[i].setBounds((int) (frameWidth * 0.65), (int) (frameHeight * 0.56) + i * 19, (int) (frameWidth * 0.25), (int) (frameHeight * 0.25));
		}
		
		highScores[0].setText("PUNTUACIONES ALTAS:");
		
		try {
			BufferedReader br;
			FileReader fr = new FileReader("High Scores.txt");
			br = new BufferedReader(fr);
			
			for (int i = 1; i < 6; i++)
				highScores[i].setText(br.readLine());
			
			br.close();
		}
		catch(IOException exc) {
			System.out.println("Error al leer el archivo de High Scores.");
			exc.printStackTrace();
		}
		
		return highScores;
	}
}
