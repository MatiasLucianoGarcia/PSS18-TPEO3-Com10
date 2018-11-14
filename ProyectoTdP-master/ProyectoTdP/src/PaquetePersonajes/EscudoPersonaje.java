package PaquetePersonajes;

public class EscudoPersonaje {
	protected boolean escudo = false;
	protected int cantEsc;
	
	public EscudoPersonaje() {}
	
	public void setEscudo(boolean esc) {
		escudo = esc;
		cantEsc = 3;
	}
	public boolean getEscudo() {
		return escudo;
	}
	public void chocoEscudo() {
		cantEsc--;
		if(cantEsc == 0)	
			escudo = false;
	}
	public int getCantEsc() {
		return cantEsc;
	}
}
