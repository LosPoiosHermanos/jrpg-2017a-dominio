package tests_dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.Hechicero;
import dominio.Humano;
import dominio.Inventario;
import dominio.Objeto;
import dominio.Personaje;

public class TestInventario {

	@Test
	public void testAgregarobjeto() {
		Inventario inv = new Inventario();
		Objeto obj= new Objeto();
		inv.agregar(obj);
		Assert.assertTrue(inv.estaEnInventario(obj.getId()));
		Assert.assertEquals(inv.getCantidadObjetos(),1);		
		Assert.assertNotEquals(inv.getObjeto(obj.getId()),null);
		Assert.assertEquals(inv.getObjeto(-2),null);
		Assert.assertEquals(inv.estaEnInventario(-2),false);
		inv.quitarObjeto(obj);
		Assert.assertEquals(inv.getCantidadObjetos(),0);		
		if(inv.agregarObjeto()==null)
			Assert.assertEquals(inv.getCantidadObjetos(),1);	
	}
	
	@Test
	public void TestIds(){
		Inventario inv = new Inventario();
		Objeto obj= new Objeto();
		inv.agregar(obj);
		Assert.assertNotEquals(inv.getIdObjetos(),null);
		Assert.assertNotEquals(inv.clonar(),null);
		Objeto obj2 = new Objeto();
		int ids[] = new int[20];
		ids[0] = obj2.getId();
		inv.reestablecerObjetos(ids);
		Assert.assertTrue(inv.estaEnInventario(obj2.getId()));
		Assert.assertNotEquals(inv.getObjetos(),null);
	}
	
	 @Test
	 public void TestInventarioPersonaje(){
		 Personaje h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		 Objeto obj = new Objeto();
		 h.getInventario().agregar(obj);
		 Assert.assertNotEquals(obj.getNombre(),null);
		 int ids[] = new int [20];
		 ids[0] = obj.getId();
		 
		 Assert.assertEquals(h.getCantidadObjetos(),1);
		 h.quitarObjeto(obj);
		 Assert.assertEquals(h.getCantidadObjetos(),0);
		 h.reestablecerInventario(ids);
		 Assert.assertEquals(h.getCantidadObjetos(),1);
		 
		 h.perderObjeto(obj);
		 Assert.assertEquals(h.getInventario().getCantidadObjetos(),1);
	 }
	
	
	@Test
	public void testAgregarVariosObjetos(){
		int ids[] = new int[20];
		Objeto obj;
		for(int i=0;i<20;i++){
			obj = new Objeto();
			ids[i] =obj.getId();
		}
		Inventario inv = new Inventario(ids);
		Assert.assertEquals(inv.getCantidadObjetos(),20);
	}

}
