package com.example.hellifx6;

import javafx.scene.shape.HLineTo;

import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {
    public DictionaryCommandline() {
        this.insertFromFile();
    }

    public void showAllWord() {
        int index = 0;
        System.out.format("%-15s %-15s %-15s\n",
                "No",
                "| English"
                , "| Vietnamese");
        for (int i = 0; i < super.getWords().size(); i++) {
            System.out.format("%-15s %-15s %-15s\n",
                    index,
                    super.getWords().get(index).getWord_target()
                    , super.getWords().get(index).getWord_explain());
            index += 1;
        }

    }

    public void dictionaryBasic() {
        super.insertFromCommandline();
        this.showAllWord();
    }

    public void dictionaryAdvanced() {
        super.insertFromFile();
        //this.showAllWord();
        //super.dictionaryLookup();
    }

    public void dictionarySearcher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu ban muon tim:");
        String target = sc.nextLine();
        System.out.format("%-15s %-15s %-15s\n",
                "No",
                "| English"
                , "| Vietnamese");
        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().contains(target)) {
                System.out.format("%-15s %-15s %-15s\n",
                        i,
                        super.getWords().get(i).getWord_target()
                        , super.getWords().get(i).getWord_explain());
            }
        }
    }

    public String dictionarySearcher_2(String word) {
        String s = "";
        int limit = 0;
        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().contains(word)) {
                s = s + super.getWords().get(i).getWord_target();
                s = s + "       ";
                s = s + super.getWords().get(i).getWord_explain() + "\n";
                limit = limit + 1;
            }
            if (limit > 10) {
                break;
            }
        }
        return s;
    }

    public String dictionarySearcher_3(String word) {
        String s = "";
        int limit = 0;
        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().contains(word)) {
                s = s + super.getWords().get(i).getWord_target();
                s = s + "\n";
                limit = limit + 1;
            }
            if (limit > 50) {
                break;
            }
        }
        return s;
    }

    public boolean checkWord_1(String word) {
        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().replaceAll("\\s+","").equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    public void removeWord_3(String word) {

        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().replaceAll("\\s+","").equalsIgnoreCase(word)) {
                super.getWords().remove(i);
            }
        }
    }

    public void editWord_3(String target, String explain) {
        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().replaceAll("\\s+","").equalsIgnoreCase(target)) {
                super.getWords().get(i).setWord_explain(explain);
            }
        }
    }

    public void addWord_3(String target, String explain) {
        Word word = new Word(target, explain);
        super.getWords().add(word);
    }


}
