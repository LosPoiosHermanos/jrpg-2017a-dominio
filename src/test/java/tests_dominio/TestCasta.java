package tests_dominio;

import dominio.Asesino;
import dominio.Casta;
import org.junit.Assert;
import org.junit.Test;

public class TestCasta {
	@Test
	public void testHabilidades() {
		Casta c1 = new Asesino();
		Assert.assertNotNull(c1.getHabilidadesCasta());
		Assert.assertNotNull(c1.getNombreCasta());
		double danio = c1.getDanoCritico();
		c1.setDanoCritico(33.33);
		Assert.assertNotEquals(danio , c1.getDanoCritico());
		danio = c1.getProbabilidadEvitarDano();
		c1.setProbabilidadEvitarDano(33.33);
		Assert.assertNotEquals(danio , c1.getProbabilidadEvitarDano());
		danio = c1.getProbabilidadGolpeCritico();
		c1.setProbabilidadGolpeCritico(33.33);
		Assert.assertNotEquals(danio , c1.getProbabilidadGolpeCritico());
		
		Assert.assertEquals(c1.getNombreCasta(),"Asesino");
		Assert.assertNotEquals(c1.getHabilidadesCasta(),null);
	}
}