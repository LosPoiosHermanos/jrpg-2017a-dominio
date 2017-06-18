package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Objeto> objetos;

	public Inventario(){
		objetos = new ArrayList<Objeto>();
	}
	
	public void agregar(Objeto obj){
		
		objetos.add(obj);
	}
	public ArrayList<Objeto> clonar() {
		ArrayList<Objeto> obj = objetos;
		return obj;
	}
	
	public void ver(){
		for (Iterator<Objeto> iterator = objetos.iterator(); iterator.hasNext();) {
			Objeto objeto = (Objeto) iterator.next();
			System.out.println(objeto.getNombre() + "  "+ objeto.getAtributo()+"% " +"de "+objeto.getAtributoModificado());
		}
	}
			
}
