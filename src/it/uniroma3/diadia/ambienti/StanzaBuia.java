package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String oggettoLuminoso;//oggetto che consente di avere la descrizione completa della stanza
	
	
	public StanzaBuia(String nome,String oggettoLuminoso) {
		super(nome);
		this.oggettoLuminoso = oggettoLuminoso;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(oggettoLuminoso))
			return "qui c'è buio pesto";
		else
			return super.getDescrizione();
	}
	
	
	
}
