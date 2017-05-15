package dominio;

/**
 * devuelve valores aleatorios de tipo "int" o "double"
 * 
 */
public class MyRandom {

  /**
  * Devuelve un valor double aleatorio
  * @return double
  */
  public static double nextDouble() {
    return 0.49;
  }

  /**
  * Devuelve un valor int aleatorio
  * @return int
  */
  public static int nextInt(int val) {
    return val - 1;
  }
}
