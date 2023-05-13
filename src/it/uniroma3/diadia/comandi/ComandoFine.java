package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	public ComandoFine() {}

	@Override
	public void esegui(Partita partita) {
		IO io=new IOConsole();
		io.mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita(true);
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "fine";
	}

}
