package it.uniroma3.diadia.ambienti;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String,Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;




	public static int getNumeroMassimoAttrezzi() {
		return NUMERO_MASSIMO_ATTREZZI;
	}

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	
	
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>() ;
		this.attrezzi = new HashMap<>() ;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(direzione.equals("nord")||direzione.equals("sud")||direzione.equals("ovest")||direzione.equals("est"))
		this.stanzeAdiacenti.put(direzione,stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<Attrezzo>(this.attrezzi.values());
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (attrezzo!=null&&this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI&&!this.attrezzi.containsKey(attrezzo.getNome())) {
			this.attrezzi.put(attrezzo.getNome(),attrezzo);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Stanza Corrente: "+this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.stanzeAdiacenti.keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");

		for(Attrezzo a : this.attrezzi.values()) {
			risultato.append(a.toString()+"");
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		attrezzoCercato=this.attrezzi.get(nomeAttrezzo);// restituisce il valore della key se presente

		return attrezzoCercato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * In modo tale da avere tutti gli elementi presenti nell'array adiacenti(senza avere null presenti in mezzo)
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean trovato = false;
		Attrezzo attrezzoCercato = null;
		if(this.attrezzi.size()>=1) {
			attrezzoCercato=this.attrezzi.remove(attrezzo.getNome());
			if(attrezzoCercato!=null) {
				trovato=true;
			}
		}
		return trovato;
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome())&&this.getAttrezzi().equals(that.getAttrezzi());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode()+this.getAttrezzi().hashCode();
	}


	public List<String> getDirezioni() {
		return new ArrayList<String>(this.stanzeAdiacenti.keySet());

	}
	
	public Map<String,Stanza> getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}
	
	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
	

}