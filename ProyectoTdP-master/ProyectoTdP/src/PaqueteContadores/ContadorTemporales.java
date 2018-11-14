package PaqueteContadores;

import PaqueteDrops.Temporales;

public class ContadorTemporales extends Thread {
	private Temporales drop;
	public ContadorTemporales(Temporales d) {
		super();
		drop=d;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(4000);
				drop.terminar();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
} 