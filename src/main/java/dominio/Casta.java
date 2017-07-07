package dominio;

import java.io.Serializable;

/**
 * Establece las habilidades basicas disponibles para todas las diferentes
 * clases (o castas) de jugadores
 *
 */
public abstract class Casta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;
	protected String[] habilidadesCasta;
	private static final double GOLPECRITICO = 0.2;
	private static final double EVITARDANIO = 0.2;
	private static final double DANIOCRITICO = 1.5;
	//CONSTRUCTORES
	/**
	 * Establece el valor por defecto de las diferentes habilidades de la casta.
	 */
	public Casta() {
		this.probabilidadGolpeCritico = GOLPECRITICO;
		this.probabilidadEvitarDaño = EVITARDANIO;
		this.dañoCritico = DANIOCRITICO;
	}
	/**
	 * Establece las estadisticas para las diferentes habilidades de una casta
	 * determinada
	 * @param probCritico Porcentaje del golpe critico
	 * @param evasion Porcentaje de Evasion
	 * @param ataqueCritico Daño por el golpe critico
	 */
	public Casta(final double probCritico, final double evasion, final double ataqueCritico) {
		this.probabilidadGolpeCritico = probCritico;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = ataqueCritico;
	}
	//METODOS ABSTRACTOS
	/**
	 * Cada personaje tiene disponible 3 habilidades, siendo estas diferentes y
	 * con efectos distintos dependiendo de que casta se trate
	 * @param caster Personaje que realiza la habilidad
	 * @param atacado Peleable que es atacado
	 * @return true si se pudo realizar la habilidad
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);
	/**
	 * Cada personaje tiene disponible 3 habilidades, siendo estas diferentes y
	 * con efectos distintos dependiendo de que casta se trate
	 * @param caster Personaje que realiza la habilidad
	 * @param atacado Peleable que es atacado
	 * @return true si se pudo realizar la habilidad
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);
	/**
	 * Cada personaje tiene disponible 3 habilidades, siendo estas diferentes y
	 * con efectos distintos dependiendo de que casta se trate
	 * @param caster Personaje que realiza la habilidad
	 * @param atacado Peleable que es atacado
	 * @return true si se pudo realizar la habilidad
	 */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);
	/**
	 * Devuelve el bonus de Fuerza del personaje
	 * @return int Bonus de Fuerza
	 */
	public abstract int getBonusFuerza();
	/**
	 * Devuelve el bonus de Inteligencia del personaje
	 * @return int Bonus de Inteligencia
	 */
	public abstract int getBonusInteligencia();
	/**
	 * Devuelve el bonus de Destreza del personaje
	 * @return int Bonus de Destreza
	 */
	public abstract int getBonusDestreza();
	//METODOS
	/**
	 * Devuelve el nombre del personaje
	 * @return String Nombre de la Casta
	 */
	public String getNombreCasta() {
		return this.nombreCasta;
	}
	/**
	 * devuelve las habilidades de la casta
	 * @return String[] Devuelve un String de la habilidad/es
	 */
	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}
	/**
	 * devuelve el valor de "probabilidadGolpeCritico"
	 * @return double devuelve probabilidadGolpeCritico
	 */
	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}
	/**
	 * establece un valor determinado para la habilidad de la casta probabilidadGolpeCritico
	 * @param probabilidadGolpeCritico Se establece probabilidadGolpeCritico
	 */
	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}
	/**
	 * devuelve el valor de "probabilidadEvitarDaño"
	 * @return double Devuelve Probabilidad de Evitar el daño
	 */
	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}
	/**
	 *  establece un valor para probabilidadEvitarDaño
	 *  @param probabilidadEvitarDaño Se establece Probabilidad de Evitar el daño
	 */
	public void setProbabilidadEvitarDaño(final double probabilidadEvitarDaño) {
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
	 * @param dañoCritico establece un valor para "dañoCritico"
	 */
	public void setDañoCritico(final double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
}
