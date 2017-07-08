package dominio;

import java.io.Serializable;
import java.util.HashMap;

/**
 * establece el personaje usado por el jugador, con su nombre, alianza,
 * habilidades y atributos
 */
public abstract class Personaje extends Character implements Peleable, Serializable {

	private static final long serialVersionUID = 1L;
	protected int energia;
	protected int ataque;
	protected int magia;
	protected int saludTope;
	protected int destreza;
	protected int inteligencia;
	protected int energiaTope;
	protected int experiencia;
	protected int idPersonaje;
	protected int x;
	protected int y;
	public static int[] tablaDeNiveles;
	protected String nombreRaza;
	protected String nombreCasta;
	protected String[] habilidadesRaza = new String[CANTHABILIDADESRAZA];
	protected String[] habilidadesCasta = new String[CANTHABILIDADESCASTA];
	protected Casta casta;
	protected Alianza clan = null;
	protected static final int SALUDINICIAL = 100;
	protected static final int FUERZAINICIAL = 10;
	protected static final int DEFENSAINICIAL = 10;
	protected static final int TABLANIVELES = 101;
	protected static final int TABLANIVELES50 = 50;
	protected static final int INTELIGENCIAINICIAL = 10;
	protected static final int DESTREZAINICIAL = 10;
	protected static final int SALUDTOPEINICIAL = 100;
	protected static final int ENERGIATOPEINICIAL = 100;
	protected static final int ENERGIAMINIMA = 10;
	protected static final int MAXIMONIVEL = 100;
	protected static final int MAXIMAFUERZA = 200;
	protected static final int MAXIMADESTREZA = 200;
	protected static final int MAXIMAINTELIGENCIA = 200;
	protected static final double MULTIPLICADORFUERZA = 1.5;
	protected static final double MULTIPLICADORINTELIGENCIA = 1.5;
	protected static final int DIVISORDEDESTREZA = 1000;
	protected static final int EXPERIENCIAPORNIVEL = 40;
	protected static final int SALUDEXTRAPORNIVEL = 25;
	protected static final int ENERGIAEXTRAPORNIVEL = 20;
	protected static final int CANTHABILIDADESRAZA = 2;
	protected static final int CANTHABILIDADESCASTA = 3;

	/**
	 * Devuelve las habilidades de la casta
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
		Personaje.tablaDeNiveles = new int[TABLANIVELES];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < TABLANIVELES; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + TABLANIVELES50;
		}
	}

	/**
	 * crea un personaje nivel 1 de una casta determinada, con atributos
	 * predeterminados ligeramente cambiantes dependiendo de dicha casta {
	 * @param nombre
	 *            Nombre del Personaje
	 * @param casta
	 *            Casta del Personaje
	 * @param id
	 *            ID unica del personaje
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		super(SALUDINICIAL, FUERZAINICIAL, DEFENSAINICIAL, nombre, 1);
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		inteligencia = INTELIGENCIAINICIAL;
		destreza = DESTREZAINICIAL;
		saludTope = SALUDTOPEINICIAL;
		energiaTope = ENERGIATOPEINICIAL;
		this.aumentarSaludTope(getSALUDEXTRA());
		this.aumentarEnergiaTope(getENERGIAEXTRA());
		this.aumentarFuerza(casta.getBonusFuerza());
		this.aumentarDestreza(casta.getBonusDestreza());
		this.aumentarInteligencia(casta.getBonusInteligencia());
		nombreRaza = getNombreRaza();
		nombreCasta = casta.getNombreCasta();
		habilidadesRaza = getHabilidadesRaza();
		habilidadesCasta = casta.getHabilidadesCasta();
		x = 0;
		y = 0;
		this.aumentarSalud(getSALUDEXTRA());
		this.aumentarEnergia(energiaTope);
		ataque = this.calcularPuntosDeAtaque();
		magia = this.calcularPuntosDeMagia();
	}

	/**
	 * crea un personaje con nivel y demas atributos enviados por parametro {
	 * @param nombre
	 *            Nombre del Personaje
	 * @param salud
	 *            Cantidad de salud
	 * @param energia
	 *            Cantidad de energia
	 * @param fuerza
	 *            Cantidad de fuerza
	 * @param destreza
	 *            Cantidad de destreza
	 * @param inteligencia
	 *            Cantidad de inteligencia
	 * @param casta
	 *            Clase Casta
	 * @param experiencia
	 *            Cantidad de experiencia
	 * @param nivel
	 *            Cantidad de nivel
	 * @param idPersonaje
	 *            ID del personaje
	 */
	public Personaje(final String nombre, final int salud,
			final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia,
			final int nivel, final int idPersonaje) {

		super(salud, fuerza, destreza, nombre, nivel);
		this.energia = energia;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.experiencia = experiencia;
		this.saludTope = this.getSalud();
		this.energiaTope = this.energia;
		this.idPersonaje = idPersonaje;
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Establece el nombre de la raza
	 * @param nombreRaza
	 *            Nombre de la Raza
	 */
	public void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
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
	 * @param ataque
	 *            Valor de la ataque
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
	 * @param magia
	 *            Valor de la magia
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
	 * @param clan
	 *            Se establece el clan
	 */
	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.agregarPersonaje(this);
	}

