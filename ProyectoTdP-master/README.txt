*Controles del Juego:*
Al comenzar un Nivel, se debe presionar la tecla ESPACIO (como se lo indica en la pantalla).
El Jugador se mueve con las FLECHAS hacia la IZQUIERDA o hacia la DERECHA, o bien con las LETRAS A y D. No es posible moverse verticalmente.
Para disparar se debe presionar ESPACIO. 
Al terminar una partida (ganando o perdiendo), se puede presionar ENTER para iniciar una nueva. Adem�s, en la pantalla de victoria es posible
mover al Jugador hacia la izquierda y hacia la derecha con las teclas de movimiento mencionadas, pero no es posible disparar.



*Finales Posibles de una Partida:*
Victoria: Ganar el Juego implica completar sus dos Niveles. Para completar un Nivel, es necesario destruir sus tres Obst�culos y a todos sus
Enemigos, asegurando que el Jugador siga vivo para cuando esto se logre. Una vez que se termine el segundo Nivel, se pasar� a la pantalla de
victoria.

Derrota: Perder el Juego implica que se acabe la vida del Jugador. Cuando esto ocurra, se pasar� a la pantalla de derrota.



*Para la Ejecuci�n:*
En la carpeta del Proyecto no se incluye el archivo .jar. Esto se debe a que su tama�o es de 170 MB, lo que supera el l�mite de 100 MB por archivo
impuesto por GitHub. Por lo tanto, a continuaci�n se provee un link de descarga para este archivo:
https://drive.google.com/file/d/1qYIlSRIOjYZ74W0ZDI8w4EXCIYPU6y12/view?usp=sharing

El Proyecto y el archivo .jar fueron creados a trav�s de Java, usando sus Versiones 8 y 9. El archivo .jar podr� ser ejecutado con cualquiera de estas
dos versiones.

En la misma carpeta donde se tenga el archivo .jar llamado "XSOUP_GAME" se deber� tener el archivo .txt llamado "High Scores". Esto permitir� que
el dicho .tx pueda ser le�do y sobreescrito cuando corresponda hacerlo.



*Modificaciones del Enunciado y Comentarios sobre Implementaci�n:*
El Jugador y los Enemigos no son naves en el espacio, sino soldados en una playa.

Los disparos del Jugador no tienen un alcance ni una cadencia, sino que recorren la pantalla completa hasta llegar a su borde superior o hasta
colisionar con un Enemigo u Obst�culo. Se puede disparar cuantas veces se lo desee con la frecuencia que se lo desee, pero no es posible disparar
permanentemente: cada vez que se suelte la tecla ESPACIO se crear� un Disparo, por lo que mantener apretada esta tecla no traer� beneficio alguno.
Adem�s, no es posible moverse y disparar al mismo tiempo, lo que implica que se debe ser precavido y en muchas ocasiones es conveniente no disparar,
sino escapar para no recibir da�o.

El Jugador y los Enemigos no tienen una fuerza de impacto. Para un Enemigo, colisionar con el Jugador significa una muerte asegurada (lo que puede
ser aprovechado por el usuario para terminar Niveles o si se tiene un Escudo). Para el Jugador, colisionar con un Enemigo significa perder 30 puntos
de vida.

Los Enemigos no tienen Arma, sino que sus Inteligencias crean (si les corresponde por su tipo) objetos de tipo Disparo con posici�n incial igual a la
del Enemigo que tengan asociado.

Los Power-Ups son llamados "Drops".

El Arma del Jugador determina el da�o de sus Disparos, y cambia cuando se atrapan Drops que modifiquen el tipo de Disparo a crear.

Las colisiones entre Disparos y Disparos o Disparos y Drops no tienen consecuencias.

No hay "Friendly Fire".

Los Enemigos Kamikazes no le hacen da�o a los Obst�culos.

Los movimientos de los Drops no son aleatorios, sino que son en l�nea recta y hacia el borde inferior de la pantalla.

