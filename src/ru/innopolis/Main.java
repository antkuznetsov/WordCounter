package ru.innopolis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            String word;
            Scanner myText = new Scanner(new File("text.txt"));

            WordCounter counter = new WordCounter();

            while (myText.hasNext()) {

                word = myText.next();

                word = word.replaceAll("[^A-Za-zА-Яа-я]", ""); // Clear string

                counter.addWord(word); // Add word to collection
            }

            myText.close();

            counter.showResultList();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");

        }
    }
}