package dominio;

/**
 * Interfaz para gestionar luchas entre personajes
 *
 */

public interface Peleable {
	/**
	 * @param danio es el valor del danio
	 * @param random Numero random
	 * @return int el danio que se le hizo al personaje
	 */
	int serAtacado(int danio, RandomGenerator random);
	/**
	 * Devuelve la salud
	 * @return int Es la salud del personaje
	 */
	int getSalud();
	/**
	 * Despues del turno
	 */
	void despuesDeTurno();
	/**
	 * Realiza la accion de atacar a otro personaje
	 * @param atacado A quien ataca el personaje
	 * @param random Numero random
	 * @return devuelve el danio que se le hizo al personaje atacado
	 */
	int atacar(Peleable atacado, RandomGenerator random);
	/**
	 * Se le ingresa la Experiencia
	 * @return int devuelve la experiencia dependiendo del nivel
	 */
	int otorgarExp();
	/**
	 * Devuelve el ataque como Int
	 * @return int Es el ataque
	 */
	int getAtaque();
	/**
	 * Ingresa el ataque
	 * @param ataque Atributo de ataque
	 */
	void setAtaque(int ataque);
	/**
	 * Devuelve el estado del personaje, true si esta vivo
	 * @return true Devuelte true si el personaje esta vivo, sino false
	 */
	boolean estaVivo();
	/**
	 * Devuelve el nombre
	 * @return String Se recibo el nombre en forma de String
	 */
	String getNombre();
	/**
	 * Se cura dependiendo de los puntos de Magia que tenga
	 * @param puntosDeMagia Atributo de Magia que depende de la Inteligencia
	 */
	void serCurado(int puntosDeMagia);
}
