package tests_dominio;

import dominio.Asesino;
import dominio.Humano;
import dominio.Personaje;
import org.junit.Assert;
import org.junit.Test;

public class TestNivelExp {

	@Test
	public void testGanarExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(45);
		Assert.assertEquals(h.getExperiencia(), 45);
	}

	@Test
	public void testSubirNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.ganarExperiencia(300);
		Assert.assertEquals(h.getNivel(), 4);
		Assert.assertEquals(h.getExperiencia(), 0);
	}

	@Test
	public void testLevel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 99, 1);
		h.ganarExperiencia(10000);
		Assert.assertEquals(h.getNivel(), 100);
	}
}
