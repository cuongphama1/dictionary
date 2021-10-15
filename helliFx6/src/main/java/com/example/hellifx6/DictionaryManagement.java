package com.example.hellifx6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import javax.imageio.IIOException;

public class DictionaryManagement extends Dictionary {


    public void insertFromCommandline() {
        System.out.println("Nhap so tu ban muon them");
        Scanner sc = new Scanner(System.in);
        int word_amount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < word_amount; i++) {
            //String word_target = sc.nextLine();
            //String word_explain = sc.nextLine();
            Word word = new Word(sc.nextLine(), sc.nextLine());
            super.addWord(word);
        }
    }

    public void insertFromFile() {
        try {

            Scanner scanner = new Scanner(System.in);
            Path path = Path.of("C:\\Users\\HP\\IdeaProjects\\helliFx\\src\\main\\java\\com\\example\\hellifx\\Dictionaries.txt");
            List<String> word_data_List = Files.readAllLines(path);
           /* System.out.println(word_data_List.get(0));
            Word word = new Word(word_data_List.get(0), word_data_List.get(1));
            super.addWord(word); */

            for (String word_data : word_data_List) {
                String[] data = word_data.split("#");
                String s = "";
                for (int i = 1; i < data.length; i++) {
                    s = s + data[i] + "\n";
                }
                Word word = new Word(data[0], s);
                super.addWord(word);
            }

        } catch (IOException e) {
            System.out.println("error insertFromFile");
        }
    }

    public void dictionaryLookup() {
        System.out.println("Nhap tu ban muon tim: ");
        Scanner sc = new Scanner(System.in);
        String search_word = sc.nextLine();
        for (int i = 0; i < super.getWords().size(); i++) {
            if (search_word.equalsIgnoreCase(super.getWords().get(i).getWord_target())) {
                System.out.println(super.getWords().get(i).getWord_explain());
            }
        }

    }


    public void addWordFromCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu ban muon add:");
        String target = sc.nextLine();
        if (super.searchWord(target)) {
            System.out.println("Tu nay da co trong danh sach");
        } else {
            System.out.println("Nhap giai nghia:");
            String explain = sc.nextLine();
            Word word = new Word(target, explain);
            super.addWord(word);
        }
    }

    public void removeWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu ban muon xoa:");
        String target = sc.nextLine();
        if (super.searchWord(target)) {
            int index = super.searchWordIndex(target);
            super.getWords().remove(index);
        } else {
            System.out.println("Khong tim thay tu can xoa");
        }
    }


    public void editWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu ban muon sua:");
        String target = sc.nextLine();
        if (super.searchWord(target)) {
            System.out.println("Nhap giai nghia:");
            String explain = sc.nextLine();
            int index = super.searchWordIndex(target);
            super.getWords().get(index).setWord_explain(explain);
        } else {
            System.out.println("Khong tim thay tu ban muon sua");
        }
    }

    public void dictionaryExportToFile() {
        try {
            FileWriter wr = new FileWriter("C:\\New folder (2)\\dictionary demo 2\\src\\myDictionary.txt");
            BufferedWriter bw = new BufferedWriter(wr);
            for (int i = 0; i < super.getWords().size(); i++) {
                bw.write(super.getWords().get(i).getWord_target());
                bw.write(";");
                bw.write(super.getWords().get(i).getWord_explain());
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Khong the them du lieu");
        }
    }

}
