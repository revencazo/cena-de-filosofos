package filosofos;
public class Palillo {
	private boolean palilloEnUso;
	
	public Palillo(){
		this.palilloEnUso = true;
	}
	
	public void usarPalillo(){
		this.palilloEnUso = false;
	}
	
	public void soltarPalillo(){
		this.palilloEnUso = true;
	}
	
	public boolean getPalillo(){
		return this.palilloEnUso;
	}
}