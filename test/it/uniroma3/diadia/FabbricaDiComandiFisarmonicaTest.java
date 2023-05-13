package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {
	public FabbricaDiComandi fbdc = new FabbricaDiComandiFisarmonica();
	public Comando comando;

	@Test
	public void testCostruisciComandoNonValido1() {
		comando=fbdc.costruisciComando("");
		assertEquals("comando non valido",comando.getNome());
	}

	@Test
	public void testCostruisciComandoNonValido2() {
		comando=fbdc.costruisciComando("preeendi");
		assertEquals("comando non valido",comando.getNome());
	}
	
	@Test
	public void testCostruisciComandoVai() {
		comando=fbdc.costruisciComando("vai");
		assertEquals("vai",comando.getNome());
	}
	
	@Test
	public void testCostruisciComandoPrendi() {
		comando=fbdc.costruisciComando("prendi");
		assertEquals("prendi",comando.getNome());
	}
	
	@Test
	public void testCostruisciComandoPosa() {
		comando=fbdc.costruisciComando("posa");
		assertEquals("posa",comando.getNome());
	}
	
	@Test
	public void testCostruisciComandoaiuto() {
		comando=fbdc.costruisciComando("aiuto");
		assertEquals("aiuto",comando.getNome());
	}
	
	@Test
	public void testCostruisciComandoFine() {
		comando=fbdc.costruisciComando("fine");
		assertEquals("fine",comando.getNome());
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		comando=fbdc.costruisciComando("guarda");
		assertEquals("guarda",comando.getNome());
	}
}
