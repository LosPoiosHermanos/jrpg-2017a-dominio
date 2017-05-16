package dominio;

/**
 * Una de las posibles razas de personajes que el jugador puede elegir
 * La cual posee sus propias habilidades
 */

public class Orco extends Personaje {

	private static final int ENERGIAMINIMA = 10;
	private static final int CANTIDADHABILIDADES = 2;
	private static final int ENERGIAEXTRA = 5;
	private static final int SALUDEXTRA = 10;
  /**
  * crea un personaje de raza "orco" con nombre y casta enviados por parametro
  * @param nombre Nombre del Personaje
  * @param casta Clase Casta
  * @param id ID del personaje
  */
  public Orco(final String nombre, final Casta casta, final int id) {
    super(nombre, casta, id);
    saludTope += SALUDEXTRA;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Orco";
    habilidadesRaza = new String[CANTIDADHABILIDADES];
    habilidadesRaza[0] = "Golpe Defensa";
    habilidadesRaza[1] = "Mordisco de Vida";
  }
	/**
	 * crea un personaje de raza orco con todas sus caracteristicas enviadas
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
	public Orco(final String nombre, final int salud, final int energia, final int fuerza,
			final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

  /**
  * permite el uso de la habilidad "Golpe Defensa" propia de la raza "orco"
  * y establece sus efectos y condicion de uso
  * @param atacado Es el recibe el danio
  * @param random Numero random de evitar el danio
  * @return true Si se puede utilizar la habilidad del Golpe Defensa
  */

  public boolean habilidadRaza1(final Peleable atacado, final RandomGenerator random) {
    if (this.getEnergia() > ENERGIAMINIMA) {
      this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
      if (atacado.serAtacado(this.getDefensa() * 2, random) > 0) {
        return true;
      }
      return true;
    }
    return false;
  }
  /**
  * permite el uso de la habilidad "Mordisco de vida" propia de la raza "orco"
  * y establece sus efectos y condicion de uso
  * @param atacado Es el recibe el danio
  * @param random Numero random de evitar el danio
  * @return true Si se puede utilizar la habilidad del Mordisco de vida
  */
  public boolean habilidadRaza2(final Peleable atacado, final RandomGenerator random) {
    if (this.getEnergia() > ENERGIAMINIMA) {
      this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
      int danioCausado = atacado.serAtacado(this.getFuerza(), random);
      if (danioCausado > 0) {
        this.serCurado(danioCausado);
        return true;
      }
    }
    return false;
  }
}