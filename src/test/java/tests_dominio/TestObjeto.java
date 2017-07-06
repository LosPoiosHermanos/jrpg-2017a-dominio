package tests_dominio;


import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;


import dominio.Guerrero;
import dominio.Humano;
import dominio.Objeto;
import dominio.Orco;

public class TestObjeto {

	@Test
	public void testAsignarObjeto(){
		Objeto obj = new Objeto(1);
		Assert.assertEquals("fuerza", obj.getAtributoModificado());
		Objeto obj2 = new Objeto(2);
		Assert.assertEquals("saludTope", obj2.getAtributoModificado());
		
		Objeto obj3 = new Objeto(2);
		Assert.assertEquals("destreza", obj3.getAtributoModificado());
		
		
	}
}
