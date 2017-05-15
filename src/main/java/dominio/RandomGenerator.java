package dominio;
/**
 * 
 * Clase utilizada para poder probar los metodos con valores fijos o no variando
 * entre las clases que heredan. si uso la clase {@link MyRandomStub} utilizare valores fijos
 * si uso {@link MyRandom} utilizares los valores random
 */
public abstract class RandomGenerator {
	
	public abstract int nextInt(int maximo);
	public abstract double nextDouble();
}
