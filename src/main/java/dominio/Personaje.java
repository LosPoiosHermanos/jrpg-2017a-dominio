package dominio;

import java.io.Serializable;

/**
 * establece el personaje usado por el jugador, con su nombre, alianza,
 * habilidades y atributos
 *
 */

public abstract class Personaje implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	protected int defensa;
	protected int ataque;
	protected int magia;

	protected String nombre;
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;

	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int[] tablaDeNiveles;

	protected String[] habilidadesRaza;
	private static final int MAXIMONIVEL = 100;
	private static final int MAXIMAFUERZA = 200;
	private static final int MAXIMADESTREZA = 200;
	private static final int MAXIMAINTELIGENCIA = 200;
	private static final int EXPERIENCIAPORNIVEL = 40;
	private static final int SALUDEXTRAPORNIVEL = 25;
	private static final int ENERGIAEXTRAPORNIVEL = 20;
	private static final int ENERGIAMINIMA = 10;
	private static final double MULTIPLICADORFUERZA = 1.5;
	private static final double MULTIPLICADORINTELIGENCIA = 1.5;

	/**
	 * devuelve las habilidades de la raza
	 * @return String[]
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * devuelve las habilidades de la casta
	 * @return String[]
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * establece la experencia necesaria para alcanzar cada uno de los niveles
	 * del personaje
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
		}
	}

	/**
	 * crea un personaje nivel 1 de una casta determinada, con atributos
	 * predeterminados ligeramente cambiantes dependiendo de dicha casta {
	 * @param nombre Nombre del Personaje
	 * @param casta Casta del Personaje
	 * @param id ID unica del personaje
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		this.fuerza += casta.getBonusFuerza();
		this.inteligencia += casta.getBonusInteligencia();
		this.destreza += casta.getBonusDestreza();
		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;
		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
	}

	/**
	 * crea un personaje con nivel y demas atributos enviados por parametro {
	 * @param nombre Nombre del Personaje
	 * @param salud Cantidad de salud
	 * @param energia Cantidad de energia
	 * @param fuerza Cantidad de fuerza
	 * @param destreza Cantidad de destreza
	 * @param inteligencia Cantidad de inteligencia
	 * @param casta Clase Casta
	 * @param experiencia Cantidad de experiencia
	 * @param nivel Cantidad de nivel
	 * @param idPersonaje ID del personaje
	 */

	public Personaje(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.experiencia = experiencia;
		this.nivel = nivel;
		this.saludTope = this.salud;
		this.energiaTope = this.energia;
		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Devuelve el nombre de la raza
	 * @return String Nombre de la Raza
	 */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/**
	 * Establece el nombre de la raza
	 * @param nombreRaza Nombre de la Raza
	 */
	public void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	/**
	 * devuelve el nombre del personaje
	 * @return String Nombre del Personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del personaje
	 * @param nombre Valor de la nombre
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * devuelve el valor del atributo "ataque"
	 * @return ataque Valor de la ataque
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * establece un valor para el atributo "ataque"
	 * @param ataque Valor de la ataque
	 */
	public void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Devuelve el valor del aributo "magia"
	 * @return int Valor de la magia
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * Establece un valor para el atributo "magia"
	 * @param magia Valor de la magia
	 */
	public void setMagia(final int magia) {
		this.magia = magia;
	}

	/**
	 * Devuelve el valor del atributo "clan"
	 * @return Alianza Lista de la Alianza
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * Establece un valor para el atributo "clan"
	 * @param clan Se establece el clan
	 */
	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.agregarPersonaje(this);
	}

	/**
	 * Devuelve el valor del atributo "salud"
	 * @return int Valor de la salud
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * Establece un valor para el atributo "salud"
	 * @param salud Valor de la salud
	 */
	public void setSalud(final int salud) {
		this.salud = salud;
	}

	/**
	 * Devuelve el valor del atributo "energia"
	 * @return int Valor de la energia
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Establece un valor para el atributo "energia"
	 * @param energia Valor de la energia
	 */
	public void setEnergia(final int energia) {
		this.energia = energia;
	}

	/**
	 * Eevuelve el valor del atributo "fuerza"
	 * @return int Valor de la fuerza
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Establece un valor para el atributo "fuerza"
	 * @param fuerza Valor de la fuerza
	 */
	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * Devuelve el valor del atributo "destreza"
	 * @return int Valor de la destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * Establece un valor para el atributo "destreza"
	 * @param destreza Valor de la destreza
	 */
	public void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	/**
	 * Devuelve el valor del atributo "inteligencia"
	 * @return int Valor de la inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Establece un valor para el atributo "inteligencia"
	 * @param inteligencia Valor de la inteligencia
	 */
	public void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
	}

	/**
	 * Devuelve el valor del atributo "casta"
	 * @return Casta Valor de la Casta
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * Establece un valor para el atributo "casta"
	 * @param casta Valor de la Casta
	 */
	public void setCasta(final Casta casta) {
		this.casta = casta;
	}

	/**
	 * Devuelve el valor del atributo "experiencia"
	 * @return int Valor de la experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Establece un valor para el atributo "experiencia"
	 * @param experiencia Valor de la experiencia
	 */
	public void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * Devuelve el valor del atributo "nivel"
	 * @return int Valor del nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Establece un valor para el atributo "nivel"
	 * @param nivel Valor del nivel
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Devuelve el valor del atributo "idPersonaje"
	 * @return int ID unica del Personaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * Establece un valor para el atributo "idPersonaje"
	 * @param idPersonaje ID unica del Personaje
	 */
	public void setIdPersonaje(final int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	/**
	 * Devuelve el valor del atributo "defensa"
	 * @return int Valor de la defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Establece un valor para el atributo "defensa"
	 * @param defensa Valor de la defensa
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Devuelve el valor del atributo "saludTope"
	 * @return int Valor de la Salud al tope
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Establece un valor para el atributo "saludTope"
	 * @param saludTope Valor de la Salud al tope
	 */
	public void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}

	/**
	 * Devuelve el valor del atributo "energiaTope"
	 * @return int Valor de la energia al tope
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Establece un valor para el atributo "energiaTope"
	 * @param energiaTope Valor de la Energia al tope
	 */
	public void setEnergiaTope(final int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * Permite un ataque de un personaje a otro, estableciendo condiciones para
	 * el mismo y efectos random define la probabilidad de golpe critico
	 * @param atacado Peleable al que se le ataca
	 * @param random Numero Random para evitar el ataque
	 * @return int Devuelve el danio
	 */
	public int atacar(final Peleable atacado, final RandomGenerator random) {
		if (salud == 0) {
			return 0;
		}
		if (atacado.getSalud() > 0) {
			if (random.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico(), random);
			} else {
				return atacado.serAtacado(this.ataque, random);
			}
		}
		return 0;
	}

	/**
	 * Permite que el personaje realize un "golpe critico", que hace mas danio
	 * del normal
	 * @return int Valor del golpe critico
	 */
	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	/**
	 */
	public void despuesDeTurno() {

	}

	/**
	 * Devuelve True o False, si puede atacar el personaje o no
	 * @return true Si puede atacar
	 */
	public boolean puedeAtacar() {
		return energia > ENERGIAMINIMA;
	}

	/**
	 * Devuelve el valor del atributo "Ataque" multiplicado por 1.5,
	 * depende de la Fuerza
	 * @return int Puntos de Ataque
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * MULTIPLICADORFUERZA);
	}

	/**
	 * Devuelve el valor del atributo "Destreza" multiplicado por 1,5,
	 * depende de la Destreza
	 * @return int Puntos de Defensa
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * Devuelve el valor del atributo "Magia" multiplicado por 1,5,
	 * depende de la Inteligencia
	 * @return int Puntos de Magia
	 */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * MULTIPLICADORINTELIGENCIA);
	}

	/**
	 * establece el valor del atributo "salud" en el maximo posible
	 */
	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	/**
	 * establece el valor del atributo "energia" en el maximo posible
	 */
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * modifica los valores de los atributos "ataque", "defensa" y "magia"
	 */
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * devuelve "true" o "false" dependiendo de si el personaje esta vivo o no
	 * (salud mayor a cero)
	 * @return true si esta vivo
	 */
	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * permite que el personaje sea atacado por otro y establece los efectos y
	 * condiciones de dicha accion
	 * @param danio Danio a realizar
	 * @param random Numero random para evitar el danio
	 * @return int danio realizado
	 */
	public int serAtacado(final int danio, final RandomGenerator random) {
		if (random.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			int auxDanio = danio;
			auxDanio -= this.defensa;
			if (auxDanio > 0) {
				if (salud <= auxDanio) {
					auxDanio = salud;
					salud = 0;
				} else {
					salud -= auxDanio;
				}
				return auxDanio;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * el personaje ve reducido su atributo "salud", debido a un danio enviado
	 * por parametro, siempre y cuando dicho danio sea mayor que la defensa del
	 * personaje
	 * @param danio danio a realizar
	 * @return int danio realizado
	 */
	public int serRobadoSalud(final int danio) {
		int auxDanio = danio;
		auxDanio -= this.defensa;
		if (auxDanio <= 0) {
			return 0;
		}
		if ((salud - auxDanio) >= 0) {
			salud -= auxDanio;
		} else {
			auxDanio = salud;
			salud = 0;
		}
		return auxDanio;
	}

	/**
	 * el personaje ve reducido su atributo "energia", debido a un danio enviado
	 * por parametro, siempre y cuando dicho danio sea mayor que la defensa del
	 * personaje
	 * @param danio Danio a realizar
	 * @return int danio realizado
	 */
	public int serDesernegizado(final int danio) {
		int auxDanio = danio;
		auxDanio -= this.defensa;
		if (auxDanio <= 0) {
			return 0;
		}
		if ((energia - auxDanio) >= 0) {
			energia -= auxDanio;
		} else {
			auxDanio = energia;
			energia = 0;
		}
		return auxDanio;
	}

	/**
	 * Aumenta la salud del personaje
	 * @param salud Cantidad de Salud a incrementar
	 */
	public void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope;
		}
	}

	/**
	 * Aumenta el valor del atributo "energia"
	 * @param energia Cantidad de Energia a incrementar
	 */
	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope;
		}

	}

	/**
	 * Crea una alianza y establece al personaje como miembro de la misma
	 * @param nombreAlianza Nombre de la nueva alianza
	 */
	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.agregarPersonaje(this);
	}

	/**
	 * Remueve al personaje de la alianza en que se encuentre
	 */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * Establece una alianza entre este personaje y otro
	 * @param nuevoAliado Personaje a establecer la alianza
	 * @return true Si se pudo completar la alianza
	 */
	public boolean aliar(final Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.agregarPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.agregarPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Aumenta los valores de los atributos "fuerza", "destreza" e
	 * "inteligencia" y llama al metodo "modificarAtributos", que modifica los
	 * valores de "ataque", "defensa" y "magia"
	 * @param fuerza Aumento de fuerza
	 * @param destreza Aumento de destreza
	 * @param inteligencia Aumento de inteligencia
	 */
	public void asignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.fuerza + fuerza <= MAXIMAFUERZA) {
			this.fuerza += fuerza;
		}
		if (this.destreza + destreza <= MAXIMADESTREZA) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= MAXIMAINTELIGENCIA) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	/**
	 * aumenta en 1 el nivel del personaje, con las modificaciones de atributos
	 * que dicha accion implica
	 */
	public void subirNivel() {
		int acumuladorExperiencia = 0;
		if (this.nivel == MAXIMONIVEL) {
			return;
		}
		while (this.nivel != MAXIMONIVEL && (this.experiencia >=
				Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += SALUDEXTRAPORNIVEL;
			this.energiaTope += ENERGIAEXTRAPORNIVEL;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/**
	 * aumenta la experiencia del personaje y sube de nivel si corresponde
	 * @param exp Experiencia que gana
	 * @return true Si pudo subir de nivel
	 */
	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;
		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el valor del atributo "nivel" multiplicado por 40
	 * @return int Experiencia por nivel
	 */
	public int otorgarExp() {
		return this.nivel * EXPERIENCIAPORNIVEL;
	}

	/**
	 * Clona el objeto "personaje"
	 * @return Object Devuelve el objeto clonado
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Devuelve la distancia entre el personaje y otro
	 * @param p Personaje que se le compara la distancia
	 * @return double Es la distancia entre ambos personajes
	 */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * La Habilidad propia del Casta del personaje
	 * @param atacado En quien se realiza la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}
	/**
	 * La Habilidad propia del Casta del personaje
	 * @param atacado En quien se realiza la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}
	/**
	 * La Habilidad propia del Casta del personaje
	 * @param atacado En quien se realiza la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * Habilidad propia de la raza del personaje
	 * @param atacado Peleable en que se utiliza la Habilidad
	 * @param random Numero Random para evitar la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public abstract boolean habilidadRaza1(final Peleable atacado, final RandomGenerator random);
	/**
	 * Habilidad propia de la raza del personaje
	 * @param atacado Peleable en que se utiliza la Habilidad
	 * @param random Numero Random para evitar la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public abstract boolean habilidadRaza2(final Peleable atacado, final RandomGenerator random);
	/**
	 * Se establece la posicion del Personaje
	 * @param x Posicion X
	 * @param y Posicion Y
	 */
	public void setDistancia(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Devuelve la posicion X del personaje
	 * @return x La posicion X
	 */
	public int getX() {
		return x;
	}
	/**
	 * Devuelve la posicion Y del personaje
	 * @return y La posicion Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Determina si es un NonPlayableCharacter
	 * @return
	 */
	@Override
	public boolean isNPC() {
		return false;
	}
}