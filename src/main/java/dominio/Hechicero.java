package dominio;
/**
 * Tipo de personaje que puede tener un jugador, con habilidades propias de 
 * dicha casta para un hechicero.
 *
 */

public class Hechicero extends Casta {

  public Hechicero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Hechicero";
  }

  /**
  * crea la casta "Hechicero" con valores predeterminados
  */
  
  public Hechicero() {
    super();
    this.nombreCasta = "Hechicero";
    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Bola de Fuego";
    habilidadesCasta[1] = "Curar Aliado";
    habilidadesCasta[2] = "Robar Energia y Salud";
  }

  /**
  * permite el uso de la habilidad "Bola de Fuego" propia de la casta "Hechicero"
  * y establece sus efectos y condicion de uso
  */

  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5), new MyRandom()) > 0){
        return true; 
      }  
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "Curar Aliado" propia de la casta "Hechicero"
  * y establece sus efectos y condicion de uso
  */

  public boolean habilidad2(Personaje caster, Peleable aliado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      aliado.serCurado(caster.calcularPuntosDeMagia());
      return true;
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "Robar Energia y Salud" propia de la casta "Hechicero"
  * y establece sus efectos y condicion de uso
  */

  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado instanceof Personaje) {
        int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
        int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
        caster.serEnergizado(energia_robada);
        caster.serCurado(salud_robada);
        return true;
      }
    }
    return false;
  }

@Override
public int getBonusFuerza() {
	return 0;
}

@Override
public int getBonusInteligencia() {
	return 5;
}

@Override
public int getBonusDestreza() {
	return 0;
}
}