package it.uniroma3.diadia;


import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	private Borsa borsaVuota;
	private Borsa borsaConSpada;
	private Borsa borsaConOsso;
	private Borsa borsaConZappaEAscia;
	private Borsa borsaConAsciaEAccendino;
	private Borsa borsaCon2Ossi;
	private Attrezzo spada;
	private Attrezzo osso;
	private Attrezzo ascia;
	private Attrezzo accendino;
	private Attrezzo zappa;
	
	@Before
	public void setup() {
		this.borsaVuota = new Borsa();
		this.spada = new Attrezzo("spada",9);
		this.osso = new Attrezzo("osso",2);
		this.ascia = new Attrezzo("ascia",5);
		this.zappa = new Attrezzo("zappa",5);
		this.accendino = new Attrezzo("acccendino", 1);
		this.borsaConSpada = new Borsa();
		this.borsaConSpada.addAttrezzo(spada);
		this.borsaConOsso =  new Borsa();
		this.borsaConOsso.addAttrezzo(osso);
		this.borsaConZappaEAscia =  new Borsa();
		this.borsaConZappaEAscia.addAttrezzo(zappa);
		this.borsaConZappaEAscia.addAttrezzo(ascia);
		this.borsaConAsciaEAccendino =  new Borsa();
		this.borsaConAsciaEAccendino.addAttrezzo(ascia);
		this.borsaConAsciaEAccendino.addAttrezzo(accendino);
		this.borsaCon2Ossi = new Borsa(); 
		this.borsaCon2Ossi.addAttrezzo(osso);
		this.borsaCon2Ossi.addAttrezzo(osso);
	}

	/* TEST addAttrezzo */

	@Test
	public void testAddAttrezzoNull() {
		assertFalse(borsaVuota.addAttrezzo(null));
	}

	@Test
	public void testAddAttrezzoSuBorsaVuota() {
		assertTrue(borsaVuota.addAttrezzo(spada));
	}

	@Test
	public void testAddAttrezzoSuperamentoPesoMax() {
		assertFalse(borsaConSpada.addAttrezzo(osso));
	}

	@Test
	public void testAddAttrezzoNonSuperamnetoPesoMax() {
		assertTrue(borsaConOsso.addAttrezzo(osso));
	}


	/* TEST removeAttrezzo */

	@Test
	public void testRemoveAttrezzoNull() {
		assertNull(borsaVuota.removeAttrezzo(null));
	}

	@Test
	public void testRemoveAttrezzo1ElementoVoluto() {
		assertEquals(osso,borsaConOsso.removeAttrezzo("osso"));
		assertEquals(0,borsaConOsso.getPeso());//verifico che ora la borsa sia vuota
	}

	@Test
	public void testRemoveAttrezzo1ElementoNonVoluto() {
		assertEquals(null,borsaConOsso.removeAttrezzo("spada"));
		assertEquals(2,borsaConOsso.getPeso());//verifico che ora la borsa non sia vuota
	}

	@Test
	public void testRemoveAttrezzosuArrayCon2ElemtiUguali() {
		//Voglio che rimuova solo il primo
		borsaConOsso.addAttrezzo(osso); //ora ho 2 ossi in borsa
		assertEquals(osso,borsaConOsso.removeAttrezzo("osso"));
		assertTrue(borsaConOsso.hasAttrezzo("osso")); //verifico che sia ancora presente l'altro osso
		assertEquals(2,borsaConOsso.getPeso());//verifico la borsa non sia vuota
	}

	@Test
	public void testgetContenutoOrdinatoPerPesoBorsaVuota() {
		List<Attrezzo> listaVuota = this.borsaVuota.getContenutoOrdinatoPerPeso();
		assertTrue(listaVuota.isEmpty());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerPesoBorsaConSpada() {
		List<Attrezzo> lista = this.borsaConSpada.getContenutoOrdinatoPerPeso();
		assertFalse(lista.isEmpty());
		assertTrue(lista.contains(spada));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerPeso() {
		List<Attrezzo> listaOrdinata = this.borsaConAsciaEAccendino.getContenutoOrdinatoPerPeso();
		assertFalse(listaOrdinata.isEmpty());
		assertEquals(accendino,listaOrdinata.get(0));
		assertEquals(ascia,listaOrdinata.get(1));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerPesoBorsaStessoPeso() {
		List<Attrezzo> listaOrdinata = this.borsaConZappaEAscia.getContenutoOrdinatoPerPeso();
		assertFalse(listaOrdinata.isEmpty());
		assertEquals(ascia,listaOrdinata.get(0)); //ordina confrontando il nome (a parità di peso)
		assertEquals(zappa,listaOrdinata.get(1));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerPesoBorsaStessoOggetto() {
		List<Attrezzo> listaOrdinata = this.borsaCon2Ossi.getContenutoOrdinatoPerPeso();
		assertFalse(listaOrdinata.isEmpty());
		assertEquals(osso,listaOrdinata.get(0)); //ordina confrontando il nome (a parità di peso)
		assertEquals(osso,listaOrdinata.get(1));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeBorsaVuota() {
		Set<Attrezzo> setVuoto = this.borsaVuota.getContenutoOrdinatoPerNome();
		assertTrue(setVuoto.isEmpty());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeBorsaConSpada() {
		SortedSet<Attrezzo> set = this.borsaConSpada.getContenutoOrdinatoPerNome();
		assertFalse(set.isEmpty());
		assertEquals(spada, set.first());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> setOrdinato = this.borsaConZappaEAscia.getContenutoOrdinatoPerNome();
		assertFalse(setOrdinato.isEmpty());
		assertEquals(ascia, setOrdinato.first());
		assertEquals(zappa,setOrdinato.last());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoOggetto() {
		SortedSet<Attrezzo> setOrdinato = this.borsaCon2Ossi.getContenutoOrdinatoPerNome();
		assertEquals(1, setOrdinato.size());//ne contiene solo uno di osso
		assertTrue(setOrdinato.contains(osso));
	}
	
	@Test
	public void testgetContenutoRaggruppatoPerPesoBorsaVuota() {
		Map<Integer,Set<Attrezzo>> mappaVuota = this.borsaVuota.getContenutoRaggruppatoPerPeso();
		assertTrue(mappaVuota.isEmpty());
	}
	
	@Test
	public void testgetContenutoRaggruppatoPerPesoBorsaConSpada() {
		Map<Integer,Set<Attrezzo>> mappa = this.borsaConSpada.getContenutoRaggruppatoPerPeso();
		assertFalse(mappa.isEmpty());
		assertTrue(mappa.get(9).contains(spada));
	}
	
	@Test
	public void testgetContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> mappa = this.borsaConAsciaEAccendino.getContenutoRaggruppatoPerPeso();
		assertEquals(2,mappa.size());
		assertTrue(mappa.get(5).contains(ascia));
		assertTrue(mappa.get(1).contains(accendino));
	}
	
	@Test
	public void testgetContenutoRaggruppatoPerPesoStesstoPeso() {
		Map<Integer,Set<Attrezzo>> mappa = this.borsaConZappaEAscia.getContenutoRaggruppatoPerPeso();
		assertEquals(1,mappa.size());
		assertTrue(mappa.get(5).contains(ascia));
		assertTrue(mappa.get(5).contains(zappa));
	}
	
	@Test
	public void testgetContenutoRaggruppatoPerPesoStesstoOggetto() {
		Map<Integer,Set<Attrezzo>> mappa = this.borsaCon2Ossi.getContenutoRaggruppatoPerPeso();
		assertEquals(1,mappa.size());
		assertTrue(mappa.get(2).contains(osso));//contiene solo un osso
		assertEquals(1,mappa.get(2).size());
	}
	
	@Test
	public void testgetSortedSetOrdinatoPerPesoBorsaVuota() {
		SortedSet<Attrezzo> setVuoto = this.borsaVuota.getSortedSetOrdinatoPerPeso();
		assertTrue(setVuoto.isEmpty());
	}
	
	@Test
	public void testgetSortedSetOrdinatoPerPesoborsaConSpada() {
		SortedSet<Attrezzo> setConSpada = this.borsaConSpada.getSortedSetOrdinatoPerPeso();
		assertFalse(setConSpada.isEmpty());
		assertTrue(setConSpada.contains(spada));
		assertEquals(spada,setConSpada.first());
	}
	
	@Test 
	public void testgetSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> setOrdinato = this.borsaConAsciaEAccendino.getSortedSetOrdinatoPerPeso();
		assertEquals(accendino,setOrdinato.first());
		assertEquals(ascia,setOrdinato.last());
	}
	
	@Test 
	public void testgetSortedSetOrdinatoPerPesoStessoPeso() {
		SortedSet<Attrezzo> setOrdinato = this.borsaConZappaEAscia.getSortedSetOrdinatoPerPeso();
		assertEquals(ascia,setOrdinato.first());
		assertEquals(zappa,setOrdinato.last());
	}
	
	@Test 
	public void testgetSortedSetOrdinatoPerPesoStessoOggetto() {
		SortedSet<Attrezzo> setOrdinato = this.borsaCon2Ossi.getSortedSetOrdinatoPerPeso();
		assertEquals(1,setOrdinato.size());
		assertTrue(setOrdinato.contains(osso));
	}
}
