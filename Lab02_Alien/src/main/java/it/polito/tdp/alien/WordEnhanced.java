package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translation=new ArrayList<String>();;
	
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation.add(translation); 
	}


	public List<String> getTranslation() {
		return translation;
	}


	public String getAlienWord() {
		return alienWord;
	}
	
	

}
