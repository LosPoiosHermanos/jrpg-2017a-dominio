package tests_dominio;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;
import org.junit.Assert;
import org.junit.Test;

public class TestDaño {

	@Test
	public void testAtaqueComunYLaSaludNoBajeDe0() {
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		Assert.assertEquals(o.getSalud(), 100);
		if (h.atacar(o, new MyRandomStub(0)) != 0) {
			Assert.assertEquals(o.getSalud(), 0);
			h.atacar(o, new MyRandomStub(0));
			Assert.assertEquals(o.getSalud(), 0);
			h.atacar(o, new MyRandomStub(0));
			Assert.assertEquals(o.getSalud(), 0);
		}
		if (h.atacar(o, new MyRandomStub(0)) == 0)
			Assert.assertEquals(o.getSalud(), 0);
	}

	@Test
	public void testLosMuertosNoAtacan() {
		Humano h = new Humano("Nico", 100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		h.atacar(o, new MyRandomStub(0));
		h.atacar(o, new MyRandomStub(0));
		h.atacar(o, new MyRandomStub(0));
		h.atacar(o, new MyRandomStub(0));
		o.atacar(h, new MyRandomStub(0));
		Assert.assertEquals(100, h.getSalud());
	}
}