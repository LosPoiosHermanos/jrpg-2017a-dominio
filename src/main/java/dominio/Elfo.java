package dominio;
/**
 * Una de las posibles razas de personajes que el jugador puede elegir
 * La cual posee sus propias habilidades
 */

public class Elfo extends Personaje {

  /**
  * crea un personaje de raza "elfo" con nombre y casta enviados por parametro
  * {@param nombre}
  * {@param casta}
  * {@param id}
  */

  public Elfo(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    energiaTope += 10;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Elfo";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Level";
    habilidadesRaza[1] = "Ataque Bosque";
  }

  /**
  * crea un personaje de raza elfo con todas sus caracteristicas enviadas
  * por parametro (nombre, saluda, energia, fuerza, etc)
  * {@param nombre}
  * {@param salud}
  * {@param energia}
  * {@param fuerza}
  * {@param destreza}
  * {@param inteligencia}
  * {@param casta}
  * {@param experiencia}
  * {@param nivel}
  * {@param idPersonaje}
  */
  
  public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

  /**
  * permite el uso de la habilidad "Golpe Level" propia de la raza "elfo"
  * y establece sus efectos y condicion de uso
  */
  
  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
        return true;
      }
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "Ataque Bosque" propia de la raza "elfo"
  * y establece sus efectos y condicion de uso
  */
  
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      if (atacado.serAtacado((int) (this.magia)) > 0) {
        return true;  
      }
    }
    return false;
  }
}
