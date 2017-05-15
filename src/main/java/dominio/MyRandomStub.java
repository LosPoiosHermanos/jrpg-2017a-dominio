package dominio;
/**
 * 
 * Clase utilizada para poder probar los metodos con valores fijos
 *
 */
public class MyRandomStub extends RandomGenerator{
	
	private int valor;
	private double dFijo=0.49;
	
	public MyRandomStub(int valorFijo) {
		this.valor = valorFijo;
	}
	public MyRandomStub(int valorFijo, double dFijo) {
		this.valor = valorFijo;
		this.dFijo = dFijo;
	}

	@Override
	public int nextInt(int maximo) {
		return this.valor;
	}

	@Override
	public double nextDouble() {
		return dFijo;
	}

}
