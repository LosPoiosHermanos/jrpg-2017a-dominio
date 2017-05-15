package dominio;

import java.util.Random;

/**
 * devuelve valores aleatorios de tipo "int" o "double"
 * 
 */
public class MyRandom extends RandomGenerator{

  /**
  * Devuelve un valor double aleatorio
  * @return double
  */
	@Override
  public double nextDouble() {
    return new Random().nextDouble();
  }

  /**
  * Devuelve un valor int aleatorio menor al parametro max
  * @return int
  */
  	@Override
  public  int nextInt(int max){
    return new Random().nextInt(max);
  }
}
