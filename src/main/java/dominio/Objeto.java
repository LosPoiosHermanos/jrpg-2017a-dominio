package dominio;

public abstract class Objeto {

	protected String nombre;
	protected int atributo;
	protected String atributoModificado;
	protected MyRandom rand = new MyRandom();
	
	public Objeto() {
		
		int aleatorio = rand.nextInt(6);
		
		atributo=rand.nextInt(41);
		
		if(aleatorio ==0)
			atributo=atributo*-1;
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
