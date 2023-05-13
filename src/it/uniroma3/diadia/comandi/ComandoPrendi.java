package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{

	private String nomeAttrezzo;


	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

	public ComandoPrendi() {
		this.nomeAttrezzo=null;
	}

	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Cosa vuoi prendere?");
		}
		else {
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(attrezzo!=null&&partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				if(partita.getGiocatore().getBorsa().getPeso()+attrezzo.getPeso()>=partita.getGiocatore().getBorsa().getPesoMax()) {
					io.mostraMessaggio("L'oggetto non può essere preso perchè non riesce ad entrare nella borsa!");
				}
				else {
					partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
					partita.getStanzaCorrente().removeAttrezzo(attrezzo);
					io.mostraMessaggio("Oggetto preso!");
				}
			}

			else {
				io.mostraMessaggio("L'oggetto non è presente nella stanza corrente!");
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
		return "prendi";
	}

}
