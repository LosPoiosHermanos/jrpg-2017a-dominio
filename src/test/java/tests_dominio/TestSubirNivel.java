package tests_dominio;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Personaje;
import org.junit.Assert;
import org.junit.Test;

public class TestSubirNivel {

	@Test
	public void testSubirdeNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getNivel() , 1);
		h.ganarExperiencia(50);
		Assert.assertEquals(h.getNivel() , 2);
	}

	@Test
	public void testNivel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.ganarExperiencia(300000);
		Assert.assertEquals(h.getNivel() , 100);
		h.subirNivel();
		Assert.assertEquals(h.getNivel() , 100);
	}

	@Test
	public void testGanarMuchaExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getNivel() , 1);
		h.ganarExperiencia(150);
		Assert.assertEquals(h.getNivel() , 3);
	}
}
