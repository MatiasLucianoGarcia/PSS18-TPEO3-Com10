package PaqueteArmas;

import PaqueteDisparos.Disparo;
import PaqueteDisparos.MegaDisparo;
import PaqueteJuego.GUI;

public class ArmaSupermisil extends Arma {
	
	
	public ArmaSupermisil(GUI g) {
		super();
		gui = g;
		da�o=20;
		cambiarImagenGUI();
	}
	public Disparo disparar(int x, int y) {
		return new MegaDisparo(x,y,da�o);
	}
	
	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(2, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropSupermisil_Habilitado.png"));
		gui.mostrarIconoDrop(1, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropDa�o_Deshabilitado.png"));
		gui.mostrarIconoDrop(4, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
	
	

}
