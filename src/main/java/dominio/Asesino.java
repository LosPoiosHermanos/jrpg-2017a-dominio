package dominio;

import java.util.HashMap;

/**
 * Tipo de personaje que puede tener un jugador, con habilidades propias de
 * dicha casta para un asesino.
 */

public class Asesino extends Casta {

	private static final int ENERGIAMINIMA = 10;
	private static final double EVITARDANIO = 0.5;
	private static final double AUMENTOEVASION = 0.15;
	private static final int BONUSDESTREZA = 5;
	/**
	 * crea la casta "Asesino" con valores enviados por parametro
	 * @param probCritico Porcentaje del golpe critico
	 * @param evasion Porcentaje de Evasion
	 * @param ataqueCritico Daño por el golpe critico
	 */
	public Asesino(final double probCritico, final double evasion, final double ataqueCritico) {
		super(probCritico, evasion, ataqueCritico);
	}

	/**
	 * crea la casta "Asesino" con valores predeterminados
	 */
	public Asesino() {
		super();
	}

	/**
	 * permite el uso de la habilidad "Golpe Critico" del
	 * "Asesino" y establece sus efectos y condicion de uso
	 * @param caster Es el que castea la habilidad
	 * @param atacado Es el que ataca
	 * @return true Si se puede utilizar la habilidad del Golpe Critico
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			
			HashMap<String,Integer>mapa = new HashMap<String,Integer>();
			mapa.put("salud", caster.getSalud());
			mapa.put("energia", caster.getEnergia() - ENERGIAMINIMA);
			caster.actualizar(mapa);
			
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico()),
					new MyRandom()) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Aumentar Evasion" propia del "Asesino" y
	 * aumenta el valor de la probabilidad hasta un maximo del 50%
	 * @param caster Es el que castea la habilidad
	 * @param atacado Es el que ataca
	 * @return true Si se puede utilizar la habilidad del Evasion
	 */

	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			
			HashMap<String,Integer>mapa = new HashMap<String,Integer>();
			mapa.put("salud", caster.getSalud());
			mapa.put("energia", caster.getEnergia() - ENERGIAMINIMA);
			caster.actualizar(mapa);
			
			if (this.getProbabilidadEvitarDaño() + AUMENTOEVASION < EVITARDANIO) {
				this.probabilidadEvitarDaño += AUMENTOEVASION;
			} else {
				this.probabilidadEvitarDaño = EVITARDANIO;
			}
			return true;
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "robar" propia de la casta "Asesino" y
	 * establece sus efectos y condicion de uso
	 * @param caster Es el que castea la habilidad
	 * @param atacado Es el que ataca
	 * @return true Si se puede utilizar la habilidad del Evasion
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}

	@Override
	public int getBonusFuerza() {
		return 0;
	}

	@Override
	public int getBonusInteligencia() {
		return 0;
	}

	@Override
	public int getBonusDestreza() {
		return BONUSDESTREZA;
	}
	@Override
	public final String getNombreCasta() {
		return "Asesino";
	}
	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Golpe Critico", "Aumentar Evasion", "Robar"};
	}
}