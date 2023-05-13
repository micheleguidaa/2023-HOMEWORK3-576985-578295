package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private ComandoVai vai = new ComandoVai();
	private Partita partita = new Partita();
	
	@Test
	public void testGetParametroNull() {
		assertNull(vai.getParametro());
	}
	
	@Test
	public void testSetParametroTrue() {
		vai.setParametro("sud");
		assertEquals("sud",vai.getParametro());
	}
	
	@Test
	public void testSetParametroFalse() {
		vai.setParametro("sud");
		assertNotEquals("nord",vai.getParametro());
	}
	
	
	
}
