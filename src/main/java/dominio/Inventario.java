package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventario implements Serializable {

	private static final long serialVersionUID = 1L;
	public static int MAXOBJETOS = 20;
	private ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	/**
	 * Crea un inventario
	 */
	public Inventario() {

	}
	/**
	 * Crea un inventario con las Keys de los objetos
	 * @param ids Vector de Keys de objetos a
	 * agregar en el inventario
	 */
	public Inventario(final int[] ids) {
		for (int j = 0; j < MAXOBJETOS; j++) {
			objetos.add(new Objeto(ids[j]));
		}
	}
	/**
	 * Agrega un objeto al inventario
	 * @param obj Objeto a agregar al inventario
	 */
	public void agregar(final Objeto obj) {
		objetos.add(obj);

	}
	/**
	 * Retorna el inventario
	 * @return ArrayList Devuelve la lista
	 * del inventario
	 */
	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}
	/**
	 * Agrega un objeto de Key random al inventario
	 * @return Objeto que se agrego al inventario
	 */
	public Objeto agregarObjeto() {
		//siso
		Objeto obj = new Objeto();
		if (obj.getId() > 0) {
			objetos.add(obj);
			return obj;
		}
		if (objetos.contains(obj)) {
			return null;
		}
		return null;
	}
	/**
	 * Clona la lista de objetos y devuelta una
	 * lista del inventario
	 * @return ArrayList Lista de objetos del inventario
	 */
	public ArrayList<Objeto> clonar() {
		ArrayList<Objeto> obj = objetos;
		return obj;
	}
	/**
	 * Retorna un vector con las IDs de los
	 * objetos actuales en el inventario
	 * @return Vector Int con los valores de las
	 * keys de los objetos
	 */
	public int[] getIdObjetos() {
		int[] ids = new int[MAXOBJETOS];
		int i = 0;
		for (Objeto obj : objetos) {
			if (obj.getId() > 0) {
				ids[i] = obj.getId();
				i++;
			}
		}
		return ids;
	}
	/**
	 * Reestablece todos los objetos del inventario
	 * @param ids Vector con las IDs de los objetos
	 */
	public void reestablecerObjetos(final int[] ids) {
		for (int j = 0; j < MAXOBJETOS; j++) {
			objetos.add(new Objeto(ids[j]));
		}
	}
	/**
	 * Quita un objeto especifico del inventario
	 * @param obj Objeto a eliminar del inventario
	 */
	public void quitarObjeto(final Objeto obj) {
		for (Objeto objeto : objetos) {
			if (objeto.getId().equals(obj.getId())) {
				objetos.remove(objeto);
				return;
			}
		}
	}
	/**
	 * Devuelta la cantidad de objetos
	 * en el inventario
	 * @return Int Cantidad de objetos
	 */
	public int getCantidadObjetos() {
		int i = 0;
		for (Objeto obj : objetos) {
			if (obj.getId() > 0) {
				i++;
			}
		}
		return i;
	}
	/**
	 * Retorna el objeto segun su ID
	 * @param idObjeto ID o key del objeto
	 * @return Objeto Retorna todo el objeto
	 */
	public Objeto getObjeto(final int idObjeto) {
		for (Objeto objeto : objetos) {
			if (objeto.getId().equals(idObjeto)) {
				return new Objeto(idObjeto);
			}
		}
		return null;
	}
	/**
	 * Devuelve tre si el Id de un objeto esta
	 * en el inventario
	 * @param id Key que representa al objeto
	 * @return true si encuentra el objeto
	 */
	public boolean estaEnInventario(final int id) {
		for (Objeto objeto : objetos) {
			if (objeto.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

}
