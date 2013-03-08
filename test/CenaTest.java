import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import filosofos.Fotografo;


public class CenaTest {

	@Test
	public void constructorCenaTest() {
		Cena c = new Cena();
		System.out.println("TEST: CENA");
		c.comer();
		assertTrue(true);
	}
	
	@After
	public void mataAlFotografo(){
		Fotografo.getInstance().destroy();
	}
}
