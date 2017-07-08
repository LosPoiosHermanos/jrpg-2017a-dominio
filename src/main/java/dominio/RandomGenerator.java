package dominio;

/**
 * Clase utilizada para poder probar los metodos con valores fijos o no variando
 * entre las clases que heredan. si uso la clase {@link MyRandomStub} utilizare
 * valores fijos si uso {@link MyRandom} utilizares los valores random
 */
public abstract class RandomGenerator {
	/**
	 * Devuelve un valor int aleatorio
	 * @param maximo Valor maximo que puede tomar
	 * @return int Valor aleatorio del tipo int
	 */
	public abstract int nextInt(int maximo);

	/**
	 * Devuelve un valor double aleatorio
	 * @return double Valor aleatorio del tipo double
	 */
	public abstract double nextDouble();
	/**
	 * Devuelve un valor int aleatorio
	 * @return int Valor adelatorio del tipo Int
	 */
	public abstract int getInt();
}
