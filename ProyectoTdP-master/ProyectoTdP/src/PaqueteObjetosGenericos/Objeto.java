package PaqueteObjetosGenericos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import PaqueteColisionadores.Colisionador;
import java.awt.Image;
import java.awt.Point;

public abstract class Objeto {
	protected static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	protected static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	
	protected int vida;
	protected JLabel grafico;
	protected Point pos;   
	
	protected Objeto(int x, int y) {
		pos = new Point(x, y);
		grafico = new JLabel();
	}

	public Point getPos() {
		return pos;
	}
	public int getVida() {
		return vida;
	}
		
	protected abstract void setGrafico();
	
	public JLabel getGrafico() {
		if(grafico == null)
			grafico = new JLabel();
		return grafico;
	}
	
	
	protected abstract int morir();
	
	public abstract int colisionar(Objeto o);
	
	/* El objetivo de este método es poder mover a todos los objetos usando hilos.
	 * Los objetos que tenga un movimiento lo redefinirán. Los que no, simplemente lo dejarán vacío.
	 * */
	public void mover() {}
	
	protected Image escalarGrafico(ImageIcon original) {
		return original.getImage().getScaledInstance(grafico.getWidth(), grafico.getHeight(), java.awt.Image.SCALE_DEFAULT);
	}
	
	public abstract int serChocado(Colisionador c); //Debe retornar un entero para administrar los puntajes.
}
