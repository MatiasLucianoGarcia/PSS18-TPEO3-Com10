package PaqueteObjetosGenericos;

import java.awt.Point;

public abstract class Animado extends Objeto {
	protected int velocidad;
	
	protected Animado(int velocidad, int x, int y) {
		super(x, y);
		this.pos = new Point(x, y);
		this.velocidad = velocidad;
	}
	public abstract int recibirDaño(int d);
	
	public int getVida() {
		return vida;
	}
}
