package tests_dominio;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import org.junit.Assert;
import org.junit.Test;

public class TestGuerrero {

	@Test
	public void testDobleGolpe() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta1(e)) {
			Assert.assertTrue(e.getSalud() < 100);
		}
		Humano h2 = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e2 = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		h2.setEnergia(5);
		if (!h2.habilidadCasta1(e2)) {
			Assert.assertTrue(e2.getSalud() == 100);
		}
	}

	@Test
	public void testAutoDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertTrue(h.getDefensa() == 20);
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa() == 65);
		Humano h2 = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		h2.setEnergia(1);
		h2.habilidadCasta2(null);
		Assert.assertFalse(h2.getDefensa() == 65);
	}

	@Test
	public void testIgnoraDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta3(e)) {
			Assert.assertTrue(e.getSalud() < 100);
		}else
			Assert.assertTrue(e.getSalud() == 100);
		Humano h2 = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e2 = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		h2.setEnergia(5);
		if (!h2.habilidadCasta3(e2)) {
			Assert.assertTrue(e2.getSalud() == 100);
		}
	}
}
