package dominio;

public class Objeto {

	private Integer id;
	private static final int CANTIDADDEOBJETOS = 19;
	protected String nombre;
	protected int valor;
	protected String atributoModificado;
	protected MyRandom rand = new MyRandom();

	public Objeto() {
		id = rand.nextInt(CANTIDADDEOBJETOS) + 1;
		asignarObjeto();
	}
	/**
	 * Creo un objeto con una key definida
	 * @param key Numero del ID del objeto a crear
	 */
	public Objeto(final int key) {
		id = key;
		asignarObjeto();
	}

	/**
	 * Los objetos dan bonus para los atributos : saludTope, energiaTope,
	 * destreza, defensa, inteligencia y fuerza
	 */
	private void asignarObjeto() {
		String matrizObjetos[][] = {{"Brazalete", "10", "saludTope" },
				{"Collar", "25", "saludTope" },	{"Amuleto", "50", "saludTope" },
				{"Botas", "10", "energiaTope" }, {"Anillo", "25", "energiaTope" },
				{"Pendientes", "50", "energiaTope" }, {"Guantes", "5", "destreza" },
				{"Shuriken", "15", "destreza" }, {"Katana", "25", "destreza" },
				{"Casco", "10", "defensa" }, {"Escudo", "15", "defensa" },
				{"Armadura", "20", "defensa" }, {"Capa", "10", "inteligencia" },
				{"Sombrero", "20", "inteligencia" },{"Cetro", "30", "inteligencia" },
				{"Cuchillo", "5", "fuerza" }, {"Martillo", "10", "fuerza" },
				{"Lanza", "15", "fuerza" }, {"Hacha", "20", "fuerza" },
				{"Espada", "20", "fuerza" } };

		if (id > 0 && id < matrizObjetos.length) {
			nombre = matrizObjetos[id - 1][0];
			valor = Integer.parseInt(matrizObjetos[id - 1][1]);
			atributoModificado = matrizObjetos[id - 1][2];
		}

	}
	/**
	 * Obtengo el atributo que modifica el objeto
	 * @return String Nombre del atributo modificado
	 */
	public String getAtributoModificado() {
		return atributoModificado;
	}
	/**
	 * Obtengo el nombre del objeto
	 * EJ: Casco, Espada, Hacha
	 * @return String nombre del objeto
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Obtengo el valor Int del objeto
	 * ej: Espada +20
	 * @return int el valor del objeto
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * Genera un numero random
	 * @return MyRandom numero random
	 */
	public MyRandom getRand() {
		return rand;
	}
	/**
	 * Obtengo el ID del objeto
	 * @return Integer ID del objeto
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Se le ingresa una ID al objeto
	 * @param id Integer como ID del objeto
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

}
