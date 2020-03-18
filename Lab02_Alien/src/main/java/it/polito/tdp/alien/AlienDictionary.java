package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> dictionary;
	
	public AlienDictionary() {
		dictionary=new ArrayList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		WordEnhanced nuovaWord;
		for(WordEnhanced w:dictionary) {
			if(w.getAlienWord().equals(alienWord)) {
				w.getTranslation().add(translation);
			}
		}
		
		nuovaWord=new WordEnhanced(alienWord, translation);
		dictionary.add(nuovaWord);
	}
	
	public List<String> translateWord(String alienWord) {
		for(WordEnhanced w:dictionary) {
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		}
		return null;
	}
}
