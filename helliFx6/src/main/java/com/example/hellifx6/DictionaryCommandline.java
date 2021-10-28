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

    public int levenshteinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (Math.min(a, c)) : (Math.min(b, c));
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
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
            if (limit > 20) {
                break;
            }
        }
        return s;
    }

    public String dictionarySearcher_3(String word) {
        String s = "";
        int limit = 0;
        for (int i = 0; i < super.getWords().size(); i++) {
            if (super.getWords().get(i).getWord_target().replaceAll("\\s+","").equalsIgnoreCase(word)) {
                s = super.getWords().get(i).getWord_target()+ "\n" + s;

                limit = limit + 1;
            }
            else if (super.getWords().get(i).getWord_target().contains(word)) {
                s = s + super.getWords().get(i).getWord_target();
                s = s + "\n";
                limit = limit + 1;
            }
            if (limit > 100) {
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

    public String dictionarySearcher_2_1(String word) {
        String s = "";
        int limit = 0;
        for (int i = 0; i < super.getWords().size(); i++) {
            if (this.levenshteinDistance(word, super.getWords().get(i).getWord_target().replaceAll("\\s+","")) == 0) {
                s = super.getWords().get(i).getWord_target() + "       " + super.getWords().get(i).getWord_explain() + "\n" + s;


            }
            else if (this.levenshteinDistance(word, super.getWords().get(i).getWord_target().replaceAll("\\s+","")) <= 1) {
                s = s + super.getWords().get(i).getWord_target() + "       " + super.getWords().get(i).getWord_explain() + "\n";
                limit = limit + 1;
            }
            if (limit > 100) {
                break;
            }
        }
        return s;
    }

    public String dictionarySearcher_3_1(String word) {
        String s = "";
        int limit = 0;
        for (int i = 0; i < super.getWords().size(); i++) {
            if (this.levenshteinDistance(word, super.getWords().get(i).getWord_target().replaceAll("\\s+","")) == 0) {
                s = super.getWords().get(i).getWord_target()+ "\n" + s;


            }
            else if (this.levenshteinDistance(word, super.getWords().get(i).getWord_target().replaceAll("\\s+","")) <= 1) {
                s = s + super.getWords().get(i).getWord_target();
                s = s + "\n";
                limit = limit + 1;
            }
            if (limit > 100) {
                break;
            }
        }
        return s;
    }
}
