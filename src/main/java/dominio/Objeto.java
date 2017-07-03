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
		String matrizObjetos[][] = {{"Brazalete","10","fuerza"},{"Cuchilla","10","fuerza"},
				{"Guantes","10","fuerza"},{"Botas","10","fuerza"},
				{"Martillo","10","fuerza"},{"Espada","10","fuerza"},
				{"Lanza","10","fuerza"},{"Martillo","10","fuerza"},
				{"Hacha","10","fuerza"},{"Armadura","10","fuerza"},
				{"Boomerang","10","fuerza"},{"Anillo","10","fuerza"},
				{"Capa","10","fuerza"},{"Sombrero","10","fuerza"},
				{"Casco","10","fuerza"},{"Escudo","10","fuerza"},
				{"Katana","10","fuerza"},{"Cetro","10","fuerza"},
				{"Posion","10","fuerza"},{"Espada","10","fuerza"}};
		
		if( id > 0 && id < matrizObjetos.length ){
			nombre = matrizObjetos[id-1][0] ;
			atributo = Integer.parseInt(matrizObjetos[id-1][1]); 
			atributoModificado = matrizObjetos[id-1][2];
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
