package PaqueteDisparos;

import PaqueteColisionadores.ColisionadorDisparoPersonaje;
import PaqueteObjetosGenericos.Objeto;
import TDAListaDE.ListaDoblementeEnlazada;
import TDAListaDE.Position;
import TDAListaDE.PositionList;

public class DisparoPerforador extends Disparo {
	private PositionList<Objeto> objetosColisionados;
	
	public DisparoPerforador(int x, int y, int d) {
		super(x, y, d);
		grafico.setIcon(buscadorDeImagenes.buscarImagen("/ImageIcons/Perforador.gif"));
		grafico.setSize(grafico.getIcon().getIconWidth(),grafico.getIcon().getIconHeight());
		objetosColisionados = new ListaDoblementeEnlazada<Objeto>();
	}
	
	public int colisionar(Objeto o) {
		if (!pertenece(o)) {
			objetosColisionados.addFirst(o);
			return o.serChocado(new ColisionadorDisparoPersonaje(this));
		}
		return 0;
	}
	
	public int morir() {
		if (pos.y <= 0) {
			grafico.setVisible(false);
			borrable = true;
		}
		return 0;
	}
	
	private boolean pertenece(Objeto o) {
		for (Position<Objeto> pos : objetosColisionados.positions()) {
			if (pos.element() ==  o)
				return true;
		}
		return false;
	}
}
