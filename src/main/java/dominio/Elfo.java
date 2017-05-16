package dominio;

/**
 * Una de las posibles razas de personajes que el jugador puede elegir La cual
 * posee sus propias habilidades
 */

public class Elfo extends Personaje {

	private static final int ENERGIAMINIMA = 10;
	private static final int CANTIDADHABILIDADES = 2;
	private static final int ENERGIAEXTRA = 10;
	private static final int DANIOPORNIVEL = 10;
	/**
	 * crea un personaje de raza "elfo" con nombre y casta enviados por
	 * parametro
	 * @param nombre Nombre del Personaje
	 * @param casta Clase Casta
	 * @param id ID del personaje
	 */

	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		energiaTope += ENERGIAEXTRA;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";
		habilidadesRaza = new String[CANTIDADHABILIDADES];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * * crea un personaje de raza elfo con todas sus caracteristicas enviadas por
	 * parametro (nombre, saluda, energia, fuerza, etc)
	 * @param nombre Nombre del Personaje
	 * @param salud Cantidad de salud
	 * @param energia Cantidad de energia
	 * @param fuerza Cantidad de fuerza
	 * @param destreza Cantidad de destreza
	 * @param inteligencia Cantidad de inteligencia
	 * @param casta Clase Casta
	 * @param experiencia Cantidad de experiencia
	 * @param nivel Cantidad de nivel
	 * @param idPersonaje ID del personaje
	 */
	public Elfo(final String nombre, final int salud, final int energia, final int fuerza,
			final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * permite el uso de la habilidad "Golpe Level" propia de la raza "elfo" y
	 * realiza danio dependiendo de la fuerza + el nivel*10 del personaje, cuesta 10 de energia
	 * @param atacado Es el recibe el danio
	 * @param random Numero random de evitar el danio
	 * @return true Si se puede utilizar la habilidad del Golpe Level
	 */
	public boolean habilidadRaza1(final Peleable atacado, final RandomGenerator random) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * DANIOPORNIVEL, random) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Permite el uso de la habilidad "Ataque Bosque" propia de la raza "elfo" y
	 * realiza danio en el enemigo de forma aleatoria, cuesta 10 de energia
	 * @param atacado Es el recibe el danio
	 * @param random Numero random de evitar el danio
	 * @return true Si se puede utilizar la habilidad del Ataque Bosque
	 */
	public boolean habilidadRaza2(final Peleable atacado, final RandomGenerator random) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado((int) (this.magia), random) > 0) {
				return true;
			}
		}
		return false;
	}
}