package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List<RichWord> lista ;
	List<String> listaDizionario;
	
	
	
	public Dictionary() {
		super();
		this.lista = new LinkedList<RichWord>();
		this.listaDizionario = new LinkedList<String>();
	}
	public void loadDictionary(String language) {
		this.listaDizionario.clear();
		if(language.equals("English")) {
		try {
			FileReader fr = new FileReader("src/main/resources/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) {
				listaDizionario.add(word);
			// Aggiungere parola alla struttura dati
			}
			br.close();
			 }catch(IOException e){
					System.out.println("Errore nella lettura del file");
				} }
		if(language.equals("Italian")){
			try {
			FileReader fr = new FileReader("src/main/resources/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) {
				listaDizionario.add(word);
			// Aggiungere parola alla struttura dati
			}
			br.close();
			 }
			catch(IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
	}

	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> spellChecked= new ArrayList<RichWord>();
		for(String s: inputTextList) {
			RichWord word= new RichWord(s);
			if(this.listaDizionario.contains(s)) {
				word.setCorrect(true);
				
			}
			spellChecked.add(word);
		}
		return spellChecked;
	}
	/*public List<RichWord> spellCheckTextDichotomic (List<String> inputTextList){
		List<RichWord> spellChecked= new ArrayList<RichWord>();
		int i=this.listaDizionario.size()+1;
		int meta= (Integer) i/2;
		for(String s: inputTextList) {
			RichWord word= new RichWord(s);
			if(s.equals(this.listaDizionario.get(meta))) {
				word.setCorrect(true);
			}
			else if(s>this.listaDizionario.get(meta))
				
	}

 }*/
}
