package tests_dominio;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Personaje;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestAsignarPuntos {

	@Test
	public void testAumentarSalud_tope() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getSaludTope(), 105);
		h.ganarExperiencia(50);
		Assert.assertEquals(h.getSaludTope(), 130);
	}

	@Test
	public void testAumentarEnergia_tope() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getEnergiaTope(), 105);
		h.ganarExperiencia(50);
		Assert.assertEquals(h.getEnergiaTope(), 125);
	}

	@Test
	public void testMasDe200Puntos() {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		mapa.put("fuerza", 199);
		mapa.put("destreza", 199);
		mapa.put("inteligencia", 199);
		h.actualizar(mapa);
		h.asignarPuntosSkills(2, 2, 2);
		Assert.assertEquals(h.getFuerza(), 199);
		Assert.assertEquals(h.getDestreza(), 199);
		Assert.assertEquals(h.getInteligencia(), 199);
	}
}
