*Controles del Juego:*
Al comenzar un Nivel, se debe presionar la tecla ESPACIO (como se lo indica en la pantalla).
El Jugador se mueve con las FLECHAS hacia la IZQUIERDA o hacia la DERECHA, o bien con las LETRAS A y D. No es posible moverse verticalmente.
Para disparar se debe presionar ESPACIO. 
Al terminar una partida (ganando o perdiendo), se puede presionar ENTER para iniciar una nueva. Además, en la pantalla de victoria es posible
mover al Jugador hacia la izquierda y hacia la derecha con las teclas de movimiento mencionadas, pero no es posible disparar.



*Finales Posibles de una Partida:*
Victoria: Ganar el Juego implica completar sus dos Niveles. Para completar un Nivel, es necesario destruir sus tres Obstáculos y a todos sus
Enemigos, asegurando que el Jugador siga vivo para cuando esto se logre. Una vez que se termine el segundo Nivel, se pasará a la pantalla de
victoria.

Derrota: Perder el Juego implica que se acabe la vida del Jugador. Cuando esto ocurra, se pasará a la pantalla de derrota.



*Para la Ejecución:*
En la carpeta del Proyecto no se incluye el archivo .jar. Esto se debe a que su tamaño es de 170 MB, lo que supera el límite de 100 MB por archivo
impuesto por GitHub. Por lo tanto, a continuación se provee un link de descarga para este archivo:
https://drive.google.com/file/d/1qYIlSRIOjYZ74W0ZDI8w4EXCIYPU6y12/view?usp=sharing

El Proyecto y el archivo .jar fueron creados a través de Java, usando sus Versiones 8 y 9. El archivo .jar podrá ser ejecutado con cualquiera de estas
dos versiones.

En la misma carpeta donde se tenga el archivo .jar llamado "XSOUP_GAME" se deberá tener el archivo .txt llamado "High Scores". Esto permitirá que
el dicho .tx pueda ser leído y sobreescrito cuando corresponda hacerlo.



*Modificaciones del Enunciado y Comentarios sobre Implementación:*
El Jugador y los Enemigos no son naves en el espacio, sino soldados en una playa.

Los disparos del Jugador no tienen un alcance ni una cadencia, sino que recorren la pantalla completa hasta llegar a su borde superior o hasta
colisionar con un Enemigo u Obstáculo. Se puede disparar cuantas veces se lo desee con la frecuencia que se lo desee, pero no es posible disparar
permanentemente: cada vez que se suelte la tecla ESPACIO se creará un Disparo, por lo que mantener apretada esta tecla no traerá beneficio alguno.
Además, no es posible moverse y disparar al mismo tiempo, lo que implica que se debe ser precavido y en muchas ocasiones es conveniente no disparar,
sino escapar para no recibir daño.

El Jugador y los Enemigos no tienen una fuerza de impacto. Para un Enemigo, colisionar con el Jugador significa una muerte asegurada (lo que puede
ser aprovechado por el usuario para terminar Niveles o si se tiene un Escudo). Para el Jugador, colisionar con un Enemigo significa perder 30 puntos
de vida.

Los Enemigos no tienen Arma, sino que sus Inteligencias crean (si les corresponde por su tipo) objetos de tipo Disparo con posición incial igual a la
del Enemigo que tengan asociado.

Los Power-Ups son llamados "Drops".

El Arma del Jugador determina el daño de sus Disparos, y cambia cuando se atrapan Drops que modifiquen el tipo de Disparo a crear.

Las colisiones entre Disparos y Disparos o Disparos y Drops no tienen consecuencias.

No hay "Friendly Fire".

Los Enemigos Kamikazes no le hacen daño a los Obstáculos.

Los movimientos de los Drops no son aleatorios, sino que son en línea recta y hacia el borde inferior de la pantalla.

