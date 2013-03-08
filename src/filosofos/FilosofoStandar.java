package filosofos;

import java.util.Random;


public class FilosofoStandar extends Filosofo{

	/*
	 * Sincroniza primero el palillo derecho y luego el izquierdo
	 * Puede darse la condición de carrera de que todos los comensales
	 * sincronicen el palillo derecho a la vez ---> condicion de carrera
	 * @see Filosofo#comer()
	 */
	@Override
	public void comer() throws InterruptedException{
		while(true){
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
}
