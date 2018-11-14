package PaqueteArmas;

public class MementoArma {
	Arma arma;
	public MementoArma(Arma a) {
		arma = a;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma ar) {
		arma = ar;
	}
}
