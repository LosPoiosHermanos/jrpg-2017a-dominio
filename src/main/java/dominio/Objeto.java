package dominio;

public class Objeto {

	protected Integer id;
	
	protected String nombre;
	protected int atributo;
	protected String atributoModificado;
	protected MyRandom rand = new MyRandom();
	

	public Objeto() {
		id = rand.nextInt(19) + 1;
		asignarObjeto();
	}

	public Integer getId() {
		return id;
	}

	public Objeto(int key) {
		id = key;
		asignarObjeto();
	}

	/**
	 * Los objetos dan bonus para los atributos : saludTope, energiaTope, destreza, defensa, inteligencia y fuerza
	 */
	private void asignarObjeto() {
		String matrizObjetos[][] = { { "Brazalete", "10", "saludTope" }, { "Collar", "25", "saludTope" },
				{ "Amuleto", "50", "saludTope" }, { "Botas", "10", "energiaTope" }, { "Anillo", "25", "energiaTope" },
				{ "Pendientes", "50", "energiaTope" }, { "Guantes", "5", "destreza" }, { "Shuriken", "15", "destreza" },
				{ "Katana", "25", "destreza" }, { "Casco", "10", "defensa" }, { "Escudo", "15", "defensa" },
				{ "Armadura", "20", "defensa" }, { "Capa", "10", "inteligencia" }, { "Sombrero", "20", "inteligencia" },
				{ "Cetro", "30", "inteligencia" }, { "Cuchillo", "5", "fuerza" }, { "Martillo", "10", "fuerza" },
				{ "Lanza", "15", "fuerza" }, { "Hacha", "20", "fuerza" }, { "Espada", "20", "fuerza" } };

		if (id > 0 && id < matrizObjetos.length) {
			nombre = matrizObjetos[id - 1][0];
			atributo = Integer.parseInt(matrizObjetos[id - 1][1]);
			atributoModificado = matrizObjetos[id - 1][2];
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
