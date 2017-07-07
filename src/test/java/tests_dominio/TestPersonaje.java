package tests_dominio;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandom;
import dominio.Objeto;
import dominio.Orco;
import dominio.Personaje;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getSalud(), 105);
		Assert.assertEquals(h.getEnergia(), 105);
		Assert.assertEquals(h.getFuerza(), 15);
		Assert.assertEquals(h.getDestreza(), 10);
		Assert.assertEquals(h.getInteligencia(), 10);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(h2.getSalud(), 105);
		Assert.assertEquals(h2.getEnergia(), 105);
		Assert.assertEquals(h2.getFuerza(), 10);
		Assert.assertEquals(h2.getDestreza(), 10);
		Assert.assertEquals(h2.getInteligencia(), 15);
		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertEquals(h3.getSalud(), 105);
		Assert.assertEquals(h3.getEnergia(), 105);
		Assert.assertEquals(h3.getFuerza(), 10);
		Assert.assertEquals(h3.getDestreza(), 15);
		Assert.assertEquals(h3.getInteligencia(), 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(e.getSalud(), 100);
		Assert.assertEquals(e.getEnergia(), 110);
		Assert.assertEquals(e.getFuerza(), 15);
		Assert.assertEquals(e.getDestreza(), 10);
		Assert.assertEquals(e.getInteligencia(), 10);
		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(e2.getSalud(), 100);
		Assert.assertEquals(e2.getEnergia(), 110);
		Assert.assertEquals(e2.getFuerza(), 10);
		Assert.assertEquals(e2.getDestreza(), 10);
		Assert.assertEquals(e2.getInteligencia(), 15);
		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertEquals(e3.getSalud(), 100);
		Assert.assertEquals(e3.getEnergia(), 110);
		Assert.assertEquals(e3.getFuerza(), 10);
		Assert.assertEquals(e3.getDestreza(), 15);
		Assert.assertEquals(e3.getInteligencia(), 10);
		e.serRobadoSalud(5000);
		Assert.assertEquals(e.getSalud(), 0);
		e.serDesernegizado(5000);
		Assert.assertEquals(e.getEnergia(), 0);
		e.serEnergizado(5000);
		Assert.assertEquals(e.getEnergia(), e.getEnergiaTope());
		Assert.assertNotEquals(e.getHabilidadesCasta(), null);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(o.getSalud(), 110);
		Assert.assertEquals(o.getEnergia(), 100);
		Assert.assertEquals(o.getFuerza(), 15);
		Assert.assertEquals(o.getDestreza(), 10);
		Assert.assertEquals(o.getInteligencia(), 10);
		;
		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(o2.getSalud(), 110);
		Assert.assertEquals(o2.getEnergia(), 100);
		Assert.assertEquals(o2.getFuerza(), 10);
		Assert.assertEquals(o2.getDestreza(), 10);
		Assert.assertEquals(o2.getInteligencia(), 15);
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertEquals(o3.getSalud(), 110);
		Assert.assertEquals(o3.getEnergia(), 100);
		Assert.assertEquals(o3.getFuerza(), 10);
		Assert.assertEquals(o3.getDestreza(), 15);
		Assert.assertEquals(o3.getInteligencia(), 10);
	}

	@Test
	public void testResstEnergia() {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		Orco orq = new Orco("Hernan", new Asesino(), 3);
		mapa.put("energia", orq.getEnergiaTope() - 10);
		orq.actualizar(mapa);
		orq.restablecerEnergia();
		Assert.assertEquals(orq.getEnergia(), orq.getEnergiaTope());
	}

	@Test
	public void testResstSalud() {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		Orco orq = new Orco("Hernan", new Asesino(), 3);
		mapa.put("salud", orq.getSaludTope() - 10);
		orq.actualizar(mapa);
		orq.restablecerSalud();
		Assert.assertEquals(orq.getSalud(), orq.getSaludTope());
		mapa.remove("salud");
		mapa.put("saludTope", 50);
		orq.actualizar(mapa);
		Assert.assertEquals(orq.getSaludTope(), 50);
	}

	@Test
	public void tesDistancia() {
		Orco orq = new Orco("Hernan", new Asesino(), 3);
		Elfo elf = new Elfo("Nicolas", new Guerrero(), 1);
		orq.setDistancia(2, 2);
		elf.setDistancia(51, 2);
		Assert.assertTrue(orq.distanciaCon(elf) == 49);
	}

	@Test
	public void testCrearAlianza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.crearAlianza("MyClan");
		Assert.assertTrue(h.getClan().obtenerNombre().equals("MyClan"));
	}

	@Test
	public void testPuedeAtacar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.puedeAtacar() == true);
		HashMap<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("energia", 9);
		h.actualizar(mapa);
		Assert.assertEquals(h.puedeAtacar(), false);
	}

	@Test
	public void testSerAtacadoFallo() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		MyRandom r = new MyRandom();
		h.serAtacado(-1, r);
	}

	@Test
	public void testRobarSaludFallo() {
		Personaje h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.serRobadoSalud(-1), 0);
	}

	@Test
	public void TestAtaqueMagiaYDefensa() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		int magia = h.getMagia();
		int ataque = h.getAtaque();
		int defensa = h.getDefensa();

		h.aumentarAtaque(5);
		h.aumentarMagia(5);
		h.aumentarDefensa(5);

		Assert.assertEquals(h.getMagia(), magia + 5);
		Assert.assertEquals(h.getAtaque(), ataque + 5);
		Assert.assertEquals(h.getDefensa(), defensa + 5);
	}

	@Test
	public void TestidObjetos() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.getInventario().agregar(new Objeto());
		Assert.assertNotEquals(h.getIdDeObjetos(), null);
	}

	@Test
	public void testSets() {
		HashMap<String, Object> mapa = new HashMap<String, Object>();

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		mapa.put("energiaTope", 5);
		mapa.put("nivel", 5);
		mapa.put("experiencia", 5);
		Casta c = new Guerrero();
		mapa.put("casta", c);
		mapa.put("idPersonaje", 5);
		h.actualizar(mapa);
		h.setNombreRaza("Humano");

		Assert.assertEquals(h.getNombreRaza(), "Humano");
		Assert.assertEquals(5, h.getEnergiaTope());
		Assert.assertEquals(5, h.getNivel());
		Assert.assertEquals(5, h.getIdPersonaje());
		h.setMagia(5);
		Assert.assertEquals(5, h.getMagia());
		Assert.assertEquals(5, h.getExperiencia());
		h.setNombre("julian");
		Assert.assertEquals("julian", h.getNombre());
		Assert.assertEquals(h.getCasta().getNombreCasta(), c.getNombreCasta());
		Assert.assertEquals(h.getX(), 0);
		Assert.assertEquals(h.getY(), 0);
	}
}
