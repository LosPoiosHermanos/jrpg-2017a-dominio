package dominio;

/**
 * Una de las posibles razas de personajes que el jugador puede elegir La cual
 * posee sus propias habilidades
 */

public class Humano extends Personaje {

	private static final int ENERGIAMINIMA = 10;
	private static final int CANTIDADHABILIDADES = 2;
	private static final int ENERGIAEXTRA = 5;
	private static final int SALUDEXTRA = 5;
	/**
	 * crea un personaje de raza "Humano" con nombre y casta enviados por
	 * parametro
	 * @param nombre Nombre del personaje
	 * @param casta Clase Casta
	 * @param id ID del personaje
	 */
	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		saludTope += SALUDEXTRA;
		energiaTope += ENERGIAEXTRA;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	/**
	 * crea un personaje de raza humano con todas sus caracteristicas enviadas
	 * por parametro (nombre, saluda, energia, fuerza, etc)
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
	public Humano(final String nombre, final int salud, final int energia, final int fuerza,
			final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";
		habilidadesRaza = new String[CANTIDADHABILIDADES];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * permite el uso de la habilidad "Incentivar" propia de la raza "humano" y
	 * realiza danio segun el ataque + la magia, cuesta 10 de Energia
	 * @param atacado Es el recibe el danio
	 * @param random Numero random de evitar el danio
	 * @return true Si se puede utilizar la habilidad del Golpe Critico
	 */
	public boolean habilidadRaza1(final Peleable atacado, final RandomGenerator random) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Golpe Fatal" propia de la raza "humano" y
	 * reduce a la mitad la Salud del enemigo pero cuesta la mitad de la Energia
	 * @param atacado Es el recibe el danio
	 * @param random Numero random de evitar el danio
	 * @return true Si se puede utilizar la habilidad del Golpe Critico
	 */
	public boolean habilidadRaza2(final Peleable atacado, final RandomGenerator random) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			if (atacado.serAtacado(atacado.getSalud() / 2, random) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
		return false;
	}
}
