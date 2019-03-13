package it.polito.tdp.alien;

import java.util.List;
import java.util.LinkedList;

public class AlienDictionary {
	private List<Word> dictionary;

	public AlienDictionary() {
		dictionary = new LinkedList<Word>();
	}
	
	public List<Word> getDictionary() {
		return dictionary;
	}

	public void addWord(String alienWord, String translation) {
		for(Word w : dictionary)
			if(w.getAlienWord().compareTo(alienWord)==0) {
				w.setTranslation(translation);
				return;
			}
		Word newWord = new Word(alienWord, translation);
		dictionary.add(newWord);
		
	}
	
	public String translateWord(String alienWord) {
		for(Word w : dictionary)
			if(w.getAlienWord().compareTo(alienWord)==0) {
				return w.getTranslation();
			}
		return null;
	}

}
