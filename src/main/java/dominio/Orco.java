package dominio;

/**
 * Una de las posibles razas de personajes que el jugador puede elegir
 * La cual posee sus propias habilidades
 */

public class Orco extends Personaje {

  /**
  * crea un personaje de raza "orco" con nombre y casta enviados por parametro
  * {@param nombre}
  * {@param casta}
  * {@param id}
  */
  public Orco(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    saludTope += 10;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Orco";
    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Defensa";
    habilidadesRaza[1] = "Mordisco de Vida";
  }
	/**
	 * crea un personaje de raza orco con todas sus caracteristicas enviadas
	 * por parametro (nombre, saluda, energia, fuerza, etc)
	 * @param nombre
	 * @param salud
	 * @param energia
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 * @param casta
	 * @param experiencia
	 * @param nivel
	 * @param idPersonaje
	 */
	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

  /**
  * permite el uso de la habilidad "Golpe Defensa" propia de la raza "orco"
  * y establece sus efectos y condicion de uso
  */

  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
        return true;
      }
      return true;
    }
    return false;
  }
  
  /**
  * permite el uso de la habilidad "Mordisco de vida" propia de la raza "orco"
  * y establece sus efectos y condicion de uso
  */
  
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      int daño_causado = atacado.serAtacado(this.getFuerza());
      if (daño_causado > 0) {
        this.serCurado(daño_causado);
        return true;
      }
    }
    return false;
  }
}