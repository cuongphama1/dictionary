package com.example.hellifx6;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<Word>();

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public boolean searchWord(String search_word) {
        for (int i = 0; i < words.size(); i++) {
            if (search_word.equalsIgnoreCase(words.get(i).getWord_target())) {
                return true;
            }
        }
        return false;
    }

    public int searchWordIndex(String search_word) {
        for (int i = 0; i < words.size(); i++) {
            if (search_word.equalsIgnoreCase(words.get(i).getWord_target())) {
                return i;
            }
        }
        return -1;
    }
}
