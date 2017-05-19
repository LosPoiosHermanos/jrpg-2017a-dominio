package tests_dominio;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;
import org.junit.Assert;
import org.junit.Test;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getInteligencia() == 10);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 10);
		Assert.assertTrue(h2.getDestreza() == 10);
		Assert.assertTrue(h2.getInteligencia() == 15);
		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 10);
		Assert.assertTrue(h3.getDestreza() == 15);
		Assert.assertTrue(h3.getInteligencia() == 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);
		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);
		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 10);
		Assert.assertTrue(e3.getDestreza() == 15);
		Assert.assertTrue(e3.getInteligencia() == 10);
		e.serRobadoSalud(5000);
		Assert.assertTrue(e.getSalud() == 0);
		e.serDesernegizado(5000);
		Assert.assertTrue(e.getEnergia() == 0);
		e.serEnergizado(5000);
		Assert.assertTrue(e.getEnergia() == e.getEnergiaTope());
		Assert.assertTrue(e.getHabilidadesCasta() != null);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 15);
		Assert.assertTrue(o.getDestreza() == 10);
		Assert.assertTrue(o.getInteligencia() == 10);
		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(o2.getSalud() == 110);
		Assert.assertTrue(o2.getEnergia() == 100);
		Assert.assertTrue(o2.getFuerza() == 10);
		Assert.assertTrue(o2.getDestreza() == 10);
		Assert.assertTrue(o2.getInteligencia() == 15);
		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 10);
		Assert.assertTrue(o3.getDestreza() == 15);
		Assert.assertTrue(o3.getInteligencia() == 10);
	}

	@Test
	public void testResstEnergia() {
		Orco orq = new Orco("Hernan", new Asesino(), 3);
		orq.setEnergia(orq.getEnergiaTope() - 10);
		orq.restablecerEnergia();
		Assert.assertTrue(orq.getEnergia() == orq.getEnergiaTope());
	}

	@Test
	public void testResstSalud() {
		Orco orq = new Orco("Hernan", new Asesino(), 3);
		orq.setSalud(orq.getSaludTope() - 10);
		orq.restablecerSalud();
		Assert.assertTrue(orq.getSalud() == orq.getSaludTope());
		orq.setSaludTope(50);
		Assert.assertTrue(orq.getSaludTope() == 50);
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
	}

	@Test
	public void testSets() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.setEnergiaTope(5);
		Assert.assertTrue(5 == h.getEnergiaTope());
		h.setNivel(5);
		Assert.assertTrue(5 == h.getNivel());
		h.setIdPersonaje(5);
		Assert.assertTrue(5 == h.getIdPersonaje());
		h.setMagia(5);
		Assert.assertTrue(5 == h.getMagia());
		h.setExperiencia(5);
		Assert.assertTrue(5 == h.getExperiencia());
		h.setNombre("julian");
		Assert.assertEquals("julian", h.getNombre());
		h.setNombreRaza("orco");
		Assert.assertEquals("orco", h.getNombreRaza());
		Casta c = new Guerrero();
		h.setCasta(c);
		Assert.assertTrue(h.getCasta().getNombreCasta() == c.getNombreCasta());
		Assert.assertTrue(h.getX() == 0);
		Assert.assertTrue(h.getY() == 0);
	}
}