Los Enemigos armados sólo se mueven hacia los lados, siendo mucho más frecuente su movimiento hacia la izquierda que hacia la derecha. Los Kamikazes
se mueven hacia los lados y hacia abajo. Cuando un Enemigo cruza uno de los bordes de la pantalla, aparece del otro lado, manteniendo su posición
vertical u horizontal según el borde que haya cruzado.

El Jugador no puede moverse hacia los bordes de la pantalla, sino que en un punto cercano a ellos dejará de avanzar, pudiendo solamente disparar
y dirigirse hacia el lado opuesto.

Los Disparos de los Enemigos y del Jugador siguen una trayectoria vertical.



*Tipos de Enemigos:*
El Enemigo blanco armado con una pistola es el que sólo ataca mediante Disparos y nunca pierde esta característica.

El Enemigo marrón armado con una pistola es el que comienza atacando mediante Disparos, pero al llegar al 20% de su vida inicial pierde esta
característica y comienza a atacar como un Kamikaze de Búsqueda.

El Enemigo rojo es el Kamikaze de movimientos aleatorios.

El Enemigo azul es el Kamikaze de Búsqueda (que busca al Jugador hasta colisionarlo o morir).

El Enemigo marrón que tiene una dinamita en su mano es el Kamikaze Mezcla (que comienza como un Kamikaze de Búsqueda pero se convierte en uno de
movimientos aleatorios al perder la mitad de su vida inicial).



*Tipos de Drops:*
Los Drops aparecen en forma de tortugas marinas de diferentes colores, y el color de cada una determina su tipo. Cada vez que se mate a un Enemigo
mediante Disparos (es decir, no por colisionar directamente contra él) habrá un 40% de posibilidades de que la muerte de éste genere un nuevo Drop.
A continuación, se listan todos los Drops del Juego en orden decreciente de frecuencia de aparición.
+ Tortuga Violeta: Súper Misil. Da al Jugador una nueva Arma por un un breve tiempo, haciendo que sus Disparos tengan mayor daño y área. Al concluir
		   el tiempo, el Jugador volverá a tener el Arma que hubiera tenido antes de agarrar este Drop.
+ Tortuga Verde: Poción de Vida. Aumenta la vida del Jugador en 20 unidades.
+ Tortuga Azul: Congelador de Enemigos. Todos los Enemigos dejarán de moverse y disparar por un breve tiempo (pero aquellos Disparos o Drops que estuvieran
		en pantalla al momento de conseguir este Drop continuarán su trayectoria). El Jugador podrá seguir disparando y moviéndose a voluntad.
+ Tortuga Celeste: Escudo. Resiste los siguientes tres golpes que reciba el Jugador (mostrando un contador de Escudos a la izquierda de la pantalla que
		   se irá reduciendo con cada golpe recibido). Cabe destacar que un "golpe" es un impacto con un Kamikaze o con un Disparo de Enemigo.
		   Los Escudos no se acumulan: si se tiene un Escudo y se consigue otro, se resistirán los próximos tres golpes (lo que es decir que un
		   Drop de este tipo reemplazará a otro igual).
+ Tortuga Amarilla: Mejora de Disparo Perforador. Da al Jugador una nueva Arma hasta el final del Nivel, o hasta que consiga una Mejora de Daño. Los
		    Disparos de la nueva Arma hacen el mismo daño que los del Arma estándar del Jugador, pero no se detienen ante las colisiones, sino que
		    se desplazan hasta el final de la pantalla dañando a todo Enemigo u Obstáculo que encuentren a su paso. Los Objetos colisionados se
		    dañarán sólo una vez (un mismo Disparo sólo golpeará una vez a un determinado Enemigo u Obstáculo).
+ Tortuga Roja: Mejora de Daño. Da al Jugador una nueva Arma hasta el final del Nivel, o hasta que consiga una Mejora de Disparo Perforador. Los Disparos
		producidos por la nueva Arma tienen un daño muy alto, destruyendo de un golpe a cualquier Enemigo u Obstáculo al que colisionen. Como los
		del Arma estándar, los Disparos del Arma de Mejora de Daño se destruyen luego de colisionar por primera vez.