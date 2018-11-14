package PaqueteArmas;

import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoPerforador;
import PaqueteJuego.GUI;

public class ArmaDisparoPerforador extends Arma {
	
	
	public ArmaDisparoPerforador(GUI g) {
		super();
		gui = g;
		cambiarImagenGUI();
	}
	
	public Disparo disparar(int x, int y) {
		return new DisparoPerforador(x, y, daño);
	}

	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(4, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropPerforador_Habilitado.png"));
		gui.mostrarIconoDrop(1, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropDaño_Deshabilitado.png"));
		gui.mostrarIconoDrop(2, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
	}

}
