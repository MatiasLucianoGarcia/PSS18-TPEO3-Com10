package PaqueteJuego;

import PaqueteEnemigos.*;
import PaqueteObstaculos.*;
import PaquetePersonajes.Jugador;
import PaquetePersonajes.Personaje;

public class Mapa {
	private final int Xmax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int Ymax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private int dificultad;
	private int cantArmados, cantAP, cantKA, cantKB, cantKM, x = 0, y = 0;
	private final int maxEnemigos = 20;
	private final int posXObstaculo1 =  (int) (Xmax*0.08), posXObstaculo2 = (int) (Xmax*0.256), posXObstaculo3 = (int) (Xmax*0.43), posYObstaculo = (int) (Ymax*0.5);
	protected final int posXJugador = (int) (Xmax*0.275), posYJugador = (int) (Ymax*0.73);
	private Terna[][] matrizPosiciones;
	private Juego juego;
	private Personaje jugador;
	
	/* LA CLASE MAPA:
	 * Una matriz que determina si una posición de las iniciales está o no ocupada, y cuáles son sus valores (x,y) en el frame de la GUI.
	 * 
	 * Primero, se determina la cantidad de cada tipo de enemigo en una forma pseudo-aleatoria, dependiendo de la dificultad con la que se esté tratando.
	 * Esto permite tener un control del modo en que se generan los enemigos y las cantidades de cada uno para cada nivel, en lugar de dejarlo librado al azar puro.
	 * Así, se garantiza que los niveles superiores (si es que fueran a agregarse más niveles en un futuro) presenten más Kamikazes que los inferiores.
	 * Después, se crean todos los enemigos armados (los que pierden el arma y los que no) en posiciones aleatorias de esa matriz,
	 * controlando que no se cree más de un enemigo por posición.
	 * Por último, se llenan los lugares vacíos con los Kamikazes, ubicando primero a los Buscadores, luego a los Mezcla y finalmente a los Aleatorios
	 * para que los buscadores tengan que hacer un mayor recorrido.
	 */
	
	
	private class Terna {
		private boolean ocupado;
		private int posX, posY;
		
		//Constructor:
		public Terna(int x, int y) {
			ocupado = false;
			posX = x;
			posY = y;
		}
		
		
		//Comandos y Consultas:
		public void setOcupado(boolean o) {
			ocupado = o;
		}
		public boolean getOcupado() {
			return ocupado;
		}
		
		public int getPosX() {
			return posX;
		}
		public int getPosY() {
			return posY;
		}
	}
	
	/* Con una dificultad baja (menor o igual que 1) se crean pocos Kamikazes.
	 *  Con una alta (mayor o igual que 2) se crean varios más.
	 */
	public Mapa (int dif, Juego ju, int vidaPer) {
		dificultad = dif;
		juego = ju;
		int x, y;
		matrizPosiciones = new Terna[4][5];
		for (int i = 0; i < 4; i++) {
			y = (i + 1) * (int) (Ymax*0.07);
			for (int j = 0; j < 5; j++) {
				x = ((j + 1) * (int) (Xmax*0.095));
				if (i % 2 == 0)
					matrizPosiciones[i][j] = new Terna(x - 40, y);
				else
					matrizPosiciones[i][j] = new Terna(x, y);
			}
		}
		crearJugador(vidaPer);
		crearEnemigos();
		crearBarricadas();
	}
	
	
	private void crearEnemigos() {
		if (dificultad < 2)
			definirCantidades(10, 14, 2, 12, 1);
		else
			definirCantidades(7, 11, 4, 9, 2);
		situarEnemigos();
	}
	
		private void definirCantidades(int min, int max, int kb, int mitad, int km) {
			do {
				cantArmados = new java.util.Random().nextInt(max + 1);
			} while (cantArmados < min); //Habrá entre 'min' y 'max' enemigos armados.
			
			if (cantArmados == min)
				cantAP = 3;
			else
				cantAP = (cantArmados == max) ? 6 : 4;
			
			cantKB = kb;
			
			if (cantArmados < mitad) {
				cantKA = 5;
				cantKM = maxEnemigos - (cantArmados + cantKA + cantKB);
			}
			else {
				if (cantArmados < max) {
					cantKA = 4;
					cantKM = maxEnemigos - (cantArmados + cantKA + cantKB);
				}
				else { //'cantArmados' es igual a 'max'
					cantKA = 3;
					cantKM = km;
				}
			}
		}
		
		private void situarEnemigos() {
			for (int i = 0; i < cantArmados - cantAP; i++) //Situar Enemigos que no pierden el arma.
				situarArmado(new ITieneArma(jugador));
			for (int i = 0; i < cantAP; i++) //Situar Enemigos que pierden el arma.
				situarArmado(new ITAP(jugador));
			int cont = 0; boolean quedan = true;
			for (int i = 0; i < 4 && quedan; i++) { //Situar Kamikazes.
				for (int j = 0; j < 5 && quedan; j++) {
					if (!matrizPosiciones[i][j].getOcupado()) { //No es necesario asignarle verdadero al atributo 'ocupado' de esta posición en este punto pues ya no se lo evaluará.
						cont++;
						Enemigo enem;
						if (cont <= cantKB)
							enem = nuevoEnemigo(new IKB(jugador), i, j);
						else {
							if (cont <= cantKB + cantKM)
								enem = nuevoEnemigo(new IKM(jugador), i, j);
							else
								enem = nuevoEnemigo(new IKA(jugador), i, j);
						}
						juego.agregarEnemigo(enem);
						if (cont == cantKB + cantKM + cantKA)
							quedan = false;
					}
				}
			}
		}
		private void situarArmado(Inteligencia in) {
			do {
				x = new java.util.Random().nextInt(4);
				y = new java.util.Random().nextInt(5);
			} while (matrizPosiciones[x][y].getOcupado()); //Deja de buscar cuando encuentra una posición vacía.
			matrizPosiciones[x][y].setOcupado(true);
			Enemigo enem = nuevoEnemigo(in, x, y);
			juego.agregarEnemigo(enem);
		} //Dado que a lo sumo habrá 14 enemigos armados, el proceso de búsqueda de una posición será rápido.
		
		private Enemigo nuevoEnemigo(Inteligencia in ,int i,int j) {
			return new Enemigo(in, matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
		}
	
		
	private void crearBarricadas() {
		BarricadaEnemigos barr2 = new BarricadaEnemigos(posXObstaculo2, posYObstaculo);
		juego.agregarObstaculo(1, barr2);
		
		if (dificultad < 2) {
			DestruiblePorTodos dest1 = new DestruiblePorTodos(posXObstaculo1, posYObstaculo);	
			DestruiblePorTodos dest3 = new DestruiblePorTodos(posXObstaculo3, posYObstaculo);
			juego.agregarObstaculo(0, dest1);
			juego.agregarObstaculo(2, dest3);
		}
		else {
			BarricadaEnemigos barr1 = new BarricadaEnemigos(posXObstaculo1, posYObstaculo);
			BarricadaEnemigos barr3 = new BarricadaEnemigos(posXObstaculo3, posYObstaculo);
			juego.agregarObstaculo(0, barr1);
			juego.agregarObstaculo(2, barr3);
		}
	}
	
	
	private void crearJugador(int vidaPer) {
		jugador = new Jugador(7, posXJugador, posYJugador, vidaPer);
		juego.setPersonaje(jugador);
	}
}
