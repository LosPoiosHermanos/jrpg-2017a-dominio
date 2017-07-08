package dominio;

import java.util.LinkedList;

/**
 * Anade o elimina jugadores a un equipo determinado
 */
public class Alianza {

	private String nombre;
	private LinkedList<Personaje> aliados;

	/**
	 * crea una alianza con un nombre determinado
	 * @param nombre Se crea una alianza con dicho nombre
	 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * devuelve todos los miembros de la alianza
	 * @return Personaje
	 */
	public LinkedList<Personaje> obtenerAliados() {
		LinkedList<Personaje> copia = this.aliados;
		return copia;
	}

	/**
	 * devuelve el nombre de la alianza
	 * @return String Nombre de la Alianza
	 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Elimina un personaje de la alianza.
	 * @param pj Se elimina el personaje de la lista de la Alianza
	 */
	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * Anade un personaje a la alianza.
	 * @param pj Se agrega un personaje en la lista de la Alianza
	 */
	public void agregarPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
