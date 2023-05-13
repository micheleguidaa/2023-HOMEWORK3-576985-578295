package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	Partita partita ;
	
	@Before
	public void setUp() {
		partita = new Partita();
	}


	@Test
	public void testIsFinitaTramiteSet() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}


}
