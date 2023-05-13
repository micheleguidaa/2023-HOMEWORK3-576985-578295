package it.uniroma3.diadia.attrezzi;

import java.util.*;

public class ComparatorePerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		if(o1.getPeso()-o2.getPeso()!=0)
			return o1.getPeso()-o2.getPeso();
		else
			return o1.getNome().compareTo(o2.getNome());
	}
	
}
