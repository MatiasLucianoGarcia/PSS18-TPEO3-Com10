package BuscadoresDeArchivos;

import javax.swing.ImageIcon;

public class ImageFinder {
	public ImageFinder() {}
	
	public ImageIcon buscarImagen(String ruta){
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(ruta));
		return imagen;
	}
}
