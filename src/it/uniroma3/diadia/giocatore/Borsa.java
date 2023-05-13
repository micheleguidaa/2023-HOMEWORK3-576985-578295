package it.uniroma3.diadia.giocatore;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA); 
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>(); // speriamo bastino...
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo==null||this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
		this.attrezzi.add(attrezzo);
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.attrezzi.size(); i++)
			if (this.attrezzi.get(i)!=null&&this.attrezzi.get(i).getNome().equals(nomeAttrezzo))
				a = attrezzi.get(i);
		return a; 
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.size(); i++) {
			if(this.attrezzi.get(i)!=null)
				peso += this.attrezzi.get(i).getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	/**
	 * Rimuove un attrezzo dalla borsa (ricerca in base al nome).
	 * In modo tale da avere tutti gli elementi presenti nell'array adiacenti(senza avere null presenti in mezzo)
	 * @param nomeAttrezzo
	 * @return l'indirizzo dell'attrezzo che e' stato rimosso, null altrimenti
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(this.attrezzi.size()>=1) {
			a = this.getAttrezzo(nomeAttrezzo);
			this.attrezzi.remove(a);
		}

		return a;
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaOrdinataPerPeso = new ArrayList<>(this.attrezzi); 
		Collections.sort(listaOrdinataPerPeso,new ComparatorePerPeso());
		return listaOrdinataPerPeso;	
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> setOrdinatoPerPeso = new TreeSet<>(this.attrezzi);
		return setOrdinatoPerPeso;
	}

	public  SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> setOrdinatoPerNome = new TreeSet<>(new ComparatorePerNome());
		setOrdinatoPerNome.addAll(this.attrezzi);
		return setOrdinatoPerNome;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> gruppoPerPeso = new HashMap<>();
		Set<Attrezzo> setAttrezzoStessoPeso;
		for(Attrezzo a:this.attrezzi) {
			if(!gruppoPerPeso.containsKey(a.getPeso())) {
				setAttrezzoStessoPeso = new HashSet<>();
				setAttrezzoStessoPeso.add(a);
				gruppoPerPeso.put(a.getPeso(), setAttrezzoStessoPeso);
			}
			else {
				setAttrezzoStessoPeso = gruppoPerPeso.get(a.getPeso());
				setAttrezzoStessoPeso.add(a);
				gruppoPerPeso.put(a.getPeso(), setAttrezzoStessoPeso);
			}
		}
		return gruppoPerPeso;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Attrezi nella borsa: ");
			for(Attrezzo a: this.attrezzi)
			s.append(a.toString()+ " ");
			s.append("\nPeso borsa: "+this.getPeso()+ "kg");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public String getDescrizione() {
		return this.toString();
	}


}

