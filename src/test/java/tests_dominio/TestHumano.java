package tests_dominio;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import org.junit.Assert;
import org.junit.Test;

public class TestHumano {

  @Test
  public void testIncentivar() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Assert.assertTrue(e.getAtaque() == 37);
    h.habilidadRaza1(e);
    Assert.assertTrue(e.getAtaque() > 37);
  }

  @Test
  public void testGolpeFatal() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h2 = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    h2.setEnergia(5);
    Assert.assertTrue(h.getEnergia() == 100);
    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadRaza2(e)) {
      Assert.assertTrue(e.getSalud() == 70);
      Assert.assertTrue(h.getEnergia() == 50);
    }
    Elfo e2 = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 100, 1);
    if (!h2.habilidadRaza2(e2)) {
      Assert.assertFalse(e2.getSalud() == 70);
      Assert.assertFalse(h2.getEnergia() == 50);
    }
  }
}