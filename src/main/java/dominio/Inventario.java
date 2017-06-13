package dominio;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

	private ArrayList<Objeto> objetos;
	
	public Inventario(){
		
		objetos = new ArrayList<Objeto>();
	}
	
	public void añadir(Objeto obj){
		
		objetos.add(obj);
	}
	public ArrayList<Objeto> clone() {
		ArrayList<Objeto> obj = objetos;
		return obj;
	}
	
	public void ver(){
		
		for (Iterator iterator = objetos.iterator(); iterator.hasNext();) {
			Objeto objeto = (Objeto) iterator.next();
			System.out.println(objeto.getNombre() + "  "+ objeto.getAtributo()+"% " +"de "+objeto.getAtributoModificado());
		}
	}
			
}
