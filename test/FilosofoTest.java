import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import filosofos.Filosofo;
import filosofos.Fotografo;
import filosofos.Palillo;


public class FilosofoTest {
	
	@After
	public void mataAlFotografo(){
		Fotografo.getInstance().destroy();
	}
	
	@Test
	public void emptyConstructorTest() {
		Filosofo f = FacultadDeFilosofia.getFilosofo(TipoFilosofo.STANDAR);
		assertTrue(f.getNombre().length() == 3);
	}

	@Test
	public void comerTest() {
		Filosofo f = FacultadDeFilosofia.getFilosofo(TipoFilosofo.STANDAR);
		f.setPalilloDcha(new Palillo());
		f.setPalilloIzda(new Palillo());
		f.setFilosofoDcha(f);
		f.setFilosofoIzda(f);
		assertTrue("palillo derecho false", f.getPalilloDcha().getPalillo());
		assertTrue("palillo izquierdo false", f.getPalilloIzda().getPalillo());
		boolean palillosAntesDeComer = (f.getPalilloDcha().getPalillo() == f.getPalilloIzda().getPalillo()) == true;
		try {
			System.out.println("TEST: FILOSOFO " + f.getNombre());
			f.comer();
		} catch (InterruptedException e) {
			fail("ERROR: se produjo un error mientras comía el filosofo");
			e.printStackTrace();
		}
		boolean palillosDespuesDeComer = (f.getPalilloDcha().getPalillo() == f.getPalilloIzda().getPalillo()) == true;
		assertTrue(palillosAntesDeComer == palillosDespuesDeComer);
	}
	

	
}
