package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;


public class ComandoPosaTest {

	private Comando posa = new ComandoPosa();

	@Test
	public void testGetParametroNull() {
		assertNull(posa.getParametro());
	}
	
	@Test
	public void testSetParametroTrue() {
		posa.setParametro("osso");
		assertEquals("osso",posa.getParametro());
	}
	
	@Test
	public void testSetParametroFalse() {
		posa.setParametro("cane");
		assertNotEquals("osso",posa.getParametro());
	}

}
