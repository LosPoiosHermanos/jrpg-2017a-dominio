package tests_dominio;


import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Inventario;
import dominio.MyRandomStub;
import dominio.Objeto;
import dominio.Orco;
import dominio.Personaje;

public class TestObjeto {

	@Test
	public void testAsignarObjeto(){
		Objeto obj = new Objeto(1);
		Assert.assertNotEquals(obj,null);
		Objeto obj2 = new Objeto();
		Assert.assertNotEquals(obj2,null);		
	}
	
	@Test
	public void testPerderObjeto(){
		
	}
}
