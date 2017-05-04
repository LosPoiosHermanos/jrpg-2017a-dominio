package dominio;
/**
 * 
 * Una de las posibles razas de personajes que el jugador puede elegir
 * La cual posee sus propias habilidades
 */
public class Humano extends Personaje {

	/**
	 * crea un personaje de raza "Humano" con nombre y casta enviados por parametro
	 * @param nombre
	 * @param casta
	 * @param id
	 */
	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	/**
	 * crea un personaje de raza humano con todas sus caracteristicas enviadas
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
	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * permite el uso de la habilidad "Incentivar" propia de la raza "humano"
	 * y establece sus efectos y condicion de uso
	 */
	// Incentivar
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * permite el uso de la habilidad "Golpe Fatal" propia de la raza "humano"
	 * y establece sus efectos y condicion de uso
	 */
	// Golpe Fatal
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
}