	/**
	 * Devuelve el valor del atributo "energia"
	 * @return int Valor de la energia
	 */
	public int getEnergia() {
		return energia;
	}
	/**
	 * Devuelve el valor del atributo "destreza"
	 * @return int Valor de la destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * Devuelve el valor del atributo "inteligencia"
	 * @return int Valor de la inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Devuelve el valor del atributo "casta"
	 * @return Casta Valor de la Casta
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * Devuelve el valor del atributo "experiencia"
	 * @return int Valor de la experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Devuelve el valor del atributo "idPersonaje"
	 * @return int ID unica del Personaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * Devuelve el valor del atributo "saludTope"
	 * @return int Valor de la Salud al tope
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Devuelve el valor del atributo "energiaTope"
	 * @return int Valor de la energia al tope
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Permite un ataque de un personaje a otro, estableciendo condiciones para
	 * el mismo y efectos random define la probabilidad de golpe critico
	 * @param atacado
	 *            Peleable al que se le ataca
	 * @param random
	 *            Numero Random para evitar el ataque
	 * @return int Devuelve el danio
	 */
	public int atacar(final Peleable atacado, final RandomGenerator random) {

		int dano;
		if (this.getSalud() == 0) {
			return 0;
		}

		if (atacado.getSalud() > 0) {
			if (random.nextDouble()
					<= this.casta.getProbabilidadGolpeCritico()
					+ this.destreza / DIVISORDEDESTREZA) {
				dano = atacado.serAtacado(this.golpeCritico(), random);
			} else {
				dano = atacado.serAtacado(this.ataque, random);
			}
			if (atacado.estaVivo() == false) {
				this.ganarObjeto();
			}
			return dano;
		}
		return 0;
	}
	/**
	 * Gana un objeto y sus estadisticas
	 * @return Objeto Retorna el objeto ganado
	 */
	public Objeto ganarObjeto() {

		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		Objeto obj = inventario.agregarObjeto();
		// Objeto obj= new Objeto(2); para test

		if (obj.atributoModificado.equals("saludTope")) {
			mapa.put(obj.atributoModificado, this.getSaludTope() + obj.getValor());
		}
		if (obj.atributoModificado.equals("destreza")) {
			mapa.put(obj.atributoModificado, this.getDestreza() + obj.getValor());
		}
		if (obj.atributoModificado.equals("fuerza")) {
			mapa.put(obj.atributoModificado, this.getFuerza() + obj.getValor());
		}
		if (obj.atributoModificado.equals("defensa")) {
			mapa.put(obj.atributoModificado, this.getDefensa() + obj.getValor());
		}
		if (obj.atributoModificado.equals("inteligencia")) {
			mapa.put(obj.atributoModificado, this.getInteligencia() + obj.getValor());
		}
		if (obj.atributoModificado.equals("energiaTope")) {
			mapa.put(obj.atributoModificado, this.getEnergiaTope() + obj.getValor());
		}
		this.actualizar(mapa);
		return obj;
	}
	/**
	 * Se agrega un objeto al inventario y sus estadisticas
	 */
	public void agregarObjeto(Objeto obj) {

		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		inventario.agregar(obj);


		if (obj.atributoModificado.equals("saludTope"))
			mapa.put(obj.atributoModificado, this.getSaludTope() + obj.getValor());
		if (obj.atributoModificado.equals("destreza"))
			mapa.put(obj.atributoModificado, this.getDestreza() + obj.getValor());
		if (obj.atributoModificado.equals("fuerza"))
			mapa.put(obj.atributoModificado, this.getFuerza() + obj.getValor());
		if (obj.atributoModificado.equals("defensa"))
			mapa.put(obj.atributoModificado, this.getDefensa() + obj.getValor());
		if (obj.atributoModificado.equals("inteligencia"))
			mapa.put(obj.atributoModificado, this.getInteligencia() + obj.getValor());
		if (obj.atributoModificado.equals("energiaTope"))
			mapa.put(obj.atributoModificado, this.getEnergiaTope() + obj.getValor());

		this.actualizar(mapa);

	}
	/**
	 * Se elimina el objeto y sus estadisticas ganadas
	 * @param obj Objeto a perder y con el sus estadisticas
	 */
	public void perderObjeto(final Objeto obj) {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();

		if (obj.atributoModificado.equals("saludTope")) {
			mapa.put(obj.atributoModificado, this.getSaludTope() - obj.getValor());
		}
		if (obj.atributoModificado.equals("destreza")) {
			mapa.put(obj.atributoModificado, this.getDestreza() - obj.getValor());
		}
		if (obj.atributoModificado.equals("fuerza")) {
			mapa.put(obj.atributoModificado, this.getFuerza() - obj.getValor());
		}
		if (obj.atributoModificado.equals("defensa")) {
			mapa.put(obj.atributoModificado, this.getDefensa() - obj.getValor());
		}
		if (obj.atributoModificado.equals("inteligencia")) {
			mapa.put(obj.atributoModificado, this.getInteligencia() - obj.getValor());
		}
		if (obj.atributoModificado.equals("energiaTope")) {
			mapa.put(obj.atributoModificado, this.getEnergiaTope() - obj.getValor());
		}
		inventario.quitarObjeto(obj);
		this.actualizar(mapa);
	}

