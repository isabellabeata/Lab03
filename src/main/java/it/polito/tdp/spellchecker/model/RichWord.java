package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parola;
	private boolean correct=false;

	public RichWord(String parola) {
		super();
		this.parola = parola;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	

}
