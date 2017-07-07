package tests_dominio;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestOrco {

	@Test
	public void testGolpeDefensivo() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Orco o = new Orco("Hernan", new Guerrero(), 1);
		Assert.assertEquals(h.getSalud(), 105);
		if (o.habilidadRaza1(h, new MyRandomStub(0))) {
			Assert.assertEquals(h.getSalud(), 95);
		} else {
			Assert.assertEquals(o.getSalud(), 105);
		}
	}

	@Test
	public void testMordiscoDeVida() {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Humano h2 = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o2 = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(h.getSalud(), 100);
		Assert.assertTrue(h.getSalud() == 100);
		mapa.put("salud", 100);
		o.actualizar(mapa);
		if (o.habilidadRaza2(h, new MyRandomStub(0))) {
			Assert.assertEquals(40, h.getSalud());
			Assert.assertEquals(o.getSalud(), 100);

		}
		if (!o2.habilidadRaza2(h2, new MyRandomStub(-1))) {
			Assert.assertEquals(o2.getSalud(), 100);
			Assert.assertEquals(h2.getSalud(), 100);
		}
	}
}
