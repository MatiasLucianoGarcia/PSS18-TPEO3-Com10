package PaqueteArmas;

import PaqueteDisparos.Disparo;
import PaqueteDisparos.MegaDisparo;
import PaqueteJuego.GUI;

public class ArmaSupermisil extends Arma {
	
	
	public ArmaSupermisil(GUI g) {
		super();
		gui = g;
		daño=20;
		cambiarImagenGUI();
	}
	public Disparo disparar(int x, int y) {
		return new MegaDisparo(x,y,daño);
	}
	
	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(2, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropSupermisil_Habilitado.png"));
		gui.mostrarIconoDrop(1, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropDaño_Deshabilitado.png"));
		gui.mostrarIconoDrop(4, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
	
	

}
