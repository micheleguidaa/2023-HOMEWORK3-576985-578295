package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{

	private String nomeAttrezzo;

	public ComandoPosa() {
		this.nomeAttrezzo=null;
	}

	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}

	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Cosa vuoi posare?");
		}
		else {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				if(partita.getStanzaCorrente().getNumeroAttrezzi()>=partita.getStanzaCorrente().getNumeroMassimoAttrezzi()) {
					io.mostraMessaggio("Non è possibile posare l'attrezzo perchè la stanza è piena");
				}
				else {
					Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
					partita.getStanzaCorrente().addAttrezzo(attrezzo);
					partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
					io.mostraMessaggio("L'oggetto è stato posato!");
				}

			}
			else {
				io.mostraMessaggio("L'oggetto non è presente nella borsa!");
			}
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU: "+partita.getGiocatore().getCfu());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "posa";
	}

}
