package PaqueteDrops;

import PaqueteArmas.ArmaSupermisil;
import PaqueteContadores.ContadorTemporales;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class SuperMisil extends Temporales {
	private Personaje p;
	private ContadorTemporales tiempo;
	
	public SuperMisil(int x, int y, GUI gui) {
		super(x, y,gui);
		tiempo = new ContadorTemporales(this);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleSupermisil.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.cambiarAarmaTemporal(new ArmaSupermisil(gui));
		p = personaje;
		tiempo.start();
	}
		
	public Drop clone() {
		return new SuperMisil(pos.x, pos.y, gui);
	}
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
		
	}
	
	@SuppressWarnings("deprecation")
	public void terminar() {
		gui.mostrarIconoDrop(2, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
		p.recuperarArma();
		tiempo.stop();
	}
	
}
