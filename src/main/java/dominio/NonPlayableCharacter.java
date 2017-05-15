package dominio;

/**
 * establece los personajes no manejables por el jugador (NPCs) y sus estadisticas y atributos
 *
 */
public class NonPlayableCharacter implements Peleable{

  private int salud;
  private int fuerza;
  private int defensa;
  private String nombre;
  private int nivel;
  private static final int dificultadAleatoria = -1;
  
  /**
  * establece un personaje no jugable con determinados atributos basados en la dificultad elegida
  * {@param nombre}
  * {@param nivel}
  * {@param dificultadNPC}
  */
  
  public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC, RandomGenerator random) {
    this.nombre = nombre;
    this.nivel = nivel;
    int dificultad;
    if (dificultadNPC == dificultadAleatoria) {
      dificultad = random.nextInt(3);
    } else {
      dificultad = dificultadNPC;
    }
    switch (dificultad) {
      case 0:
        this.fuerza = 10 + (nivel - 1) * 3;// 30%
        this.salud = 30 + (nivel - 1) * 15;
        this.defensa = 2 + (nivel - 1) * 1;
        break;
      case 1:
        this.fuerza = 20 + (nivel - 1) * 6;// 50%
        this.salud = 40 + (nivel - 1) * 20;
        this.defensa = 5 + (nivel - 1) * 2;
        break;
      case 2:
        this.fuerza = 30 + (nivel - 1) * 10;// 50%
        this.salud = 50 + (nivel - 1) * 25;
        this.defensa = 4 + (nivel - 1) * 4;
        break;
    }
  }

  /**
  * aumenta el valor del atributo "nivel"
  */
  
  public int otorgarExp() {
    return this.nivel * 30;
  }
  /**
  * devuelve el valor del atributo "fuerza"
  * @return int
  */
  
  public int getFuerza() {
    return fuerza;
  }

  /**
  * establece un valor para el atributo "fuerza"
  * {@param fuerza}
  */
  
  public void setFuerza(int fuerza) {
    this.fuerza = fuerza;
  }

  /**
  * devuelve el valor del atributo "nombre"
  * @return String
  */
  
  public String getNombre() {
    return nombre;
  }

  /**
  * establece un valor para el atributo "nombre"}
  * 
  */
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  /**
  * devuelve el valor del atributo "nivel"
  * @return int
  */
  
  public int getNivel() {
    return nivel;
  }
  /**
  * establece un valor para el atributo "nivel"
  * {@param nivel}
  */
  
  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  /**
  * devuelve "true" o "false" dependiendo si el personaje no jugable
  * esta vivo o no (salud mayor a cero)
  */
  
  public boolean estaVivo() {
    return salud > 0;
  }

  /**
  * devuelve el valor del atributo "defensa"
  * @return int
  */
  
  public int getDefensa() {
    return defensa;
  }
  /**
  * establece un valor para el atributo "defensa"
  * {@param defensa}
  */
  
  public void setDefensa(int defensa) {
    this.defensa = defensa;
  }
  /**
  * devuelve el valor del atributo "salud"
  * @return int
  */
  
  public int getSalud() {
    return salud;
  }
  /**
  * establece un valor para el atributo "salud"
  * {@param salud}
  */
  
  public void setSalud(int salud) {
    this.salud = salud;
  }

  /**
  * permite un ataque del personaje no jugable contra otro personaje
  * 
  */
  
  public int atacar(Peleable atacado, RandomGenerator random) {
    if (random.nextDouble() <= 0.15) {
      return atacado.serAtacado((int) (this.getAtaque() * 1.5), random);
    } else {
      return atacado.serAtacado(this.getAtaque(), random);
    }
  }

  /**
  * reduce la defensa y salud del personaje no jugable cuando es atacado y 
  * devuelve el daño recibido,
  * o devuelve cero si esquivo el golpe o su defensa es mayor que el daño del atacante
  */
  
  public int serAtacado(int daño, RandomGenerator random) {
    if (random.nextDouble() >= 0.15) {
      daño -= this.getDefensa() / 2;
      if (daño > 0) {
        salud -= daño;
        return daño;
      }
      return 0;
    }
    return 0;
  }

  public void despuesDeTurno() { }
  
  public void ganarExperiencia(int exp) {

  }

  /**
  * devuelve el valor del atributo "fuerza"
  */
  @Override
  public int getAtaque() {
    return fuerza;
  }

  /**
  * establece un valor para el atributo "ataque"
  */
  @Override
  public void setAtaque(int ataque) {
    this.fuerza = ataque;
  }

  @Override
  public void serCurado(int PuntosDeMagia) {}
}
