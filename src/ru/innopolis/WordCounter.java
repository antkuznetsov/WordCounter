package ru.innopolis;

import ru.innopolis.models.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Kuznetsov on 06/04/2017.
 */

public class WordCounter implements Runnable {

    //private ArrayList<Word> wordsList;

    Scanner myText;
    Word w = new Word();
    String fileName;

    Thread t = new Thread(this, "Counter");

    public WordCounter(String fileName) {

        this.fileName = fileName;

        try {

            myText = new Scanner(new File(fileName));

        } catch (FileNotFoundException e) {

            System.out.println("File not found");

        }
        t.start();
    }

    /*
    public void showResultList() {

        ArrayList<Word> wordList = w.getWordsList();

        for (Word word : wordList) {

            System.out.println(word);

        }
    }
    */

    @Override
    public void run() {

        System.out.println("Поток " + t.getName() + " " + fileName + " начался");

        String word;

        try {
            while (myText.hasNext()) {

                word = myText.next();

                word = word.replaceAll("[^A-Za-zА-Яа-я]", ""); // Clear string

                w.addWord(word); // Add word to collection

                System.out.println(word);
            }

            myText.close();
        } catch (NullPointerException e) {
            System.out.println("Fuck");
            e.printStackTrace();
        }

        System.out.println("Поток " + t.getName() + " " + fileName + " закончился");
    }
}