Los Enemigos armados s�lo se mueven hacia los lados, siendo mucho m�s frecuente su movimiento hacia la izquierda que hacia la derecha. Los Kamikazes
se mueven hacia los lados y hacia abajo. Cuando un Enemigo cruza uno de los bordes de la pantalla, aparece del otro lado, manteniendo su posici�n
vertical u horizontal seg�n el borde que haya cruzado.

El Jugador no puede moverse hacia los bordes de la pantalla, sino que en un punto cercano a ellos dejar� de avanzar, pudiendo solamente disparar
y dirigirse hacia el lado opuesto.

Los Disparos de los Enemigos y del Jugador siguen una trayectoria vertical.



*Tipos de Enemigos:*
El Enemigo blanco armado con una pistola es el que s�lo ataca mediante Disparos y nunca pierde esta caracter�stica.

El Enemigo marr�n armado con una pistola es el que comienza atacando mediante Disparos, pero al llegar al 20% de su vida inicial pierde esta
caracter�stica y comienza a atacar como un Kamikaze de B�squeda.

El Enemigo rojo es el Kamikaze de movimientos aleatorios.

El Enemigo azul es el Kamikaze de B�squeda (que busca al Jugador hasta colisionarlo o morir).

El Enemigo marr�n que tiene una dinamita en su mano es el Kamikaze Mezcla (que comienza como un Kamikaze de B�squeda pero se convierte en uno de
movimientos aleatorios al perder la mitad de su vida inicial).



*Tipos de Drops:*
Los Drops aparecen en forma de tortugas marinas de diferentes colores, y el color de cada una determina su tipo. Cada vez que se mate a un Enemigo
mediante Disparos (es decir, no por colisionar directamente contra �l) habr� un 40% de posibilidades de que la muerte de �ste genere un nuevo Drop.
A continuaci�n, se listan todos los Drops del Juego en orden decreciente de frecuencia de aparici�n.
+ Tortuga Violeta: S�per Misil. Da al Jugador una nueva Arma por un un breve tiempo, haciendo que sus Disparos tengan mayor da�o y �rea. Al concluir
		   el tiempo, el Jugador volver� a tener el Arma que hubiera tenido antes de agarrar este Drop.
+ Tortuga Verde: Poci�n de Vida. Aumenta la vida del Jugador en 20 unidades.
+ Tortuga Azul: Congelador de Enemigos. Todos los Enemigos dejar�n de moverse y disparar por un breve tiempo (pero aquellos Disparos o Drops que estuvieran
		en pantalla al momento de conseguir este Drop continuar�n su trayectoria). El Jugador podr� seguir disparando y movi�ndose a voluntad.
+ Tortuga Celeste: Escudo. Resiste los siguientes tres golpes que reciba el Jugador (mostrando un contador de Escudos a la izquierda de la pantalla que
		   se ir� reduciendo con cada golpe recibido). Cabe destacar que un "golpe" es un impacto con un Kamikaze o con un Disparo de Enemigo.
		   Los Escudos no se acumulan: si se tiene un Escudo y se consigue otro, se resistir�n los pr�ximos tres golpes (lo que es decir que un
		   Drop de este tipo reemplazar� a otro igual).
+ Tortuga Amarilla: Mejora de Disparo Perforador. Da al Jugador una nueva Arma hasta el final del Nivel, o hasta que consiga una Mejora de Da�o. Los
		    Disparos de la nueva Arma hacen el mismo da�o que los del Arma est�ndar del Jugador, pero no se detienen ante las colisiones, sino que
		    se desplazan hasta el final de la pantalla da�ando a todo Enemigo u Obst�culo que encuentren a su paso. Los Objetos colisionados se
		    da�ar�n s�lo una vez (un mismo Disparo s�lo golpear� una vez a un determinado Enemigo u Obst�culo).
+ Tortuga Roja: Mejora de Da�o. Da al Jugador una nueva Arma hasta el final del Nivel, o hasta que consiga una Mejora de Disparo Perforador. Los Disparos
		producidos por la nueva Arma tienen un da�o muy alto, destruyendo de un golpe a cualquier Enemigo u Obst�culo al que colisionen. Como los
		del Arma est�ndar, los Disparos del Arma de Mejora de Da�o se destruyen luego de colisionar por primera vez.