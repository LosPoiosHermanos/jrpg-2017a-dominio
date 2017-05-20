package dominio;
/**
 * Clase utilizada para poder probar los metodos con valores fijos
 */
public class MyRandomStub extends RandomGenerator {
	private static final double VALORFIJODOUBLE = 0.49;
	private int valorINT;
	private double valorDouble = VALORFIJODOUBLE;
	/**
	 * Constructor
	 * @param valorFijo Es el valorFijo que va a tener el random del tipo int
	 */
	public MyRandomStub(final int valorFijo) {
		this.valorINT = valorFijo;
	}
	/**
	 * Constructor
	 * @param valorFijo Es el valorFijo que va a tener el random del tipo int
	 * @param dFijo Es el valorFijo que va a tener el random del tipo double
	 */
	public MyRandomStub(final int valorFijo, final double dFijo) {
		this.valorINT = valorFijo;
		this.valorDouble = dFijo;
	}

	@Override
	public int nextInt(final int maximo) {
		return this.valorINT;
	}

	@Override
	public double nextDouble() {
		return valorDouble;
	}

}