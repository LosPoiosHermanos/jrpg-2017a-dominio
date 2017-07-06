package tests_dominio;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestHechicero {

	@Test
	public void testCurar() {
		HashMap <String,Integer> mapa = new HashMap<String,Integer>();
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(e.getSalud() , 100);
		mapa.put("salud", 65);
		e.actualizar(mapa);
		Assert.assertEquals(e.getSalud() , 65);
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		h.habilidadCasta2(e);
		Assert.assertTrue(e.getSalud() > 65);
		Humano h2 = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e2 = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		mapa.remove("salud");
		mapa.put("energia", 1);
		h2.actualizar(mapa);
		Assert.assertEquals(e2.getSalud() , 100);
		mapa.remove("energia");
		mapa.put("salud", 65);
		e2.actualizar(mapa);
		Assert.assertEquals(e2.getSalud() , 65);
		h2.habilidadCasta2(e2);
		Assert.assertFalse(e2.getSalud() > 65);
	}

	@Test
	public void testBolaDeFuego() {
		HashMap <String,Integer> mapa = new HashMap<String,Integer>();
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 0, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(e.getSalud() , 100);
		
		if(h.habilidadCasta1(e))
		Assert.assertTrue(e.getSalud() < 100);
		
		mapa.put("energia", -1);
		h.actualizar(mapa);
		if((h.habilidadCasta1(e))==false)
			Assert.assertEquals(h.getEnergia(),-1);
	
		Humano h2 = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e2 = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		h2.actualizar(mapa);
		if(h2.habilidadCasta1(e2)==false);
		Assert.assertEquals(e2.getSalud(),100);
	}
	
	@Test
	public void testRobarEnergia_y_Salud() {
		HashMap <String,Integer> mapa = new HashMap<String,Integer>();
		Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertTrue(e.getSalud() == 100);
		mapa.put("salud", 50);
		mapa.put("energia", 50);
		h.actualizar(mapa);
		
		if (h.habilidadCasta3(e)) {
			Assert.assertTrue(e.getSalud() < 100);
			Assert.assertTrue(h.getEnergia() > 50);
			Assert.assertTrue(h.getSalud() > 50);
		} 
		
		mapa.remove("salud");
		mapa.remove("energia");
		mapa.put("energia", 8);
		h.actualizar(mapa);
		
		Assert.assertTrue(h.habilidadCasta3(e)==false);
	
	}
	}
