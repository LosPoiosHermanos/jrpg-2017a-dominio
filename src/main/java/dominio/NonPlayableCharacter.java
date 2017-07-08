package dominio;

/**
 * establece los personajes no manejables por el jugador (NPCs) y sus
 * estadisticas y atributos
 *
 */
public class NonPlayableCharacter extends Character implements Peleable {

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
		super(0, 0, 0, nombre, nivel);
		int dificultad;
		if (dificultadNPC == DIFICULTADALEATORIA) {
			dificultad = random.nextInt(DIFERENTESDIFICULTADES);
		} else {
			dificultad = dificultadNPC;
		}		
		if (dificultad == 0) {
			this.setFuerza(FUERZABASE1 + (nivel - 1) * AUMENTOFUERZA1);
			this.setSalud(SALUDBASE1 + (nivel - 1) * AUMENTOSALUD1);
			this.setDefensa(DEFENSABASE1 + (nivel - 1) * AUMENTODEFENSA1);
		} else {
			if (dificultad == 1) {
				this.setFuerza(FUERZABASE2 + (nivel - 1) * AUMENTOFUERZA2);
				this.setSalud(SALUDBASE2 + (nivel - 1) * AUMENTOSALUD2);
				this.setDefensa(DEFENSABASE2 + (nivel - 1) * AUMENTODEFENSA2);
			} else {
				this.setFuerza(FUERZABASE3 + (nivel - 1) * AUMENTOFUERZA3);
				this.setSalud(SALUDBASE3 + (nivel - 1) * AUMENTOSALUD3);
				this.setDefensa(DEFENSABASE3 + (nivel - 1) * AUMENTODEFENSA3);
			}
		}
	}

	/**
	 * Devuelve la experiencia que necesita por nivel * 30
	 * @return int Expeciencia por nivel
	 */
	public int otorgarExp() {
		return this.getNivel() * EXPERIENCIAPORNIVEL;
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
	 * reduce la salud del personaje no jugable cuando es atacado y
	 * devuelve el dano recibido, o devuelve cero si esquivo el golpe o su
	 * defensa es mayor que el dano del atacante
	 * @param danio El danio que hacer el atacante
	 * @param random Numero random para evitar el ataque
	 * @return danio devuelve el danio realizado
	 */
	public int serAtacado(final int danio, final  RandomGenerator random) {
		if (random.nextDouble() >= EVITARATAQUE) {
			int auxdanio = danio;
			auxdanio -= this.getDefensa() / 2;
			if (auxdanio > 0) {
				this.setSalud(this.getSalud() - auxdanio);
				return auxdanio;
			}
			return 0;
		}
		return 0;
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
		return this.getFuerza();
	}

	/**
	 * establece un valor para el atributo "ataque"
	 * @param ataque Es el atributo de ataque
	 */
	@Override
	public void setAtaque(final int ataque) {
		this.setFuerza(ataque);
	}

	@Override
	public void serCurado(final int puntosDeMagia) {
	}
	@Override
 	public int serDesernegizado(final int danio) {
 		return 0;
 	}
 	@Override
 	public int serRobadoSalud(final int danio) {
 		return 0;
 	}
 	/**
 	 * Determina si es un NonPlayableCharacter
 	 * @return boolean Devuelve True siempre
 	 */
 	public boolean isNPC() {
 		return true;
 	}
}
