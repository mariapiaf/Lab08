package it.polito.tdp.extflightdelays.model;

public class Connessione {

	private Airport a1;
	private Airport a2;
	private int peso;
	
	public Connessione(Airport a1, Airport a2, int peso) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.peso = peso;
	}


	public Airport getA1() {
		return a1;
	}


	public void setA1(Airport a1) {
		this.a1 = a1;
	}


	public Airport getA2() {
		return a2;
	}


	public void setA2(Airport a2) {
		this.a2 = a2;
	}


	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}
