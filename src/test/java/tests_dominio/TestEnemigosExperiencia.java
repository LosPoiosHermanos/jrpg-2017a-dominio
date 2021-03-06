package tests_dominio;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;
import dominio.Personaje;
import org.junit.Assert;
import org.junit.Test;

public class TestEnemigosExperiencia {

	@Test
	public void testPjvsNPC() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0, new MyRandomStub(0));
		Personaje.cargarTablaNivel();
		Assert.assertEquals(h.getExperiencia(), 0);
		while (npc.estaVivo()) {
			h.atacar(npc, new MyRandomStub(0));
		}
		h.ganarExperiencia(npc.otorgarExp());
		Assert.assertEquals(h.getExperiencia(), 30);
	}

	@Test
	public void testMasFuerteMasExperiencia() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0, new MyRandomStub(0));
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 2, 0, new MyRandomStub(0));
		Assert.assertTrue(npc.otorgarExp() < npc2.otorgarExp());
	}

	@Test
	public void testPjvsPj() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 2);
		Personaje.cargarTablaNivel();
		Assert.assertEquals(h.getExperiencia(), 0);
		Assert.assertEquals(h2.getExperiencia(), 0);
		while (h2.estaVivo()) {
			h.atacar(h2, new MyRandomStub(0));
		}
		h.ganarExperiencia(h2.otorgarExp());
		Assert.assertTrue(h.getExperiencia() == 40);
		Assert.assertTrue(h2.getExperiencia() == 0);
	}
}
