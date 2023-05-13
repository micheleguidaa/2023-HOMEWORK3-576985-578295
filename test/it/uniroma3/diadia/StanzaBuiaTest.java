package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanzaBuia = new StanzaBuia("cantina","lanterna");
	private Attrezzo lanterna = new Attrezzo("lanterna", 2);
	private Attrezzo osso = new Attrezzo("osso", 1);
	
	@Test
	public void testGetDescrizioneSenzaLanterna1() {
		assertEquals("qui c'è buio pesto",stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaLanterna2() {
		stanzaBuia.addAttrezzo(osso);
		assertNotEquals(stanzaBuia.toString(),stanzaBuia.getDescrizione());
		assertEquals("qui c'è buio pesto",stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneConLanterna() {
		stanzaBuia.addAttrezzo(lanterna);
		assertEquals(stanzaBuia.toString(),stanzaBuia.getDescrizione());
	}



}
