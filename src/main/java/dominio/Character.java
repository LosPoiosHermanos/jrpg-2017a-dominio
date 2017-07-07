package dominio;

/**
 * Clase Abstracta de la cual heredan "Personaje" y "NonPlayableCharacter"
 * los atributos y funciones en comun
 */
public abstract class Character {

	protected int salud;
	protected int fuerza;
	protected int defensa;
	private String nombre;
	protected int nivel;
	protected Inventario inventario;
	/**
	 * Crea la casta "Character" con valores enviados por parametro
	 * @param salud Cantidad de salud
	 * @param fuerza Cantidad de fuerza
	 * @param defensa Cantidad de defensa
	 * @param nombre Nombre del Personaje
	 * @param nivel Cantidad de nivel
	 */
	public Character(final int salud, final int fuerza, final int defensa, final String nombre, final int nivel) {
		this.salud = salud;
		this.fuerza = fuerza;
		this.defensa = defensa;
		this.nombre = nombre;
		this.nivel = nivel;
		inventario = new Inventario();
	}

	/**
	 * devuelve el valor del atributo "salud"
	 * @return int Atributo de salud
	 */
	public int getSalud() {
		return salud;
	}
	/**
	 * establece un valor para el atributo "salud"
	 * @param salud Atributo salud
	 */
	public void setSalud(final int salud) {
		this.salud = salud;
	}
	/**
	 * devuelve el valor del atributo "fuerza"
	 * @return int Atributo de fuerza
	 */
	public int getFuerza() {
		return fuerza;
	}
	/**
	 * Establece un valor para el atributo "fuerza"
	 * @param fuerza Se ingresa el valor de fuerza
	 */
	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}
	/**
	 * devuelve el valor del atributo "defensa"
	 * @return int Devuelve el atributo Defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * establece un valor para el atributo "defensa"
	 * @param defensa Atributo de defensa
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}
	/**
	 * Devuelve el valor del atributo "nombre"
	 * @return String Nombre del personaje
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * establece un valor para el atributo "nombre"
	 * @param nombre Nombre del personaje
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve el valor del atributo "nivel"
	 * @return int Nivel del personaje
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * establece un valor para el atributo "nivel"
	 * @param nivel Nivel del personaje
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}
	/**
	 * Aumenta en 1 el nivel del personaje
	 */
	public void aumentarNivel() {
		nivel++;
	}
	/**
	 * Aumenta la salud del personaje segun el parametro,
	 * lo aumenta, no lo establece
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarSalud(final int aumento) {
		salud += aumento;
	}
	/**
	 * Aumenta la Fuerza del personaje segun el parametro,
	 * lo aumenta, no lo establece
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarFuerza(final int aumento) {
		fuerza += aumento;
	}
	/**
	 * Aumenta la defensa del personaje segun el parametro,
	 * lo aumenta, no lo establece
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarDefensa(final int aumento) {
		defensa += aumento;
	}
	/**
	 * Devuelve si el personaje esta vivo o no
	 * @return true si el personaje esta vivo
	 */
	public boolean estaVivo() {
		return salud > 0;
	}
	/**
	 * Permite un ataque del personaje no jugable contra otro personaje
	 * @param atacado Peleable que realiza el ataque
	 * @param random Numero random para esquivar el ataque
	 * @return int Del valor del danio realizado
	 */
	abstract int atacar(final Peleable atacado, final RandomGenerator random);
	/**
	 * reduce la salud del personaje no jugable cuando es atacado y
	 * devuelve el daño recibido, o devuelve cero si esquivo el golpe o su
	 * defensa es mayor que el daño del atacante
	 * @param danio El danio que hacer el atacante
	 * @param random Numero random para evitar el ataque
	 * @return danio devuelve el danio realizado
	 */
	abstract int serAtacado(final int danio, final  RandomGenerator random);
	/**
	 * Que pasa despues del turno
	 */
	public void despuesDeTurno() {
		
	}

	public int[] getIdDeObjetos() {

		return inventario.getIdObjetos();
	} 

}
