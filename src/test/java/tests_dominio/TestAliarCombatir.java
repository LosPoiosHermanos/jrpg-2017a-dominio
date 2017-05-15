package tests_dominio;

import dominio.Alianza;
import dominio.Asesino;
import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Personaje;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestAliarCombatir {

  @Test
    public void testCrearAlianza() {
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Humano h2 = new Humano("Lautaro",new Guerrero(),1);
    Assert.assertNull(h.getClan());
    Assert.assertNull(h2.getClan());
    h.aliar(h2);
    Assert.assertNotNull(h.getClan());
    Assert.assertNotNull(h2.getClan());
  }
  
  @Test
    public void testDañar() {
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Humano h2 = new Humano("Lautaro",new Asesino(),1);
    Assert.assertTrue(h2.getSalud() == 105);
    if (h.atacar(h2, new MyRandomStub(0)) != 0) {
      Assert.assertTrue(h2.getSalud() < 105);
    } else {
      Assert.assertTrue(h2.getSalud() == 105);
    }   
  }
  
  @Test
  public void testAliar() {
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Humano h2 = new Humano("Lautaro",new Guerrero(),1);
    Alianza a1 = new Alianza("Los CacheFC");
    Assert.assertNull(h2.getClan());
    Assert.assertNull(h.getClan());
    h.setClan(a1);
    Assert.assertNotNull(h.getClan());
    h.aliar(h2);
    Assert.assertTrue(h.getClan() == h2.getClan());
    h.salirDeAlianza();
    Assert.assertTrue(h.getClan() == null);
    LinkedList<Personaje> listap = a1.obtenerAliados();
    Assert.assertTrue(listap.size() == 1);

  }
}
