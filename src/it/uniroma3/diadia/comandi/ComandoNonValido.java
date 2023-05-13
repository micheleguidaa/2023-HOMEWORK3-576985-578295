package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	public ComandoNonValido() {}
	@Override
	public void esegui(Partita partita) {
		IO io=new IOConsole();
		io.mostraMessaggio("Comando non valido!");
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);

	}
	@Override
	public void setParametro(String parametro) {}
	
	@Override
	public String getParametro() {
		return null;
	}
	@Override
	public String getNome() {
		return "comando non valido";
	}



}
