package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private final int SOGLIA_MAGICA_DEFAULT=3;

	public StanzaMagicaProtected(String nome) {
		super(nome);	
		this.sogliaMagica = SOGLIA_MAGICA_DEFAULT;
		this.contatoreAttrezziPosati = 0;
	}

	public StanzaMagicaProtected(String nome,int soglia) {
		super(nome);	
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;
	}

	@Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
       this.contatoreAttrezziPosati++;
       if (this.contatoreAttrezziPosati > this.sogliaMagica)
          attrezzo = this.modificaAttrezzo(attrezzo);
       if (this.numeroAttrezzi<this.attrezzi.length) {
          this.attrezzi[this.numeroAttrezzi] = attrezzo;
          this.numeroAttrezzi++;
          return true;
}
      else return false;
    }

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito  = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
				pesoX2);
		return attrezzo;
	}

}
