package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {
	private Comando prendi = new ComandoPrendi();

	@Test
	public void testGetParametroNull() {
		assertNull(prendi.getParametro());
	}
	
	@Test
	public void testSetParametroTrue() {
		prendi.setParametro("osso");
		assertEquals("osso",prendi.getParametro());
	}
	
	@Test
	public void testSetParametroFalse() {
		prendi.setParametro("cane");
		assertNotEquals("osso",prendi.getParametro());
	}

}
