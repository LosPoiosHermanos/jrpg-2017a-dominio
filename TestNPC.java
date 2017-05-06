package tests_dominio;

import dominio.NonPlayableCharacter;
import dominio.Peleable;
import org.junit.Assert;
import org.junit.Test;

public class TestNPC {

  @Test
  public void testOtorgarExp() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
    Assert.assertTrue(30 == npc.otorgarExp());
  }
  
  @Test
  public void testAtacar() {
    Peleable p1 = new NonPlayableCharacter("Fulanito", 10, 1);
    Peleable p2 = new NonPlayableCharacter("Carlos", 3, 10);
    Peleable p3 = new NonPlayableCharacter("Roberto", 10, 3);
    Peleable p4 = new NonPlayableCharacter("Luis", 4, 2);
    Peleable p5 = new NonPlayableCharacter("Cosme", 5, 5);
    Peleable p6 = new NonPlayableCharacter("Homero", 53, 0);
    Assert.assertTrue(p1.atacar(p2) >= 0);
    Assert.assertTrue(p2.atacar(p3) >= 0);
    Assert.assertTrue(p4.atacar(p5) >= 0);
    Assert.assertTrue(p5.atacar(p6) >= 0);
  }
  
  @Test
  public void testSets() {
    int nivel = 10;
    NonPlayableCharacter p1 = new NonPlayableCharacter("Fulanito", nivel, 1);
    double x = p1.getAtaque();
    p1.setAtaque(333);
    Assert.assertTrue(x != p1.getAtaque());
    p1.setNivel(5);
    Assert.assertTrue(5 == p1.getAtaque());
    int x2 = p1.getFuerza();
    p1.setFuerza(x2 + 5);
    Assert.assertTrue(x2 != p1.getFuerza());
    x2 = p1.getDefensa();
    p1.setDefensa(x2 + 5);
    Assert.assertTrue(x2 != p1.getDefensa());
  }
}
