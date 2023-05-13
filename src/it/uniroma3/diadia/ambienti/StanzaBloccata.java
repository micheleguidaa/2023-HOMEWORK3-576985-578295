package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String oggettoCheSblocca;
	
	public StanzaBloccata(String nome,String direzioneBloccata,String oggettoCheSblocca) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.oggettoCheSblocca = oggettoCheSblocca;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.hasAttrezzo(oggettoCheSblocca))
			return super.getStanzaAdiacente(direzione);
		else
			return this;
	}
	
	@Override
	public String getDescrizione() {
			return super.getDescrizione()+"\nLa direzione Bloccata è:"+this.direzioneBloccata+"\nL'oggetto che sblocca è:"+this.oggettoCheSblocca;
			
	}
	
}
