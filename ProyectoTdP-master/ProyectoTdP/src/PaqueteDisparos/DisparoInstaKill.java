package PaqueteDisparos;


public class DisparoInstaKill extends Disparo {

	public DisparoInstaKill(int x, int y, int d) {
		super(x, y, d);
		grafico.setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/disparoSkull.png"));
		grafico.setSize(grafico.getIcon().getIconHeight(),grafico.getIcon().getIconWidth());
	}

}
