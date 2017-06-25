package dominio;

public class Objeto {

	protected Integer id;
	
	protected String nombre;
	protected int atributo;
	protected String atributoModificado;
	protected MyRandom rand = new MyRandom();

	public Objeto() {
		id = rand.nextInt(19) + 1;
		asignarObjeto();
	}

	public Integer getId() {
		return id;
	}

	public Objeto(int key) {
		id = key;
		asignarObjeto();
	}
/**
 * Los objetos dan bonus para los atributos : fuerza saludtope y destreza
 */
	private void asignarObjeto() {
		
		switch (id) {
		case 0:
			nombre = "Brazalete";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 1:
			nombre = "Cuchilla";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 2:
			nombre = "Guantes";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 3:
			nombre = "Botas";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 4:
			nombre = "Martillo";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 5:
			nombre = "Espada";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 6:
			nombre = "Lanza";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 7:
			nombre = "Martillo";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 8:
			nombre = "Hacha";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 9:
			nombre = "Armadura";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 10:
			nombre = "Boomerang";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 11:
			nombre = "Anillo";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 12:
			nombre = "Capa";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 13:
			nombre = "Sombrero";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 14:
			nombre = "Casco";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 15:
			nombre = "Escudo";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 16:
			nombre = "Katana";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 17:
			nombre = "Cetro";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 18:
			nombre = "Posion";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		case 19:
			nombre = "Espada";
			atributo = 10;
			atributoModificado = "fuerza";
			break;
		
		default:
			break;
		}
	}

	public String getAtributoModificado() {
		return atributoModificado;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAtributo() {
		return atributo;
	}

	public MyRandom getRand() {
		return rand;
	}

}
