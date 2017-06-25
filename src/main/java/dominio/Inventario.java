package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Inventario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public static int MAX_OBJETOS = 20;
	private ArrayList<Objeto> objetos = new ArrayList<Objeto>();


	
	public Inventario(){
		
	}
	public Inventario(int[] ids){
		
		for (int j = 0; j < MAX_OBJETOS; j++) {
			objetos.add(new Objeto(ids[j]));
		}
	}
	
	public void agregar(Objeto obj){
		objetos.add(obj);

	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public Objeto agregarObjeto() {
		Objeto obj = new Objeto();
		if(obj.getId() > 0){
			objetos.add(obj);
			return obj;
		}
		if(objetos.contains(obj))
			return null;
		return null;
	}

	public ArrayList<Objeto> clonar() {
		ArrayList<Objeto> obj = objetos;
		return obj;
	}
	public int[] getIdObjetos() {
		int[] ids= new int[MAX_OBJETOS];
		int  i = 0;
		//System.out.println(objetos.size());trae21 objetoos
		for (Objeto obj : objetos) {
			if(obj.getId() > 0){
				ids[i] = obj.getId(); 
				i++;
			}
				
		}
		return ids;
	}
	
	public void reestablecerObjetos(int[] ids){
		
		for (int j = 0; j < MAX_OBJETOS; j++) {
			objetos.add(new Objeto(ids[j]));
		}
	}
	
}
