package PaqueteDrops;

import PaqueteEnemigos.Enemigo;
import PaqueteJuego.GUI;
import TDAListaDE.Position;
import PaquetePersonajes.Personaje;

public class Congelar extends Drop{
	public Congelar(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleCongelar.gif"));
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mejorar(Personaje personaje) {
		for (Position<Enemigo> en : gui.getListaEnemigos().positions()) {
			en.element().frenar();
		}
		gui.mostrarIconoDrop(3, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropCongelar_Habilitado.png"));
		personaje.setCongelarPoder(true);
	}

	public Drop clone() {
		return new Congelar(pos.x, pos.y, gui);
	}
}
	
