package dominio;

import java.io.Serializable;
/**
 * 
 * establece el personaje usado por el jugador, con su nombre, alianza, habilidades y atributos
 *
 */
public abstract class Personaje implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	protected String nombre;// hay que agregarlo a todos los constructores
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
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	/**
	 * devuelve las habilidades de la raza
	 * @return
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 *  devuelve las habilidades de la casta
	 * @return
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * establece la experencia necesaria para alcanzar cada uno de 
	 * los niveles del personaje
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	/**
	 * crea un personaje nivel 1 de una casta determinada, 
	 * con atributos predeterminados ligeramente cambiantes dependiendo de dicha casta
	 * @param nombre
	 * @param casta
	 * @param id
	 */
	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			fuerza += 5;
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	/**
	 * crea un personaje con nivel y demas atributos enviados por parametro
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
	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {

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
	 * devuelve el nombre de la raza
	 * @return
	 */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/**
	 * establece el nombre de la raza
	 * @param nombreRaza
	 */
	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	/**
	 * devuelve el nombre del personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * establece el nombre del personaje
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * devuelve el valor del atributo "ataque"
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * establece un valor para el atributo "ataque"
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * devuelve el valor del aributo "magia"
	 * @return
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * establece un valor para el atributo "magia"
	 * @param magia
	 */
	public void setMagia(int magia) {
		this.magia = magia;
	}

	/**
	 * devuuelve el valor del atributo "clan"
	 * @return
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * establece un valor para el atributo "clan"
	 * @param clan
	 */
	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	/**
	 * devuelve el valor del atributo "salud"
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * establece un valor para el atributo "salud"
	 * @param salud
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}

	/**
	 * devuelve el valor del atributo "energia"
	 * @return
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * establece un valor para el atributo "energia"
	 * @param energia
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	/**
	 * devuelve el valor del atributo "fuerza"
	 * @return
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * establece un valor para el atributo "fuerza"
	 * @param fuerza
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * devuelve el valor del atributo "destreza"
	 * @return
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * establece un valor para el atributo "destreza"
	 * @param destreza
	 */
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	/**
	 * devuelve el valor del atributo "inteligencia"
	 * @return
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * establece un valor para el atributo "inteligencia"
	 * @param inteligencia
	 */
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	/**
	 * devuelve el valor del atributo "casta"
	 * @return
	 */
	public Casta getCasta() {
		return casta;
	}

	/**
	 * establece un valor para el atributo "casta"
	 * @param casta
	 */
	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	/**
	 * devuelve el valor del atributo "experiencia"
	 * @return
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * establece un valor para el atributo "experiencia"
	 * @param experiencia
	 */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * devuelve el valor del atributo "nivel"
	 * @return
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * establece un valor para el atributo "nivel"
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * devuelve el valor del atributo "idPersonaje"
	 * @return
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * establece un valor para el atributo "idPersonaje"
	 * @param idPersonaje
	 */
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	/**
	 * devuelve el valor del atributo "defensa"
	 * @return
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * establece un valor para el atributo "defensa"
	 * @param defensa
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	/**
	 * devuelve el valor del atributo "saludTope"
	 * @return
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * establece un valor para el atributo "saludTope"
	 * @param saludTope
	 */
	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	/**
	 * devuelve el valor del atributo "energiaTope"
	 * @return
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * establece un valor para el atributo "energiaTope"
	 * @param energiaTope
	 */
	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * permite un ataque de un personaje a otro, estableciendo
	 * condiciones para el mismo y efectos
	 */
	public int atacar(Peleable atacado) {
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	/**
	 * permite que el personaje realize un "golpe critico", que 
	 * hace mas daño del normal
	 * @return
	 */
	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}

	/**
	 * devuelve "true" o "false" dependiendo de si el personaje tiene o no 
	 * suficiente energia para atacar
	 * @return
	 */
	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * devuelve el valor del atributo fuerza multiplicado por 1,5
	 * @return
	 */
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	/**
	 * devuelve el valor del atributo "destreza"
	 * @return
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * devuelve el valor del atributo "magia" multiplicado por 1,5
	 * @return
	 */
	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
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
	 * devuelve "true" o "false" dependiendo de si el personaje 
	 * esta vivo o no (salud mayor a cero)
	 */
	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * permite que el personaje sea atacado por otro 
	 * y establece los efectos y condiciones de dicha accion
	 */
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (salud <= daño) {
					daño = salud;
					salud = 0;
				} else {
					salud -= daño;
				}
				return daño;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * el personaje ve reducido su atributo "salud", debido a un
	 * daño enviado por parametro, siempre y cuando dicho daño sea
	 * mayor que la defensa del personaje
	 * @param daño
	 * @return
	 */
	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((salud - daño) >= 0)
			salud -= daño;
		else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}

	/**
	 * el personaje ve reducido su atributo "energia", debido a un
	 * daño enviado por parametro, siempre y cuando dicho daño sea
	 * mayor que la defensa del personaje
	 * @param daño
	 * @return
	 */
	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((energia - daño) >= 0)
			energia -= daño;
		else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}

	/**
	 * aumenta la salud del personaje 
	 * @param salud
	 */
	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;
	}

	/**
	 * aumenta el valor del atributo "energia" 
	 * @param energia
	 */
	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	/**
	 * crea una alianza y establece al personaje como miembro de
	 * la misma
	 * @param nombre_alianza
	 */
	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	/**
	 * remueve al personaje de la alianza en que se encuentre
	 */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * establece una alianza entre este personaje y otro
	 * @param nuevo_aliado
	 * @return
	 */
	public boolean aliar(Personaje nuevo_aliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else
			return false;
	}

	/**
	 * aumenta los valores de los atributos "fuerza", "destreza" e "inteligencia"
	 * y llama al metodo "modificarAtributos", que modifica los valores
	 * de "ataque", "defensa" y "magia"
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 */
	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

	/**
	 * aumenta en 1 el nivel del personaje, con las modificaciones de
	 * atributos que dicha accion implica
	 */
	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/**
	 * aumenta la experiencia del personaje y sube de nivel si corresponde
	 * @param exp
	 * @return
	 */
	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/**
	 * devuelve el valor del atributo "nivel" multiplicado por 40
	 */
	public int otorgarExp() {
		return this.nivel * 40;
	}

	/**
	 * clona el objeto "personaje"
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * devuelve la distancia entre este personaje y otro
	 * @param p
	 * @return
	 */
	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * las habilidades propias de la casta del personaje
	 * @param atacado
	 * @return
	 */
	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * las habilidades propias de la raza del personaje
	 * @param atacado
	 * @return
	 */
	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
	
	public void setDistancia(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
