package dominio;

/**
 * Tipo de personaje que puede tener un jugador, con habilidades propias de
 * dicha casta para un hechicero.
 *
 */

public class Hechicero extends Casta {
	private static final int ENERGIAMINIMA = 10;
	private static final int BONUSINTELIGENCIA = 5;
	private static final double DANIOPORPUNTOSDEMAGIA = 1.5;
	/**
	 * crea la casta "Hechicero" con valores enviados por parametro
	 * @param probCritico Porcentaje del golpe critico
	 * @param evasion Porcentaje de Evasion
	 * @param ataqueCritico Daño por el golpe critico
	 */
	public Hechicero(final double probCritico, final double evasion, final double ataqueCritico) {
		super(probCritico, evasion, ataqueCritico);
	}

	/**
	 * crea la casta "Hechicero" con valores predeterminados
	 */

	public Hechicero() {
		super();
	}

	/**
	 * permite el uso de la habilidad "Bola de Fuego" propia de la casta
	 * "Hechicero" y establece sus efectos y condicion de uso
	 * @param caster Personaje que realiza la habilidad
	 * @param atacado Peleable a quien se le hace la accion de la habilidad
	 * @return true Si se pudo realizar la habilidad
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * DANIOPORPUNTOSDEMAGIA),
			new MyRandom()) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Curar Aliado" propia de la casta
	 * "Hechicero" y establece sus efectos y condicion de uso
	 * @param caster Personaje que realiza la habilidad
	 * @param aliado Peleable a quien se le hace la accion de la habilidad
	 * @return true Si se pudo realizar la habilidad
	 */
	public boolean habilidad2(final Personaje caster, final Peleable aliado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			aliado.serCurado(caster.calcularPuntosDeMagia());
			return true;
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Robar Energia y Salud" propia de la casta
	 * "Hechicero" y establece sus efectos y condicion de uso
	 * @param caster Personaje que realiza la habilidad
	 * @param atacado Peleable a quien se le hace la accion de la habilidad
	 * @return true Si se pudo realizar la habilidad
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (!atacado.isNPC()) {
				int energiaRobada =	((Personaje)
						atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje)
						atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
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
		return BONUSINTELIGENCIA;
	}
	@Override
	public int getBonusDestreza() {
		return 0;
	}
	  @Override
	  public final String getNombreCasta() {
			return "Hechicero";
		}
	  @Override
		public final String[] getHabilidadesCasta() {
		  return new String[] {"Bola de Fuego", "Curar Aliado", "Robar Energia y Salud"};
		}
}