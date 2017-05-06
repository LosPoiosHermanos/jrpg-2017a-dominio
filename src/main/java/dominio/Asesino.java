package dominio;
/**
 * Tipo de personaje que puede tener un jugador, con habilidades propias de 
 * dicha casta para un asesino.
 */

public class Asesino extends Casta {

  /**
  * crea la casta "Asesino" con valores enviados por parametro
  * {@param prob_crit}
  * {@param evasion}
  * {@param daño_crit}
  */
  public Asesino(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Asesino";
  }

  /**
  * crea la casta "Asesino" con valores predeterminados
  */
  public Asesino() {
    super();
    this.nombreCasta = "Asesino";
    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Golpe Critico";
    habilidadesCasta[1] = "Aumentar Evasion";
    habilidadesCasta[2] = "Robar";
  }

  /**
  * permite el uso de la habilidad "golpe critico" propia de la casta "Asesino"
  * y establece sus efectos y condicion de uso
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
        return true;
      }
        
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "evasion" propia de la casta "Asesino"
  * y establece sus efectos y condicion de uso
  */
  
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5) {
        this.probabilidadEvitarDaño += 0.15;
      } else {
        this.probabilidadEvitarDaño = 0.5; 
      }
        
      return true;
    }
    return false;
  }

  /**
  * permite el uso de la habilidad "robar" propia de la casta "Asesino"
  * y establece sus efectos y condicion de uso
  */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    return false;
  }
}