	/**
	 * Permite que el personaje realize un "golpe critico", que hace mas danio
	 * del normal
	 * @return int Valor del golpe critico
	 */
	public int golpeCritico() {
		return (int) (this.ataque * this.getCasta().getDanoCritico());
	}

	/**
	 * Devuelve True o False, si puede atacar el personaje o no
	 * @return true Si puede atacar
	 */
	public boolean puedeAtacar() {
		return energia > ENERGIAMINIMA;
	}

	/**
	 * Devuelve el valor del atributo "Ataque" multiplicado por 1.5, depende de
	 * la Fuerza
	 * @return int Puntos de Ataque
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * MULTIPLICADORFUERZA);
	}

	/**
	 * Devuelve el valor del atributo "Destreza" multiplicado por 1,5, depende
	 * de la Destreza
	 * @return int Puntos de Defensa
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * Devuelve el valor del atributo "Magia" multiplicado por 1,5, depende de
	 * la Inteligencia
	 * @return int Puntos de Magia
	 */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * MULTIPLICADORINTELIGENCIA);
	}

	/**
	 * establece el valor del atributo "salud" en el maximo posible
	 */
	public void restablecerSalud() {
		this.setSalud(this.saludTope);
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
		this.setDefensa(this.calcularPuntosDeDefensa());
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * permite que el personaje sea atacado por otro y establece los efectos y
	 * condiciones de dicha accion
	 * @param danio
	 *            Danio a realizar
	 * @param random
	 *            Numero random para evitar el danio
	 * @return int danio realizado
	 */
	public int serAtacado(final int danio, final RandomGenerator random) {
		if (random.nextDouble() >= this.getCasta().getProbabilidadEvitarDano()) {
			int auxDanio = danio;
			auxDanio -= this.getDefensa();
			if (auxDanio > 0) {
				if (this.getSalud() <= auxDanio) {
					auxDanio = this.getSalud();
					this.setSalud(0);
				} else {
					this.setSalud(this.getSalud() - auxDanio);
				}
				return auxDanio;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * El personaje ve reducido su atributo "salud", debido a un danio enviado
	 * por parametro, siempre y cuando dicho danio sea mayor que la defensa del
	 * personaje
	 * @param danio
	 *            danio a realizar
	 * @return int danio realizado
	 */
	public int serRobadoSalud(final int danio) {
		int auxDanio = danio;
		auxDanio -= this.getDefensa();
		if (auxDanio <= 0) {
			return 0;
		}
		if ((this.getDefensa() - auxDanio) >= 0) {
			this.setSalud(this.getSalud() - auxDanio);
		} else {
			auxDanio = this.getSalud();
			this.setSalud(0);
		}
		return auxDanio;
	}

	/**
	 * El personaje ve reducido su atributo "energia", debido a un danio enviado
	 * por parametro, siempre y cuando dicho danio sea mayor que la defensa del
	 * personaje
	 * @param danio
	 *            Danio a realizar
	 * @return int danio realizado
	 */
	public int serDesernegizado(final int danio) {
		int auxDanio = danio;
		auxDanio -= this.getDefensa();
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
	 * @param salud
	 *            Cantidad de Salud a incrementar
	 */
	public void serCurado(final int salud) {
		if ((this.getSalud() + salud) <= this.saludTope) {
			this.setSalud(this.getSalud() + salud);
		} else {
			this.setSalud(this.saludTope);
		}
	}

	/**
	 * Aumenta el valor del atributo "energia"
	 * @param aumentoEnergia
	 *            Cantidad de Energia a incrementar
	 */
	public void serEnergizado(final int aumentoEnergia) {
		if ((this.energia + aumentoEnergia) <= this.energiaTope) {
			this.energia += aumentoEnergia;
		} else {
			this.energia = this.energiaTope;
		}

	}

	/**
	 * Crea una alianza y establece al personaje como miembro de la misma
	 * @param nombreAlianza
	 *            Nombre de la nueva alianza
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
	 * @param nuevoAliado
	 *            Personaje a establecer la alianza
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
	 * @param aumentoFuerza
	 *            Aumento de fuerza
	 * @param aumentoDestreza
	 *            Aumento de destreza
	 * @param aumentoInteligencia
	 *            Aumento de inteligencia
	 */
	public void asignarPuntosSkills(final int aumentoFuerza,
			final int aumentoDestreza, final int aumentoInteligencia) {
		if (this.getFuerza() + aumentoFuerza <= MAXIMAFUERZA) {
			this.setFuerza(this.getFuerza() + aumentoFuerza);
		}
		if (this.destreza + aumentoDestreza <= MAXIMADESTREZA) {
			this.destreza += aumentoDestreza;
		}
		if (this.inteligencia + aumentoInteligencia <= MAXIMAINTELIGENCIA) {
			this.inteligencia += aumentoInteligencia;
		}
		this.modificarAtributos();
	}

	/**
	 * Aumenta en 1 el nivel del personaje, con las modificaciones de atributos
	 * que dicha accion implica
	 */
	public void subirNivel() {
		int acumuladorExperiencia = 0;
		if (this.getNivel() == MAXIMONIVEL) {
			return;
		}
		while (this.getNivel() != MAXIMONIVEL
				&& (this.experiencia >=	Personaje.
				tablaDeNiveles[this.getNivel() + 1]	+ acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.getNivel() + 1];
			this.aumentarNivel();
			this.modificarAtributos();
			this.saludTope += SALUDEXTRAPORNIVEL;
			this.energiaTope += ENERGIAEXTRAPORNIVEL;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/**
	 * aumenta la experiencia del personaje y sube de nivel si corresponde
	 * @param exp
	 *            Experiencia que gana
	 * @return true Si pudo subir de nivel
	 */
	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;
		if (experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]) {
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
		return this.getNivel() * EXPERIENCIAPORNIVEL;
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
	 * @param p
	 *            Personaje que se le compara la distancia
	 * @return double Es la distancia entre ambos personajes
	 */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * La Habilidad propia del Casta del personaje
	 * @param atacado
	 *            En quien se realiza la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**
	 * La Habilidad propia del Casta del personaje
	 * @param atacado
	 *            En quien se realiza la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/**
	 * La Habilidad propia del Casta del personaje
	 * @param atacado
	 *            En quien se realiza la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * Habilidad propia de la raza del personaje
	 * @param atacado
	 *            Peleable en que se utiliza la Habilidad
	 * @param random
	 *            Numero Random para evitar la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public abstract boolean habilidadRaza1(final Peleable atacado, final RandomGenerator random);

	/**
	 * Habilidad propia de la raza del personaje
	 * @param atacado
	 *            Peleable en que se utiliza la Habilidad
	 * @param random
	 *            Numero Random para evitar la Habilidad
	 * @return true Si se pudo realizar la Habilidad
	 */
	public abstract boolean habilidadRaza2(final Peleable atacado, final RandomGenerator random);

	/**
	 * Se establece la posicion del Personaje
	 * @param distanciaX Posicion X
	 * @param distanciaY Posicion Y
	 */
	public void setDistancia(final int distanciaX, final int distanciaY) {
		this.x = distanciaX;
		this.y = distanciaY;
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
	 * @return boolean Devuelve False siempre
	 */
	public boolean isNPC() {
		return false;
	}

	/**
	 * Devuelve el Extra de Salud por la Raza
	 * @return int Es la salud extra, puede ser 0(Elfo) , 5(Humano) o 10 (Orco)
	 */
	public abstract int getSALUDEXTRA();

	/**
	 * Devuelve el Extra de Energia por la Raza
	 * @return int Es la Energia extra,
	 *  puede ser 0(Orco) , 5(Humano) o 10 (Elfo)
	 */
	public abstract int getENERGIAEXTRA();

	/**
	 * Devuelve el nombre de la raza
	 * @return String Nombre de la Raza
	 */
	public abstract String getNombreRaza();

	/**
	 * devuelve las habilidades de la raza
	 * @return String[] Las habilidades de la Raza
	 */
	public abstract String[] getHabilidadesRaza();

	/**
	 * Aumenta el valor actual de la saludTope con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarSaludTope(final int aumento) {
		saludTope += aumento;
	}

	/**
	 * Aumenta el valor actual de la energiaTope con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarEnergiaTope(final int aumento) {
		energiaTope += aumento;
	}

	/**
	 * Aumenta el valor actual de la energia con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarEnergia(final int aumento) {
		energia += aumento;
	}

	/**
	 * Aumenta el valor actual de la ataque con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarAtaque(final int aumento) {
		ataque += aumento;
	}

	/**
	 * Aumenta el valor actual de la destreza con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarDestreza(final int aumento) {
		destreza += aumento;
	}

	/**
	 * Aumenta el valor actual de la magia con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarMagia(final int aumento) {
		magia += aumento;
	}

	/**
	 * Aumenta el valor actual de la inteligencia con el parametro
	 * @param aumento Valor que se le suma al actual
	 */
	public final void aumentarInteligencia(final int aumento) {
		inteligencia += aumento;
	}
	/**
	 * Actualiza las estadisticas del Personaje
	 * @param mapa Mapa de los atributos modificados
	 */
	public void actualizar(HashMap<String, ?> mapa) {
		// se va actualizando durante la batalla
		if (mapa.containsKey("salud")) {
			this.salud = (Integer) mapa.get("salud");
		}
		if (mapa.containsKey("energia")) {
			this.energia = (Integer) mapa.get("energia");
		}
		if (mapa.containsKey("casta")) {
			this.casta = (Casta) mapa.get("casta");
		}
		if (mapa.containsKey("defensa")) {
			this.defensa = (Integer) mapa.get("defensa");
		}
		if (mapa.containsKey("destreza")) {
			this.destreza = (Integer) mapa.get("destreza");
		}
		if (mapa.containsKey("energiaTope")) {
			this.energiaTope = (Integer) mapa.get("energiaTope");
		}
		if (mapa.containsKey("experiencia")) {
			this.experiencia = (Integer) mapa.get("experiencia");
		}
		if (mapa.containsKey("fuerza")) {
			this.fuerza = (Integer) mapa.get("fuerza");
		}
		if (mapa.containsKey("idPersonaje")) {
			this.idPersonaje = (Integer) mapa.get("idPersonaje");
		}
		if (mapa.containsKey("inteligencia")) {
			this.inteligencia = (Integer) mapa.get("inteligencia");
		}
		if (mapa.containsKey("nivel")) {
			this.nivel = (Integer) mapa.get("nivel");
		}
		if (mapa.containsKey("saludTope")) {
			this.saludTope = (Integer) mapa.get("saludTope");
		}
	}
	/**
	 * Obtener el inventario
	 * @return Inventario Lista de objetos
	 */
	public Inventario getInventario() {
		return this.inventario;
	}
	/**
	 * Reestablece todos los objetos del inventario
	 * @param ids Vector de ids de los objetos en el inventario
	 */
	public void reestablecerInventario(final int[] ids) {
		inventario.reestablecerObjetos(ids);

	}
	/**
	 * Retorna la cantidad de objetos en el inventario
	 * @return int Cantidad de objetos del inventario
	 */
	public int getCantidadObjetos() {
		return inventario.getCantidadObjetos();
	}
	/**
	 * Quito un objeto del Inventario
	 * @param obj Objeto a eliminar del inventario
	 */
	public void quitarObjeto(final Objeto obj) {
		inventario.quitarObjeto(obj);
	}
}
