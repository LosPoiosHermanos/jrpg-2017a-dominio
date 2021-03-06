package tests_dominio;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;
import dominio.MyRandomStub;

import org.junit.Assert;
import org.junit.Test;

public class TestElfo {

	@Test
	public void testGolpeLevel() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(h.getSalud(), 100);
		if (e.habilidadRaza1(h, new MyRandomStub(0))) {
			Assert.assertTrue(h.getSalud() < 100);
		}
		if (!e.habilidadRaza1(h, new MyRandomStub(-5))) {
			Assert.assertEquals(h.getSalud(), 100);
		}
	}

	@Test
	public void testAtaqueBosque() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(h.getSalud(), 100);
		if (e.habilidadRaza2(h, new MyRandomStub(0))) {
			Assert.assertTrue(h.getSalud() < 100);
		}
		if (!e.habilidadRaza2(h, new MyRandomStub(0))) {
			Assert.assertEquals(h.getSalud(), 100);
		}
	}
}
