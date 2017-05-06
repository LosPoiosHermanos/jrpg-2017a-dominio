package dominio;
/**
 * Tipo de personaje que puede tener un jugador, con habilidades propias de 
 * dicha casta para un Guerrero.
 *
 */

public class Guerrero extends Casta {

  /**
  * 
  * {@param prob_crit}
  * {@param evasion}
  * {@param daño_crit}
  */

  public Guerrero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Guerrero";
  }

  /**
  * crea la casta "Guerrero" con valores predeterminados
  */
  
  public Guerrero() {
    super();
    this.nombreCasta = "Guerrero";

    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Ataque Doble";
    habilidadesCasta[1] = "Aumentar Defensa";
    habilidadesCasta[2] = "Ignorar Defensa";
  }

  /**
  * permite el uso de la habilidad "Ataque Doble" propia de la casta "Guerrero"
  * y establece sus efectos y condicion de uso
   */
  
  public boolean habilidad1(Personaje caster, Peleable atacado) { 
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado.serAtacado(caster.ataque * 2) > 0) {
        return true;
      }
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "Aumentar Defensa" propia de la casta "Guerrero"
  * y establece sus efectos y condicion de uso
  */
  
  public boolean habilidad2(Personaje caster, Peleable atacado) { 
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      caster.setDefensa(caster.getDefensa() + caster.magia);
      return true;
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "Ignorar Defensa" propia de la casta "Guerrero"
  * y establece sus efectos y condicion de uso
  */
  
  public boolean habilidad3(Personaje caster, Peleable atacado) { 
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado instanceof Personaje) {
        int defensa_original = ((Personaje) atacado).getDefensa();
        ((Personaje) atacado).setDefensa(0);
        if (atacado.serAtacado(caster.ataque) > 0) {
          ((Personaje) atacado).setDefensa(defensa_original);
          return true;
        }
      }
    }
    return false;
  }
}
