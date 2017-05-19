package tests_dominio;

import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;
import dominio.Peleable;
import org.junit.Assert;
import org.junit.Test;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1, new MyRandomStub(0));
		Assert.assertTrue(30 == npc.otorgarExp());
	}

	@Test
	public void testAtacar() {
		Peleable p1 = new NonPlayableCharacter("Fulanito", 10, 1, new MyRandomStub(0));
		Peleable p2 = new NonPlayableCharacter("Carlos", 3, 10, new MyRandomStub(0));
		Peleable p3 = new NonPlayableCharacter("Roberto", 10, 3, new MyRandomStub(0));
		Peleable p4 = new NonPlayableCharacter("Luis", 4, 2, new MyRandomStub(0));
		Peleable p5 = new NonPlayableCharacter("Cosme", 5, 5, new MyRandomStub(0));
		Peleable p6 = new NonPlayableCharacter("Homero", 53, 0, new MyRandomStub(0));
		Assert.assertTrue(p1.atacar(p2, new MyRandomStub(0)) >= 0);
		Assert.assertTrue(p2.atacar(p3, new MyRandomStub(0)) >= 0);
		Assert.assertTrue(p4.atacar(p5, new MyRandomStub(0)) >= 0);
		Assert.assertTrue(p5.atacar(p6, new MyRandomStub(0)) >= 0);
	}

	@Test
	public void testSets() {
		int nivel = 10;
		NonPlayableCharacter p1 = new NonPlayableCharacter("Fulanito", nivel, 1, new MyRandomStub(0));
		double x = p1.getAtaque();
		p1.setAtaque(333);
		Assert.assertTrue(x != p1.getAtaque());
		p1.setNivel(5);
		Assert.assertTrue(5 == p1.getNivel());
		p1.setAtaque(5);
		Assert.assertTrue(p1.getAtaque() == 5);
		p1.setDefensa(5);
		Assert.assertTrue(p1.getDefensa() == 5);
		p1.setFuerza(5);
		Assert.assertTrue(p1.getFuerza() == 5);
		p1.setSalud(5);
		Assert.assertTrue(p1.getSalud() == 5);
		p1.setNombre("gabriel");
		Assert.assertTrue(p1.getNombre() == "gabriel");
	}
}
