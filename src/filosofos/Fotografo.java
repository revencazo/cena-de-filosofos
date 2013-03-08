package filosofos;


/*
 * Singleton para observar siempre en las mismas condiciones
 * a los filosofos
 */
public class Fotografo {

	private Filosofo filosofo;

	private Fotografo() {}

	private static class SingletonHolder {
		public static final Fotografo instance = new Fotografo();
	}

	public static Fotografo getInstance() {
		return SingletonHolder.instance;
	}

	public void dibujaFilosofos(Filosofo primero){
		if (this.filosofo == null) this.filosofo = primero;
		dibujaFilosofos();
	}

	/* equivalente al toString() */
	public  synchronized void dibujaFilosofos(){
		String foto = "";
		Filosofo siguiente = filosofo;
		// mientras el nombre del de la izquierda no sea el primero sigue haciendo fotos
		while(!siguiente.getFilosofoIzda().getNombre().equals(filosofo.getNombre())){
			foto+= "("+siguiente.getNombre()+")" + fotoPalillo(siguiente.getPalilloIzda());
			siguiente = siguiente.getFilosofoIzda();
		}
		foto+= "("+siguiente.getNombre()+")" + fotoPalillo(siguiente.getPalilloIzda());
		System.out.println(foto);
	}

	public String fotoPalillo(Palillo p){
		return p.getPalillo()? "|" : " " ; 
	}
	
	public void destroy(){
		this.filosofo = null;
	}

}
