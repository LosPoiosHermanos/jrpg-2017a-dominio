package dominio;

import java.util.Random;

/**
 * devuelve valores aleatorios de tipo "int" o "double"
 */
public class MyRandom extends RandomGenerator {

	/**
	 * Devuelve un valor double aleatorio
	 * @return double valor aleatorio del tipo double
	 */
	@Override
	public double nextDouble() {
		return new Random().nextDouble();
	}

	/**
	 * Devuelve un valor int aleatorio menor al parametro max
	 * @param max Maximo valor que puede alcanzar
	 * @return int valor aleatorio del tipo entero
	 */
	@Override
	public int nextInt(final int max) {
		return new Random().nextInt(max);
	}
	
	@Override
	public int getInt() {
		return 0;
	}
}
