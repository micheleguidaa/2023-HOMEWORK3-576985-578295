package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata atrio = new StanzaBloccata("atrio","sud","chiave");
	private Stanza cucina = new Stanza("cucina");
	private Attrezzo chiave = new Attrezzo("chiave", 2);
	private Attrezzo osso = new Attrezzo("osso", 1);
	
	@Test
	public void testGetStanzaAdiacenteSenzaChiave1() {
		assertEquals(atrio,atrio.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSenzaChiave2() {
		atrio.impostaStanzaAdiacente("sud", cucina);
		atrio.addAttrezzo(osso);
		assertEquals(atrio,atrio.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConChiave() {
		atrio.impostaStanzaAdiacente("sud", cucina);
		atrio.addAttrezzo(chiave);
		assertEquals(cucina,atrio.getStanzaAdiacente("sud"));
	}
	


}
