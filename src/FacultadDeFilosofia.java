import filosofos.Filosofo;
import filosofos.FilosofoClase;
import filosofos.FilosofoSecuencial;
import filosofos.FilosofoStandar;

/*
 * Factory para generar el filosofo que quiera en cada momento
 */
public class FacultadDeFilosofia {
	
	public static Filosofo getFilosofo(TipoFilosofo tipo){
		switch(tipo){
		case STANDAR:
			return new FilosofoStandar();
		case IZQUIERDA:
			return new FilosofoClase();
		case SECUENCIAL:
			return new FilosofoSecuencial();
		default:
			return new FilosofoStandar();
		}
	}
}
