package dominio;

/**
 * establece los personajes no manejables por el jugador (NPCs) y sus
 * estadisticas y atributos
 *
 */
public class NonPlayableCharacter implements Peleable {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private int nivel;
	private static final int DIFICULTADALEATORIA = -1;
	private static final double EVITARATAQUE = 0.15;
	private static final double DANIOATAQUE = 1.5;
	private static final int EXPERIENCIAPORNIVEL = 30;
	private static final int DIFERENTESDIFICULTADES = 3;
	private static final int FUERZABASE1 = 10;
	private static final int SALUDBASE1 = 30;
	private static final int DEFENSABASE1 = 2;
	private static final int AUMENTOFUERZA1 = 3;
	private static final int AUMENTOSALUD1 = 15;
	private static final int AUMENTODEFENSA1 = 1;
	private static final int FUERZABASE2 = 20;
	private static final int SALUDBASE2 = 40;
	private static final int DEFENSABASE2 = 5;
	private static final int AUMENTOFUERZA2 = 6;
	private static final int AUMENTOSALUD2 = 20;
	private static final int AUMENTODEFENSA2 = 2;
	private static final int FUERZABASE3 = 30;
	private static final int SALUDBASE3 = 50;
	private static final int DEFENSABASE3 = 4;
	private static final int AUMENTOFUERZA3 = 10;
	private static final int AUMENTOSALUD3 = 25;
	private static final int AUMENTODEFENSA3 = 4;
	/**
	 * Establece un personaje no jugable con determinados atributos basados en
	 * la dificultad elegida
	 * @param nombre Nombre del personaje
	 * @param nivel Nivel del personaje
	 * @param dificultadNPC Dificultad del NPC
	 * @param random Numero random para esquivar el ataque
	 */
	public NonPlayableCharacter(final String nombre, final int nivel,
			final int dificultadNPC, final RandomGenerator random) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == DIFICULTADALEATORIA) {
			dificultad = random.nextInt(DIFERENTESDIFICULTADES);
		} else {
			dificultad = dificultadNPC;
		}
		switch (dificultad) {
		case 0:
			this.fuerza = FUERZABASE1 + (nivel - 1) * AUMENTOFUERZA1;
			this.salud = SALUDBASE1 + (nivel - 1) * AUMENTOSALUD1;
			this.defensa = DEFENSABASE1 + (nivel - 1) * AUMENTODEFENSA1;
			break;
		case 1:
			this.fuerza = FUERZABASE2 + (nivel - 1) * AUMENTOFUERZA2;
			this.salud = SALUDBASE2 + (nivel - 1) * AUMENTOSALUD2;
			this.defensa = DEFENSABASE2 + (nivel - 1) * AUMENTODEFENSA2;
			break;
		case 2:
			this.fuerza = FUERZABASE3 + (nivel - 1) * AUMENTOFUERZA3;
			this.salud = SALUDBASE3 + (nivel - 1) * AUMENTOSALUD3;
			this.defensa = DEFENSABASE3 + (nivel - 1) * AUMENTODEFENSA3;
			break;
		}
	}

	/**
	 * Devuelve la experiencia que necesita por nivel * 30
	 * @return int Expeciencia por nivel
	 */
	public int otorgarExp() {
		return this.nivel * EXPERIENCIAPORNIVEL;
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
	 * Devuelve si el personaje esta vivo o no
	 * @return true si el personaje esta vivo
	 */
	public boolean estaVivo() {
		return salud > 0;
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
	 * permite un ataque del personaje no jugable contra otro personaje
	 * @param atacado Peleable que realiza el ataque
	 * @param random Numero random para esquivar el ataque
	 * @return int Del valor del danio realizado
	 */
	public int atacar(final Peleable atacado, final RandomGenerator random) {
		if (random.nextDouble() <= EVITARATAQUE) {
			return atacado.serAtacado((int) (this.getAtaque() * DANIOATAQUE), random);
		} else {
			return atacado.serAtacado(this.getAtaque(), random);
		}
	}

	/**
	 * reduce la defensa y salud del personaje no jugable cuando es atacado y
	 * devuelve el daño recibido, o devuelve cero si esquivo el golpe o su
	 * defensa es mayor que el daño del atacante
	 * @param danio El danio que hacer el atacante
	 * @param random Numero random para evitar el ataque
	 * @return danio devuelve el danio realizado
	 */
	public int serAtacado(final int danio, final  RandomGenerator random) {
		if (random.nextDouble() >= EVITARATAQUE) {
			int auxdanio = danio;
			auxdanio -= this.getDefensa() / 2;
			if (auxdanio > 0) {
				salud -= auxdanio;
				return auxdanio;
			}
			return 0;
		}
		return 0;
	}
	/**
	 * Que pasa despues del turno
	 */
	public void despuesDeTurno() {
	}
	/**
	 * Aumento de experiencia recibido por parametro
	 * @param exp Aumenta la Experiencia
	 */
	public void ganarExperiencia(final int exp) {

	}

	/**
	 * devuelve el valor del atributo "fuerza"
	 * @return fuerza Devuelve la fuerza como int
	 */
	@Override
	public int getAtaque() {
		return fuerza;
	}

	/**
	 * establece un valor para el atributo "ataque"
	 * @param ataque Es el atributo de ataque
	 */
	@Override
	public void setAtaque(final int ataque) {
		this.fuerza = ataque;
	}

	@Override
	public void serCurado(final int puntosDeMagia) {
	}
}