package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;


	public Partita(){
		this.labirinto = new LabirintoBuilder().getLabirinto();
		this.giocatore= new Giocatore();
		this.finita = false;
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
	}
	
	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		this.giocatore= new Giocatore();
		this.finita = false;
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return stanzaCorrente==labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


	public Labirinto getLabirinto() {
		return labirinto;
	}


	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public void setFinita(boolean finita) {
		this.finita = finita;
	}	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu()>0) {
			return true;
		}
		else {
			return false;
		}
	}


}
