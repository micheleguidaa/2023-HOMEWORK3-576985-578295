package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "prendi", "posa","guarda", "aiuto", "fine"};

	public ComandoAiuto() {}

	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");

	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getParametro() {
		return null;		
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

}
