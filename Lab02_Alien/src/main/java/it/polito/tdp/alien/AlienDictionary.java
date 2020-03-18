package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;
	
	public AlienDictionary() {
		dictionary=new ArrayList<Word>();
	}

	public void addWord(String alienWord, String translation) {
		Word nuovaWord;
		for(Word w:dictionary) {
			if(w.getAlienWord().equals(alienWord)) {
				w.setTranslation(translation);
			}
		}
		nuovaWord=new Word(alienWord, translation);
		dictionary.add(nuovaWord);
	}
	
	public String translateWord(String alienWord) {
		for(Word w:dictionary) {
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		}
		return null;
	}
}
