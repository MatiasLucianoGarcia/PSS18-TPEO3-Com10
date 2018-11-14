package PaqueteArmas;

import PaqueteArmas.Arma;
import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoInstaKill;
import PaqueteJuego.GUI;

public class ArmaMejoraDaño extends Arma {
	
	
	public ArmaMejoraDaño(GUI g) {
		super();
		gui = g;
		daño = 100;
		cambiarImagenGUI();
	}
	
	public Disparo disparar(int x,int y) {
		return new DisparoInstaKill(x,y, daño);
	}

	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(1, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropDaño_Habilitado.png"));
		gui.mostrarIconoDrop(2, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
		gui.mostrarIconoDrop(4, gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
}
