package dominio;

import java.util.HashMap;

/**
 * Tipo de personaje que puede tener un jugador, con habilidades propias de
 * dicha casta para un Guerrero.
 *
 */

public class Guerrero extends Casta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ENERGIAMINIMA = 10;
	private static final int BONUSFUERZA = 5;

	/**
	 * crea un personaje de raza "Guerrero" con nombre y casta enviados por
	 * parametro
	 * @param probCritico Porcentaje del golpe critico
	 * @param evasion Porcentaje de Evasion
	 * @param ataqueCritico Daño por el golpe critico
	 */
	public Guerrero(final double probCritico, final double evasion, final double ataqueCritico) {
		super(probCritico, evasion, ataqueCritico);
	}

	/**
	 * crea la casta "Guerrero" con valores predeterminados
	 */
	public Guerrero() {
		super();
	}

	/**
	 * permite el uso de la habilidad "Ataque Doble" propia de la casta
	 * "Guerrero" y establece sus efectos y condicion de uso
	 * @param caster Es el que realiza la habilidad
	 * @param atacado Es el que recibe el danio
	 * @return true si se pudo realizar la habilidad
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			
			HashMap<String,Integer>mapa = new HashMap<String,Integer>();
			mapa.put("salud", caster.getSalud());
			mapa.put("energia", caster.getEnergia() - ENERGIAMINIMA);
			caster.actualizar(mapa);
			
			if (atacado.serAtacado(caster.ataque * 2, new MyRandom()) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Aumentar Defensa" propia de la casta
	 * "Guerrero" y establece sus efectos y condicion de uso
	 * @param caster Es el que realiza la habilidad
	 * @param atacado Es el que recibe el danio
	 * @return true si se pudo realizar la habilidad
	 */
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			
			HashMap<String,Integer>mapa = new HashMap<String,Integer>();
			mapa.put("energia", caster.getEnergia() - ENERGIAMINIMA);
			mapa.put("defensa",caster.getDefensa() + caster.magia);
		
			caster.actualizar(mapa);
			
			return true;
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Ignorar Defensa" propia de la casta
	 * "Guerrero" y establece sus efectos y condicion de uso
	 * @param caster Es el que realiza la habilidad
	 * @param atacado Es el que recibe el danio
	 * @return true si se pudo realizar la habilidad
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			
			HashMap<String,Integer>mapa = new HashMap<String,Integer>();
						
			mapa.put("energia", caster.getEnergia() - ENERGIAMINIMA);
			caster.actualizar(mapa);
			
			if (!atacado.isNPC()) {
				
				int defensaOriginal = ((Personaje) atacado).getDefensa();
				mapa.put("defensa", 0);
				
				((Personaje) atacado).actualizar(mapa);
				
				if (atacado.serAtacado(caster.ataque, new MyRandom()) > 0) {
					mapa.remove("defensa");
					mapa.put("defensa", defensaOriginal);
					mapa.remove("energia");
					((Personaje) atacado).actualizar(mapa);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int getBonusFuerza() {
		return BONUSFUERZA;
	}

	@Override
	public int getBonusInteligencia() {
		return 0;
	}

	@Override
	public int getBonusDestreza() {
		return 0;
	}
	@Override
	public final String getNombreCasta() {
		return "Guerrero";
	}

	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Ataque Doble", "Aumentar Defensa", "Ignorar Defensa"};
	}
}
