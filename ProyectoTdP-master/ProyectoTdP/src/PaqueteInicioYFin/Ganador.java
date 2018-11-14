package PaqueteInicioYFin;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import PaqueteArmas.ArmaDeVictoria;
import PaqueteJuego.GUI;

class Ganador {
	private GUI gui;
	
	public Ganador(GUI g) {
		gui = g;
		ganar();
		setearColores();
		gui.getPersonaje().setArma(new ArmaDeVictoria());
	}
	
	private void ganar() {
		try {
			BufferedReader br;
			FileReader fr = new FileReader("High Scores.txt");
			br = new BufferedReader(fr);
			String cadena;
			int lineaCambio = -1;
			String[] puntuaciones = new String[5];
			
			for (int i = 0; i < 5; i++) {
				cadena = br.readLine();
				puntuaciones[i] = cadena;
				if (lineaCambio == -1) {
					int j = 2;
					while (cadena.charAt(j - 1) != ' ')
						j++;
					String valorCad = cadena.substring(j);
					int valor = Integer.parseInt(valorCad);
					if (valor < gui.getPuntaje())
						lineaCambio = i;
				}
			}
			br.close();
			
			if (lineaCambio >= 0)
				actualizarTablaHighScores(lineaCambio, puntuaciones);
			
		}
		catch(IOException exc) {
			System.out.println("Error al leer el archivo de High Scores.");
			exc.printStackTrace();
		}
	}
	
		private void actualizarTablaHighScores(int lineaCambio, String[] archivoViejo) {
			try {
				File logFile = new File("High Scores.txt");
				BufferedWriter bw;
				FileWriter fw = new FileWriter(logFile);
				bw = new BufferedWriter(fw);
				for (int i = 0; i < lineaCambio; i++) {
					bw.write(archivoViejo[i]);
					bw.newLine();
				}
				
				bw.write(gui.getNombrePersonaje().getText() + " " + gui.getPuntaje());
				
				for (int j = lineaCambio + 1; j < 5; j++) {
					bw.newLine();
					bw.write(archivoViejo[j - 1]);
				}
				
				bw.close();
			}
			catch(IOException exc) {
				System.out.println("Error al sobreescribir el archivo de High Scores.");
				exc.printStackTrace();
			}
		}
	
	
	private void setearColores() {
		Color color = new Color(0, 0, 0);
		
		gui.getVida().setForeground(color);
		gui.getVida().setBackground(color);
		
		gui.getNombrePersonaje().setForeground(color);
		gui.getNombrePersonaje().setBackground(color);
		
		gui.getLvl().setForeground(color);
		gui.getLvl().setBackground(color);
		
		gui.getPuntuacion().setForeground(color);
		gui.getPuntuacion().setBackground(color);
	}
}
