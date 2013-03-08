package filosofos;

import java.util.UUID;

public abstract class Filosofo extends Thread{
	private final String nombreFilosofo;

	private Filosofo filosofoDcha;
	private Filosofo filosofoIzda;

	private Palillo palilloDcha;
	private Palillo palilloIzda;

	/* Le pone un nombre aleatorio de 3 caracteres */
	public Filosofo(){
		this.nombreFilosofo = UUID.randomUUID().toString().substring(0, 3).toUpperCase();
	}

	public Filosofo(String nombre){
		this.nombreFilosofo = nombre;
	}

	
	
	@Override
	public void run() {
		try {
			comer();
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	public abstract void comer() throws InterruptedException;


	public Filosofo getFilosofoDcha() {
		return filosofoDcha;
	}

	public void setFilosofoDcha(Filosofo filosofoDcha) {
		this.filosofoDcha = filosofoDcha;
	}

	public Filosofo getFilosofoIzda() {
		return filosofoIzda;
	}

	public void setFilosofoIzda(Filosofo filosofoIzda) {
		this.filosofoIzda = filosofoIzda;
	}

	public Palillo getPalilloDcha() {
		return palilloDcha;
	}

	public void setPalilloDcha(Palillo palilloDcha) {
		this.palilloDcha = palilloDcha;
	}

	public Palillo getPalilloIzda() {
		return palilloIzda;
	}

	public void setPalilloIzda(Palillo palilloIzda) {
		this.palilloIzda = palilloIzda;
	}

	public String getNombre(){
		return this.nombreFilosofo;
	}
}
