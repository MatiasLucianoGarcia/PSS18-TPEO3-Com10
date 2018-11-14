package PaqueteDrops;

import java.util.Random;
import PaqueteJuego.GUI;

public class GeneradorDrops {
	private Drop muchos, varios, algunos, limitados, escasos, pocos;
	
	public GeneradorDrops(GUI gui) {
		muchos = new SuperMisil(0, 0, gui);
		varios = new SubirVida(0, 0, gui);
		algunos = new Congelar(0, 0, gui);
		limitados = new Escudo(0, 0, gui);
		escasos = new MejoraDisparoPerforador(0, 0, gui);
		pocos = new MejoraDaño(0, 0, gui);
	}
	
	public Drop generarDrop(int x, int y) {
		Random r = new Random();
		int eleccion = r.nextInt(105);
		Drop clon;
		
		if (eleccion < 5)
			clon = pocos.clone();
		else {
			if (eleccion < 15)
				clon = escasos.clone();
			else {
				if (eleccion < 30)
					clon = limitados.clone();
				else {
					if (eleccion < 50)
						clon = algunos.clone();
					else {
						if (eleccion < 75)
							clon = varios.clone();
						else
							clon = muchos.clone();
					}
				}
			}
		}
		
		clon.setPos(x, y);
		return clon;
	}
}
