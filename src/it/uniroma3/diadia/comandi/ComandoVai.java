package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{

	private String direzione;

	@Override
	public void setParametro(String parametro) {
		this.direzione =parametro;

	}
	
	public ComandoVai() {
		this.direzione = null;
	}

	@Override
	public void esegui(Partita partita) {
		IO io= new IOConsole();
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null) {
				io.mostraMessaggio("Direzione inesistente");
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			}
			else {
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu();
				partita.getGiocatore().setCfu(cfu--);
			}
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			io.mostraMessaggio("CFU: "+partita.getGiocatore().getCfu());
			io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
		}

	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

	@Override
	public String getNome() {
		return "vai";
	}

}
