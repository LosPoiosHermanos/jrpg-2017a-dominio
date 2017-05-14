package dominio;

import java.io.Serializable;

/**
  * 
  * Establece las habilidades basicas disponibles para todas las diferentes clases (o castas) de jugadores
 *
 */
public abstract class Casta implements Serializable {
  protected double probabilidadGolpeCritico;
  protected double probabilidadEvitarDaño;
  protected double dañoCritico;
  protected String nombreCasta;

  protected String[] habilidadesCasta;

  /**
  *  Establece el valor por defecto de las diferentes habilidades de la casta.
  */
  public Casta() {
    this.probabilidadGolpeCritico = 0.2;
    this.probabilidadEvitarDaño = 0.2;
    this.dañoCritico = 1.5;
  }

  /**
  * Establece las estadisticas para las diferentes habilidades de una casta determinada
  * 
  * {@param prob_crit}
  * {@param evasion}
  * {@param daño_crit}
  */
  
  public Casta(double prob_crit, double evasion, double daño_crit) {
    this.probabilidadGolpeCritico = prob_crit;
    this.probabilidadEvitarDaño = evasion;
    this.dañoCritico = daño_crit;
  }

  /**
  * Cada personaje tiene disponible 3 habilidades, siendo estas diferentes y con efectos distintos
  * dependiendo de que casta se trate
  */
  public abstract boolean habilidad1(Personaje caster, Peleable atacado);

  public abstract boolean habilidad2(Personaje caster, Peleable atacado);

  public abstract boolean habilidad3(Personaje caster, Peleable atacado);
  public abstract int getBonusFuerza();
  public abstract int getBonusInteligencia();
  public abstract int getBonusDestreza();

  public String getNombreCasta() {
    return this.nombreCasta;
  }

  /**
  * devuelve las habilidades de la casta
  * @return String[]
  */
  
  public String[] getHabilidadesCasta() {
    return habilidadesCasta;
  }

  /**
  * devuelve el valor de "probabilidadGolpeCritico"
  * @return double
  */
  
  public double getProbabilidadGolpeCritico() {
    return probabilidadGolpeCritico;
  }

  /**
  * establece un valor determinado para la habilidad de la casta "probabilidadGolpeCritico"
  * 
  * {@param probabilidadGolpeCritico}
  */
  
  public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }

  /**
  * devuelve el valor de "probabilidadEvitarDaño"
  * @return double
  */
  
  public double getProbabilidadEvitarDaño() {
    return probabilidadEvitarDaño;
  }

  /**
  * {@param probabilidadEvitarDaño} 
  * establece un valor para "probabilidadEvitarDaño"
  */
  
  public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
    this.probabilidadEvitarDaño = probabilidadEvitarDaño;
  }

  /**
  * devuelve el valor de "dañoCritico"
  * @return double
  */
  
  public double getDañoCritico() {
    return dañoCritico;
  }

  /**
  *{@param dañoCritico} 
  * establece un valor para "dañoCritico"
  */
  
  public void setDañoCritico(double dañoCritico) {
    this.dañoCritico = dañoCritico;
  }
}
