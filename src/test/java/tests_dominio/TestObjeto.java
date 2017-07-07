package tests_dominio;

import org.junit.Assert;
import org.junit.Test;
import dominio.Objeto;

public class TestObjeto {

	@Test
	public void testAsignarObjeto() {
		Objeto obj = new Objeto(1);
		Assert.assertNotEquals(obj, null);
		Objeto obj2 = new Objeto();
		Assert.assertNotEquals(obj2, null);

	}

	@Test
	public void testPerderObjeto() {
		Objeto obj = new Objeto(1);
		Assert.assertEquals("saludTope", obj.getAtributoModificado());
		Objeto obj2 = new Objeto(2);
		Assert.assertEquals("saludTope", obj2.getAtributoModificado());

		Objeto obj3 = new Objeto(7);
		Assert.assertEquals("destreza", obj3.getAtributoModificado());
	}
}
