package dominio;

public class Objeto {

	protected String nombre;
	protected int atributo;
	protected String atributoModificado;
	protected MyRandom rand = new MyRandom();

	public Objeto() {

		int aleatorio = rand.nextInt(2) + 1;
		asignarObjeto(aleatorio);

	}

	public Objeto(MyRandomStub random) {
		asignarObjeto(random.getInt());
	}

	private void asignarObjeto(int valor) {
		switch (valor) {
		case 1:
			nombre = "Espada";
			atributo = 5;
			atributoModificado = "fuerza";
			break;
		case 2:
			nombre = "Guantes";
			atributo = 100;
			atributoModificado = "saludTope";
			break;
		case 3:
			nombre = "Botas";
			atributo = 5;
			atributoModificado = "destreza";
			break;
		default:
			break;
		}

	}

	public String getAtributoModificado() {
		return atributoModificado;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAtributo() {
		return atributo;
	}

	public MyRandom getRand() {
		return rand;
	}

}
