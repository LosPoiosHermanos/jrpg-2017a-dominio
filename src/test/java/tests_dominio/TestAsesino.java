package tests_dominio;

import dominio.Asesino;
import dominio.Casta;
import dominio.Hechicero;
import dominio.Humano;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestAsesino {

	@Test
	public void testCritico() {
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		if (h.habilidadCasta1(h2)) {
			Humano h3 = new Humano("Nicolas", new Asesino(100, 100, 100), 1);
			if (h3.habilidadCasta1(h))
				Assert.assertTrue(h.getSalud() < 105);

			HashMap<String, Integer> mapa = new HashMap<String, Integer>();
			mapa.put("energia", 1);
			h3.actualizar(mapa);

			if (!h3.habilidadCasta1(h2))
				Assert.assertEquals(1, h3.getEnergia());
		}
	}

	@Test
	public void testProbEvasion() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertTrue(0.3 == h.getCasta().getProbabilidadEvitarDano());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDano(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5 == h.getCasta().getProbabilidadEvitarDano());
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("energia", -1);
		h.actualizar(mapa);
		Assert.assertEquals(h.habilidadCasta2(null), false);
	}

	@Test
	public void testRobar() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Humano h2 = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Casta c1 = new Asesino();
		Assert.assertTrue(c1.habilidad3(h, h2) == false);
	}

}
