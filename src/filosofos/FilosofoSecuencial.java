package filosofos;

import java.util.Random;


public class FilosofoSecuencial extends Filosofo {

	/*
	 * Sincroniza la función de comer de forma que solo pueda comer uno a la vez
	 * @see Filosofo#comer()
	 */
	@Override
	public synchronized void comer() throws InterruptedException {
		Fotografo.getInstance().dibujaFilosofos(this);
		Thread.sleep((new Random()).nextInt(5000));		// think();
		this.getPalilloDcha().usarPalillo();
		this.getPalilloIzda().usarPalillo();
		Fotografo.getInstance().dibujaFilosofos(this);
		Thread.sleep((new Random()).nextInt(5000));		// eat();
		this.getPalilloIzda().soltarPalillo();
		this.getPalilloDcha().soltarPalillo();
	}
}