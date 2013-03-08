import filosofos.Filosofo;
import filosofos.Palillo;

public class Cena {
	private static final int NUM_FILOSOFOS = 8;
	private static final TipoFilosofo TIPO = TipoFilosofo.STANDAR;
	private Filosofo primero;
	private Filosofo ultimo;

	public Cena(){
		// al primero en llegar no le falta nada
		primero = FacultadDeFilosofia.getFilosofo(TIPO);
		primero.setPalilloDcha(new Palillo());
		primero.setPalilloIzda(new Palillo());

		Filosofo anterior = ultimo = primero;

		/* Empiezo rellenando en sentido horario */
		for(int i=0; i<NUM_FILOSOFOS-1; i++){
			ultimo = FacultadDeFilosofia.getFilosofo(TIPO);
			// se intercambian saludos
			ultimo.setFilosofoDcha(anterior); 
			anterior.setFilosofoIzda(ultimo);				
			// comparten el palillo del medio
			ultimo.setPalilloDcha(anterior.getPalilloIzda()); 
			ultimo.setPalilloIzda(new Palillo());

			anterior = ultimo;
		}
		// cuando llegan todos y ocupan toda la mesa,
		// el primero conoce al último
		ultimo.setPalilloIzda(primero.getPalilloDcha());
		ultimo.setFilosofoIzda(primero);
		primero.setFilosofoDcha(ultimo);
	}


	public void comer(){
		int comensales = 0;
		Filosofo siguiente = primero;
		Filosofo aux;
		// mientras el nombre del de la izquierda no sea el primero sigue 
		// dadno el turno para empezar
		while(!siguiente.getFilosofoIzda().getNombre().equals(primero.getNombre())){
			// evitamos ponerlo en marcha y que se bloquée obteniendo la referencia al
			// siguiente antes de ponerlo a comer.
			aux = siguiente;
			siguiente = siguiente.getFilosofoIzda();
			aux.start();
			System.out.println(" "+ (comensales++));
		}
		siguiente.start();
		System.out.println(" "+ (comensales++) + "\n");

	}

	public Filosofo getPrimero(){
		return this.primero;
	}
}
