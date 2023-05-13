package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;

public class ComandoFineTest {
	private Comando fine = new ComandoFine();
	private Partita partita = new Partita();
	
	@Test
	public void testGetParametroNull() {
		assertNull(fine.getParametro());
	}
	
	@Test
	public void testFinita() {
		fine.esegui(partita);
		assertTrue(partita.isFinita());
	}

}
