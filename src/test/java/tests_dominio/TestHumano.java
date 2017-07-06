package tests_dominio;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestHumano {

	@Test
	public void testIncentivar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(e.getAtaque() , 37);
		h.habilidadRaza1(e, new MyRandomStub(0));// en este caso no usa el
													// random
		Assert.assertTrue(e.getAtaque() > 37);
	}

	@Test
	public void testGolpeFatal() {
		HashMap <String,Integer> mapa = new HashMap<String,Integer>();
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h2 = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		mapa.put("energia", 5);
		h2.actualizar(mapa);
		Assert.assertEquals(h.getEnergia() , 100);
		Assert.assertEquals(e.getSalud() , 100);
		if (h.habilidadRaza2(e, new MyRandomStub(0))) {
			Assert.assertEquals(e.getSalud() , 70);
			Assert.assertEquals(h.getEnergia() , 50);
		} if (!h.habilidadRaza2(e, new MyRandomStub(0))) {
			Assert.assertEquals(h.getEnergia() , 90);
			Assert.assertEquals(e.getSalud() , 100);
		}
		Elfo e2 = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 100, 1);
		if (!h2.habilidadRaza2(e2, new MyRandomStub(0))) {
			Assert.assertNotEquals(e2.getSalud() , 70);
			Assert.assertNotEquals(h2.getEnergia() , 50);
		}
	}
}