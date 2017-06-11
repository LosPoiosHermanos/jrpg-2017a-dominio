package tests_dominio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import dominio.Arma;
import dominio.Armadura;
import dominio.Guantes;
import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Objeto;
import dominio.Orco;

public class TestObjeto {

	@Test
	public void testAtributoRandom() {
		
		Objeto o1 = new Armadura();
		Objeto o2 = new Guantes();
		Objeto o3 = new Arma();
		
		System.out.println(o1.getAtributo());
		System.out.println(o2.getAtributo());
		System.out.println(o3.getAtributo());
		
	}
	
	@Test
	public void testObjetoAlGanar(){
		
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		
		HashMap <String,Integer> mapa = new HashMap<String,Integer>();
		mapa.put("salud", 1);
		o.actualizar(mapa);

		System.out.println("inventario antes: ");
			h.VerInventario();
			
			h.atacar(o, new MyRandomStub(0));
		
		System.out.println("inventario despues: ");
			h.VerInventario();
			
	}
	
	@Test
	public void testAtributosObjeto(){
		
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		
		System.out.println("antes:");
		System.out.println("fuerza: "+h.getFuerza() + " defensa: "+ h.getDefensa()+ " salud: "+ h.getSalud());
		
		h.ganarObjeto();
		
		System.out.println("inventario: ");
		System.out.println(" ");
		h.VerInventario();
			
			System.out.println("despues:");
			System.out.println("fuerza: "+h.getFuerza() + " defensa: "+ h.getDefensa()+ " salud: "+ h.getSalud());		
			
	}
	
	
	
	
}
